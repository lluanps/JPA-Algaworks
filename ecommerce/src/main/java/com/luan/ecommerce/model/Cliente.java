package com.luan.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class Cliente {
	
	@Id
	private Integer id;
	
	private String nome;

	@Enumerated(EnumType.STRING)// guarda o nome, e nao a posição
	private SexoCliente sexoCliente;	
	
}
