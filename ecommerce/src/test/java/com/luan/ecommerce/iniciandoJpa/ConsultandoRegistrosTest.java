package com.luan.ecommerce.iniciandoJpa;

import com.luan.ecommerce.EntityManagerTest;
import com.luan.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

public class ConsultandoRegistrosTest extends EntityManagerTest {

    @Test
    //busca por identificador
    public void busarPorIdentificador() {
        //Produto produto = entityManager.find(Produto.class, 1);
        Produto produto = entityManager.getReference(Produto.class, 1);

        System.out.println(">> " + produto.getNome());

        Assert.assertNotNull(produto);
        Assert.assertEquals("Kindle", produto.getNome());
    }

    @Test
    // reinicia a entidade que acabou de buscar no db
    public void atualizaAReferencia() {
        Produto produto = entityManager.find(Produto.class, 1);
        produto.setNome("Memoria RAM 32GB ddr4");

        System.out.println(">>>> " + produto.getNome());

        entityManager.refresh(produto);

        System.out.println(">>>> " + produto.getNome());

        Assert.assertEquals("Kindle", produto.getNome());
    }
}