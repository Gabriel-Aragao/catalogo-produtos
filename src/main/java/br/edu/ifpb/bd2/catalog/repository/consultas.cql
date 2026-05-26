CREATE TABLE catalog_ks.produtos (
    categoria text,
    preco double,
    id uuid,
    loja_id text,
    nome text,
    marca text,
    atributos_dinamicos map<text, text>,
    PRIMARY KEY ((categoria), preco, id)
) WITH CLUSTERING ORDER BY (preco ASC, id ASC);

CREATE TABLE catalog_ks.visualizacoes (
    usuario_id text,
    data_hora timestamp,
    produto_id uuid,
    nome_produto text,
    categoria text,
    PRIMARY KEY ((usuario_id), data_hora)
) WITH CLUSTERING ORDER BY (data_hora DESC);


CREATE MATERIALIZED VIEW catalog_ks.produtos_por_loja AS
    SELECT * FROM produtos
    WHERE loja_id IS NOT NULL 
      AND categoria IS NOT NULL 
      AND preco IS NOT NULL 
      AND id IS NOT NULL
    PRIMARY KEY ((loja_id), preco, id, categoria)
    WITH CLUSTERING ORDER BY (preco ASC, id ASC, categoria ASC);

CREATE MATERIALIZED VIEW catalog_ks.produtos_por_marca AS
    SELECT * FROM produtos
    WHERE marca IS NOT NULL 
      AND categoria IS NOT NULL 
      AND preco IS NOT NULL 
      AND id IS NOT NULL
    PRIMARY KEY ((marca), preco, id, categoria)
    WITH CLUSTERING ORDER BY (preco ASC, id ASC, categoria ASC);
