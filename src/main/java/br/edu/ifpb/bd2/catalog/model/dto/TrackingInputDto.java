package br.edu.ifpb.bd2.catalog.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class TrackingInputDto {
    private String usuarioId;
    private UUID produtoId;
    private String nomeProduto;
    private String categoria;
}
