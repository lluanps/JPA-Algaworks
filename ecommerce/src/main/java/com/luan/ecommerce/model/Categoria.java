package com.luan.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class Categoria {
	
	@Id
	private Integer id;
	
	private String nome;
	
	private Integer categoriaPaiId;

}
