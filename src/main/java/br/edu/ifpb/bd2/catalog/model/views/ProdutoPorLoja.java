package br.edu.ifpb.bd2.catalog.model.views;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Map;
import java.util.UUID;

@Data
@Table("produtos_por_loja")
public class ProdutoPorLoja {

    @PrimaryKeyColumn(name = "loja_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String lojaId;

    @PrimaryKeyColumn(name = "preco", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private Double preco;

    @PrimaryKeyColumn(name = "id", ordinal = 2, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private UUID id;

    @Column("categoria")
    private String categoria;

    @Column("nome")
    private String nome;

    @Column("marca")
    private String marca;

    @Column("atributos_dinamicos")
    private Map<String, String> atributosDinamicos;
}