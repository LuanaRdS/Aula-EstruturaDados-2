package main;

import util.Estoque;
import util.Produto;

public class Main {
    public static void main(String[] args) {
        // Criando o estoque
        Estoque estoque = new Estoque();

        // Adicionando produtos
        estoque.adicionarProduto(new Produto("001", "Camiseta", 50));
        estoque.adicionarProduto(new Produto("002", "Calça", 30));

        // Exibindo todos os produtos
        System.out.println("Produtos no estoque:");
        estoque.exibirProdutos();

        // Buscando um produto pelo código
        System.out.println("\nBuscando produto com código '001':");
        Produto produtoBuscadoCodigo = estoque.buscarProdutoPorCodigo("001");
        if (produtoBuscadoCodigo != null) {
            System.out.println(produtoBuscadoCodigo);
        } else {
            System.out.println("Produto não encontrado.");
        }

        // Buscando um produto pelo nome
        System.out.println("\nBuscando produto com nome 'Calça':");
        Produto produtoBuscadoNome = estoque.buscarProdutoPorNome("Calça");
        if (produtoBuscadoNome != null) {
            System.out.println(produtoBuscadoNome);
        } else {
            System.out.println("Produto não encontrado.");
        }

        // Removendo um produto
        System.out.println("\nRemovendo produto com código '001'.");
        if (estoque.removerProdutoPorCodigo("001")) {
            System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Produto não encontrado para remoção.");
        }

        // Exibindo todos os produtos novamente
        System.out.println("\nProdutos no estoque após remoção:");
        estoque.exibirProdutos();
    }
}