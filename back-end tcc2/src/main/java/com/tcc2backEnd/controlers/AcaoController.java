package com.tcc2backEnd.controlers;

import com.tcc2backEnd.models.Acao;
import com.tcc2backEnd.models.AcaoSalva;
import com.tcc2backEnd.payload.request.AcaoSalvaRequest;
import com.tcc2backEnd.services.AcaoSalvaService;
import com.tcc2backEnd.services.AcaoServiceClient;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/acao")
public class AcaoController {

    @Autowired
    AcaoServiceClient acaoServiceClient;
    @Autowired
    private AcaoSalvaService acaoSalvaService;

    @GetMapping("/{ticker}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Acao> getAcaoAnalisada(@PathVariable("ticker") String ticker) {
        Acao acao = acaoServiceClient.getAcaoAnalisada(ticker).block();

        return ResponseEntity.ok(acao); // Retorna 200 OK com a ação encontrada
    }

    @GetMapping("/salva/{ticker}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Boolean isAcaoSalva(@PathVariable String ticker) {
        return acaoSalvaService.isAcaoSalvaForUser(ticker);
    }

    @GetMapping("/getAllSalvas")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<AcaoSalva> getAllTickers() {
        return acaoSalvaService.getAcoesSalvasPorUsuario();
    }

    @PostMapping("/salvar")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> salvarAcao(@Valid @RequestBody AcaoSalvaRequest acaoSalvaRequest) {
        try {
            AcaoSalva acaoSalva = acaoSalvaService.salvarAcao(acaoSalvaRequest.getTicker());
            return ResponseEntity.ok("Ação '" + acaoSalva.getTicker() + "' salva com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar ação: " + e.getMessage());
        }
    }

    @PostMapping("/excluir")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> excluirAcao(@Valid @RequestBody AcaoSalvaRequest acaoSalvaRequest) {
        try {
            acaoSalvaService.excluirAcao(acaoSalvaRequest.getTicker());
            return ResponseEntity.ok("Ação '" + acaoSalvaRequest.getTicker() + "' excluída com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao excluir ação: " + e.getMessage());
        }
    }
}
