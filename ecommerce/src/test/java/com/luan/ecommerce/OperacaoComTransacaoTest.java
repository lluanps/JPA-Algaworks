package com.luan.ecommerce;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.luan.ecommerce.model.Produto;

public class OperacaoComTransacaoTest extends EntityManagerTest {

    @Test
    public void atualizarObjetoGerenciado() {
        Produto produto = entityManager.find(Produto.class, 1);

        entityManager.getTransaction().begin();
        produto.setNome("Kindle Papperwhite 2ª Geração");
        entityManager.getTransaction().commit();

        entityManager.clear();// limpa da memoria dados que foram armazenados (limpa dados feito pelo merge)

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        assertEquals("Kindle Papperwhite 2ª Geração", produtoVerificacao.getNome());

    }

    @Test
    public void atualizarObjeto() {
        Produto produto = new Produto();

        produto.setId(1);
        produto.setNome("Kindle Papperwhite");
        produto.setDescricao("Conheça o novo Kindle");
        produto.setPreco(new BigDecimal(599));


        entityManager.getTransaction().begin();
        entityManager.merge(produto);// faz uma copia do parametro e armazena no entityManager p/ ser gerenciado
        entityManager.getTransaction().commit();

        entityManager.clear();// limpa da memoria dados que foram armazenados (limpa dados feito pelo merge)

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        assertNotNull(produtoVerificacao);
        assertEquals("Kindle Papperwhite", produtoVerificacao.getNome());

    }

    @Test
    public void removerObjeto() {
        Produto produto = entityManager.find(Produto.class, 3);

        entityManager.getTransaction().begin();//inicia transação
        entityManager.remove(produto);//remove objeto
        entityManager.getTransaction().commit();//commita transação

        /* entityManager.clear(); -- não é necessario  na asserção para operação de remoção */

        Produto produtoVerificacao = entityManager.find(Produto.class, 3);
        assertNull(produtoVerificacao);

    }

    @Test
    public void inserirObjetoComMerge() {
        Produto produto = new Produto();

        produto.setId(4);
        produto.setNome("Microfone at-2020");
        produto.setDescricao("Microfone de gravação de studio");
        produto.setPreco(new BigDecimal(550));

        entityManager.getTransaction().begin();
        entityManager.merge(produto);//usado tbm para atualizar e inserir
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        assertNotNull(produtoVerificacao);
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
        assertNotNull(produtoVerificacao);
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
