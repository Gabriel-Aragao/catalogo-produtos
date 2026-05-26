package br.edu.ifpb.bd2.catalog.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.bd2.catalog.model.Visualizacao;

import java.util.List;

@Repository
public interface VisualizacaoRepository extends CassandraRepository<Visualizacao, String> {

    List<Visualizacao> findTop5ByUsuarioId(String usuarioId);
}
