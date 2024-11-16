package com.tcc2backEnd.services;

import com.tcc2backEnd.models.*;
import com.tcc2backEnd.models.Acao;
import com.tcc2backEnd.models.ResponseWrapper;
import com.tcc2backEnd.repository.UserRepository;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Value;

@Service
public class AcaoServiceClient {

    private final WebClient webClient;
    private AcaoSalvaService acaoSalvaService;

    @Value("${security.token}")
    private String token;

    @Autowired
    public AcaoServiceClient(WebClient.Builder webClientBuilder,AcaoSalvaService acaoSalvaService) {
        this.webClient = webClientBuilder.baseUrl("https://brapi.dev").build();
        this.acaoSalvaService = acaoSalvaService;
    }

    public Mono<ResponseWrapper> getDadosAcaoApi(String ticker) {
        return webClient.get()
                .uri("/api/quote/" + ticker + "?range=1y&modules=defaultKeyStatistics,financialData&token=" + token)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> {
                    if (clientResponse.statusCode() == HttpStatus.NOT_FOUND) {
                        return Mono.error(new RuntimeException("Recurso não encontrado para o ticker: " + ticker));
                    }
                    return Mono.error(new RuntimeException("Erro de cliente: " + clientResponse.statusCode()));
                })
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse ->
                        Mono.error(new RuntimeException("Erro do servidor: " + clientResponse.statusCode()))
                )
                .bodyToMono(ResponseWrapper.class);
    }

    public Mono<Acao> getAcaoAnalisada(String ticker) {
        boolean estaSalva = acaoSalvaService.isAcaoSalvaForUser(ticker);
        return getDadosAcaoApi(ticker)
                .flatMap(responseWrapper -> {
                    Acao acao = new Acao();
                    Analisador analisador = new Analisador();
                    if (responseWrapper.getResults() != null && !responseWrapper.getResults().isEmpty()) {
                        acao = analisador.analisarAcao(responseWrapper.getResults().get(0),estaSalva);
                    }
                    return Mono.just(acao);
                })
                .onErrorResume(e -> {
                    // Tratamento de erro reativo, se necessário
                    return Mono.empty(); // ou um valor padrão ou uma exceção personalizada
                });
    }
}
