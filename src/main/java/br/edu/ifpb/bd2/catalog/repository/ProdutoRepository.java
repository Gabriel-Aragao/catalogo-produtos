package br.edu.ifpb.bd2.catalog.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.bd2.catalog.model.Produto;
import br.edu.ifpb.bd2.catalog.model.views.ProdutoPorLoja;
import br.edu.ifpb.bd2.catalog.model.views.ProdutoPorMarca;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProdutoRepository extends CassandraRepository<Produto, UUID> {

    List<Produto> findByCategoria(String categoria);

    @Query("SELECT * FROM produtos_por_loja WHERE loja_id = ?0")
    List<ProdutoPorLoja> findByLojaId(String lojaId);

    @Query("SELECT * FROM produtos_por_marca WHERE marca = ?0")
    List<ProdutoPorMarca> findByMarca(String marca);
}
