package com.luan.ecommerce.iniciandoJpa;

import com.luan.ecommerce.EntityManagerTest;
import com.luan.ecommerce.model.Produto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ConsultandoRegistrosTest extends EntityManagerTest {

    @Test
    //busca por identificador
    public void busarPorIdentificador() {
        //Produto produto = entityManager.find(Produto.class, 1);
        Produto produto = entityManager.getReference(Produto.class, 1);

        System.out.println(">> " + produto.getNome());

        assertNotNull(produto);
        assertEquals("Kindle", produto.getNome());
    }

    @Test
    // reinicia a entidade que acabou de buscar no db
    public void atualizaAReferencia() {
        Produto produto = entityManager.find(Produto.class, 1);
        produto.setNome("Memoria RAM 32GB ddr4");

        System.out.println(">>>> " + produto.getNome());

        entityManager.refresh(produto);

        System.out.println(">>>> " + produto.getNome());

        assertEquals("Kindle", produto.getNome());
    }
}