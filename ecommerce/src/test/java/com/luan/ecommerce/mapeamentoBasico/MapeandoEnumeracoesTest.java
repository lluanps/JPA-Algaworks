package com.luan.ecommerce.mapeamentoBasico;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.luan.ecommerce.EntityManagerTest;
import com.luan.ecommerce.model.Cliente;
import com.luan.ecommerce.model.SexoCliente;

public class MapeandoEnumeracoesTest extends EntityManagerTest {
	
	@Test
	public void testarEnum() {
		Cliente cliente = new Cliente();
		cliente.setId(4);
		cliente.setNome("José Mineiro");
		cliente.setSexoCliente(SexoCliente.MASCULINO);
		
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();

		entityManager.clear();
		
		Cliente clienteVerificacao = entityManager.find(Cliente.class ,cliente.getId());
		assertNotNull(clienteVerificacao);
		
	}

}
