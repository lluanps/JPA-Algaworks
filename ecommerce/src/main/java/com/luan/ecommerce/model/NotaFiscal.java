package com.luan.ecommerce.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class NotaFiscal {

	@Id
	private Integer id;
	
	private Integer pedidoId;
	
	private String xml;
	
	private Date dataEmissao;
	
}
