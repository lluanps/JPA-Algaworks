package com.luan.ecommerce.mapeamentoBasico;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import com.luan.ecommerce.EntityManagerTest;
import com.luan.ecommerce.model.Categoria;

public class EstrategiaChavePrimariaTest extends EntityManagerTest {
	
	@Test
	public void testarEstrategiaSequence() {
		Categoria categoria = new Categoria();
		categoria.setNome("Eletronicos");
		
		entityManager.getTransaction().begin();
		entityManager.persist(categoria);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Categoria categoriaVerificao = entityManager.find(Categoria.class, categoria.getId());
		
		assertNotNull(categoriaVerificao);
	}

}
