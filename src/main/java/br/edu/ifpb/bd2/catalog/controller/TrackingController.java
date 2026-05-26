package br.edu.ifpb.bd2.catalog.controller;

import br.edu.ifpb.bd2.catalog.model.Visualizacao;
import br.edu.ifpb.bd2.catalog.model.dto.TrackingInputDto;
import br.edu.ifpb.bd2.catalog.repository.VisualizacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TrackingController {

    private final VisualizacaoRepository visualizacaoRepository;

    public TrackingController(VisualizacaoRepository visualizacaoRepository) {
        this.visualizacaoRepository = visualizacaoRepository;
    }

    @PostMapping("/tracking/visualizacao")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void trackVisualizacao(@RequestBody TrackingInputDto input) {
        Visualizacao v = new Visualizacao(
                input.getUsuarioId(),
                Instant.now(),
                input.getProdutoId(),
                input.getNomeProduto(),
                input.getCategoria());

        visualizacaoRepository.save(v);
    }

    @GetMapping("/recomendacoes/{usuarioId}")
    public List<Visualizacao> getRecomendacoes(@PathVariable String usuarioId) {
        return visualizacaoRepository.findTop5ByUsuarioId(usuarioId);
    }
}
