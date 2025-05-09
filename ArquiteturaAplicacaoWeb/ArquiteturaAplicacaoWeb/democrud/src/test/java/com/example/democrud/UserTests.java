package com.example.democrud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.democrud.controller.ProdutoController;
import com.example.democrud.model.Produto;
import com.example.democrud.service.ProdutoService;


class UserTests {

    @Mock
    private ProdutoService produtoService;
    @InjectMocks
    private ProdutoController produtoController;

    /**
     * 
     */
    @Test
    void testObterTodos() {
        // Simular dados de usuário
        final List<Produto> produtoList = Arrays.asList(
                new Produto("Produto1", "Descricao do produto1"),
                new Produto("Produto2", "Descricao do produto2")
        );

        // Simular comportamento do serviço
        when(ProdutoService.obterTodos()).thenReturn(produtoList);

        // Chamar o método do controlador
        List<Produto> result = ProdutoController.obterTodos();

        // Verificar se o resultado é o esperado
        assertEquals(produtoList, result);
    }

    @Test
    void testObterPorId() {
        // Simular dados de usuário
        Produto produto = new Produto("Produto1", "Descricao do produto1");

        // Simular comportamento do serviço
        when(ProdutoService.obterPorId("1")).thenReturn(produto);

        // Chamar o método do controlador
        Produto result = ProdutoController.obterPorId("1");

        // Verificar se o resultado é o esperado
        assertEquals(produto, result);
    }

    @Test
    void testInserir() {
        // Simular dados de usuário
        Produto newProduto = new Produto("Produto1", "Descricao do produto1");

        // Simular comportamento do serviço
        when(produtoService.inserir(newProduto)).thenReturn(newProduto);

        // Chamar o método do controlador
        Produto result = produtoController.inserir(newProduto);

        // Verificar se o resultado é o esperado
        assertEquals(newProduto, result);
    }

    @Test
    void testAtualizar() {
        // Simular dados de usuário
        Produto updatedProduto = new Produto("Produto1", "Descricao do produto1");

        // Simular comportamento do serviço
        when(produtoService.atualizar("1", updatedProduto)).thenReturn(updatedProduto);

        // Chamar o método do controlador
        Produto result = produtoController.atualizar("1", updatedProduto);

        // Verificar se o resultado é o esperado
        assertEquals(updatedProduto, result);
    }

    @Test
    void testExcluir() {

        // Simular comportamento do serviço
        doNothing().when(produtoService).excluir("1");

        // Chamar o método do controlador
        produtoController.excluir("1");

        // Verificar se o método de serviço foi chamado
        verify(produtoService, times(1)).excluir("1");
                    }
                
                    private ProdutoController verify(ProdutoService produtoService2, Object times) {
                
                throw new UnsupportedOperationException("Unimplemented method 'verify'");
            }
        
                    private Object times(int i) {
                
                throw new UnsupportedOperationException("Unimplemented method 'times'");
            }
        
            @Test
    void testSimularErro(){
        // Simula o comportamento do método add para retornar 5 quando chamado com argumentos 2 e 3
        when(produtoService.somar(2, 3)).thenReturn(5);

        // Chama o método que deveria retornar 5
        int result = (int) produtoService.somar(2, 3);

        // Aserção que verifica se o resultado é 5
        assertEquals(5, result, "O resultado da adição não é o esperado.");
    }
}