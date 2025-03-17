package util;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    // Adicionar um produto
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    // Remover um produto pelo código
    public boolean removerProdutoPorCodigo(String codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                produtos.remove(produto);
                return true;
            }
        }
        return false;
    }

    // Buscar um produto pelo código
    public Produto buscarProdutoPorCodigo(String codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }

    // Buscar um produto pelo nome
    public Produto buscarProdutoPorNome(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }

    // Exibir todos os produtos
    public void exibirProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos no estoque.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }
}
