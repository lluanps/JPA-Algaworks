package com.luan.ecommerce.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class Produto {

    @Id
    private Integer id;

    private String nome;

    private String descricao;

    private BigDecimal preco;


}
