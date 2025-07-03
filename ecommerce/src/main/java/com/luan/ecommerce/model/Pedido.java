package com.luan.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class Pedido {

	@Id
	private Integer id;
	
	private LocalDateTime dataPedido;
	
	private LocalDateTime dataConclusao;
	
	private Integer notaFiscalId;
	
	private BigDecimal total;
	
	@Enumerated(EnumType.STRING)
	private StatusPedido status;
	
	@Embedded
	private EnderecoEntregaPedido enderecoEntrega;
	
	
}
