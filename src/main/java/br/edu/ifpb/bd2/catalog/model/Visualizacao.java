package br.edu.ifpb.bd2.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("visualizacoes")
public class Visualizacao {

    @PrimaryKeyColumn(name = "usuario_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String usuarioId;

    @PrimaryKeyColumn(name = "data_hora", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private Instant dataHora;

    @Column("produto_id")
    private UUID produtoId;

    @Column("nome_produto")
    private String nomeProduto;

    @Column("categoria")
    private String categoria;
}
