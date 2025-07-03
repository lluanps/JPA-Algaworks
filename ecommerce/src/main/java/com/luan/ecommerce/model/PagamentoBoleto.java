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
public class PagamentoBoleto {
	
	@Id
	private Integer id;
	
	private Integer pedidoId;
	
	@Enumerated(EnumType.STRING)
	private StatusPagamento statusPagamento;
	
	private String codigoBarrasBoleto;

}
