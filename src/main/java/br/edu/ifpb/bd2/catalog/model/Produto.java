package br.edu.ifpb.bd2.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("produtos")
public class Produto {

    @PrimaryKeyColumn(name = "categoria", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String categoria;

    @PrimaryKeyColumn(name = "preco", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private Double preco;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @PrimaryKeyColumn(name = "id", ordinal = 2, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private UUID id = UUID.randomUUID();

    @Column("loja_id")
    private String lojaId;

    @Column("nome")
    private String nome;

    @Column("marca")
    private String marca;

    @Column("atributos_dinamicos")
    private Map<String, String> atributosDinamicos;
}
