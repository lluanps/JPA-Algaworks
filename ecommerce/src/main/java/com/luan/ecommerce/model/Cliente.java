package com.luan.ecommerce.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;

	@Enumerated(EnumType.STRING)// guarda o nome, e nao a posição
	private SexoCliente sexoCliente;
	
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedido;
	
}
