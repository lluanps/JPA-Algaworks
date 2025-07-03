package com.luan.ecommerce.relacionamentos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import com.luan.ecommerce.EntityManagerTest;
import com.luan.ecommerce.model.Categoria;

public class AutoRelacionamentoTest extends EntityManagerTest {

	@Test
	public void verificarRelacionamento() {
		Categoria categoriaPai = new Categoria();
		categoriaPai.setNome("Eletronicos");
		
		Categoria categoria = new Categoria();
		categoria.setNome("Celulares");
		categoria.setCategoriaPai(categoriaPai);

		entityManager.getTransaction().begin();
		entityManager.persist(categoriaPai);
		entityManager.persist(categoria);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Categoria categoriaVerificacao = entityManager.find(Categoria.class, categoria.getId());
		Categoria categoriaPaiVerificacao = entityManager.find(Categoria.class, categoriaPai.getId());
		assertNotNull(categoriaVerificacao.getCategoriaPai());
		assertFalse(categoriaPaiVerificacao.getCategorias().isEmpty());
	}
	
}
