package com.luan.ecommerce;

import com.luan.ecommerce.model.Produto;
import org.junit.Test;

public class OperacaoComTransacaoTest extends EntityManagerTest {

    @Test
    public void abrirEFecharTransacao() {
        Produto produto = new Produto();//

        //inicia transação
        entityManager.getTransaction().begin();
        
    /*
        //realiza operações no banco de dados//
        //persiste um obj
        entityManager.persist(produto);
        //realiza uma mudança no banco de dados
        entityManager.merge(produto);
        //remove
        entityManager.remove(produto);
    */

        //finaliza transação
        entityManager.getTransaction().commit();
    }

}
