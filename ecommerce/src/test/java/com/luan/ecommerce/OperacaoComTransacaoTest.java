package com.luan.ecommerce;

import com.luan.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import javax.sound.sampled.Port;
import java.math.BigDecimal;

public class OperacaoComTransacaoTest extends EntityManagerTest {

    @Test
    public void removerObjeto() {
        Produto produto = entityManager.find(Produto.class, 3);

        entityManager.getTransaction().begin();//inicia transação
        entityManager.remove(produto);//remove objeto
        entityManager.getTransaction().commit();//commita transação

        /* entityManager.clear(); -- não é necessario  na asserção para operação de remoção */

        Produto produtoVerificacao = entityManager.find(Produto.class, 3);
        Assert.assertNull(produtoVerificacao);

    }


    @Test
    public void inserirObjeto() {
        Produto produto = new Produto();

        produto.setId(2);
        produto.setNome("Celular");
        produto.setDescricao("Inovaçãoe praticidade em um só aparelho");
        produto.setPreco(new BigDecimal(2000));

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        //entityManager.flush();//força o que ta na memoria do EntityManager para o banco de dados
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);
    }


    @Test
    public void abrirEFecharTransacao() {
        Produto produto = new Produto();//

        //inicia transação
        entityManager.getTransaction().begin();

    /*
        //realiza operações no banco de dados persiste um obj
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
