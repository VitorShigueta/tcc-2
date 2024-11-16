package com.tcc2backEnd.services;

import com.tcc2backEnd.models.AcaoSalva;
import com.tcc2backEnd.models.User;
import com.tcc2backEnd.repository.AcaoSalvaRepository;
import com.tcc2backEnd.repository.UserRepository;
import com.tcc2backEnd.security.services.UserDetailsImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcaoSalvaService {
    @Autowired
    private AcaoSalvaRepository acaoSalvaRepository;

    @Autowired
    private UserRepository userRepository;

    public AcaoSalvaService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private User getAuthenticatedUser() {
        // Obtém a autenticação do usuário
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Certifique-se de que o usuário está autenticado
        if (authentication != null && authentication.isAuthenticated()) {
            // Obtém o UserDetails (implementação personalizada ou a default)
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            // Obtém o nome do usuário (username)
            String username = userDetails.getUsername();

            // Recupera o usuário do banco de dados
            return userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
        }
        throw new UsernameNotFoundException("Usuário não autenticado");
    }

    @Transactional
    public AcaoSalva salvarAcao(String ticker) {
        User user = getAuthenticatedUser();
        AcaoSalva acaoSalva = new AcaoSalva();
        acaoSalva.setTicker(ticker);
        acaoSalva.setUser(user);
        return acaoSalvaRepository.save(acaoSalva);
    }

    @Transactional
    public void excluirAcao(String ticker) {
        User user = getAuthenticatedUser();
        AcaoSalva acaoSalva = acaoSalvaRepository.findByTickerAndUser(ticker, user)
                .orElseThrow(() -> new RuntimeException("Ação não encontrada para o usuário."));
        acaoSalvaRepository.delete(acaoSalva);
    }

    public Boolean isAcaoSalvaForUser(String ticker) {
        // Obtém a autenticação do usuário

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Verifica se o usuário está autenticado
        if (authentication == null || !authentication.isAuthenticated()) {
            return false; // Se não estiver autenticado, retorna false
        }
        // Obtém o nome de usuário
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();

        // Busca o usuário no banco de dados
        Optional<User> userOpt = userRepository.findByUsername(username);

        // Se o usuário não for encontrado, retorna false
        if (!userOpt.isPresent()) {
            return false;
        }

        User user = userOpt.get();
        // Verifica se a ação está salva para o usuário com o ticker informado
        return acaoSalvaRepository.existsByUserAndTicker(user, ticker); // Retorna diretamente o resultado
    }

    public List<AcaoSalva> getAcoesSalvasPorUsuario() {
        // Obtém o nome de usuário do usuário logado
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return List.of(); // Retorna uma lista vazia se não estiver autenticado
        }

        String username = ((UserDetails) authentication.getPrincipal()).getUsername();

        // Busca o usuário no banco de dados
        return userRepository.findByUsername(username)
                .filter(user -> user instanceof User) // Verifica se o usuário existe
                .map(user -> acaoSalvaRepository.findAllByUser((User) user)) // Obtém todas as ações salvas
                .orElse(List.of()); // Se o usuário não for encontrado, retorna uma lista vazia
    }
}
