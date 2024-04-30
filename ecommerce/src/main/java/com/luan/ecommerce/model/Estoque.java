package com.luan.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class Estoque {
	
	@Id
	private Integer id;
	
	private Integer produtoId;
	
	private Integer quantidade;

}
