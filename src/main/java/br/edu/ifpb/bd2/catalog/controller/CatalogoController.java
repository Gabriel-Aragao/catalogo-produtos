package br.edu.ifpb.bd2.catalog.controller;

import br.edu.ifpb.bd2.catalog.model.Produto;
import br.edu.ifpb.bd2.catalog.model.views.ProdutoPorLoja;
import br.edu.ifpb.bd2.catalog.model.views.ProdutoPorMarca;
import br.edu.ifpb.bd2.catalog.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalogo")
public class CatalogoController {

    private final ProdutoRepository produtoRepository;

    public CatalogoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto upsertProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Produto> getProdutosPorCategoria(@PathVariable String categoria) {
        return produtoRepository.findByCategoria(categoria);
    }

    @GetMapping("/loja/{lojaId}")
    public List<ProdutoPorLoja> getProdutosPorLoja(@PathVariable String lojaId) {
        return produtoRepository.findByLojaId(lojaId);
    }

    @GetMapping("/marca/{marca}")
    public List<ProdutoPorMarca> getProdutosPorMarca(@PathVariable String marca) {
        return produtoRepository.findByMarca(marca);
    }
}
