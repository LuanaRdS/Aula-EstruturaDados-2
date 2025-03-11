package controller;

import util.ListaArray;
import util.ListaArrayString;

public class CtrlProgram {

	public static void main(String[] args) {
        ListaArray lista = new ListaArray(5);
        lista.adicionar(10);
        lista.adicionar(20);
        lista.adicionar(30);
        lista.imprimirLista();
        lista.adicionarNaPosicao(25, 1);
        lista.imprimirLista();
        lista.remover(1);
        lista.imprimirLista();

        ListaArrayString listaString = new ListaArrayString(4);
        listaString.adicionar("Ana");
        listaString.adicionar("Bruno");
        listaString.adicionar("Carlos");
        listaString.imprimirLista();
        String nomeBusca = "Bruno";
        int indice = listaString.buscar(nomeBusca);
        if (indice != -1) {
            System.out.println("Nome " + nomeBusca + " encontrado na posição: " + indice);
        } else {
            System.out.println("Nome " + nomeBusca + " não encontrado.");
        }
        listaString.remover(1);
        listaString.imprimirLista();

        Pilha pilha = new Pilha(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.imprimirPilha();
        System.out.println("Topo da pilha: " + pilha.peek());
        System.out.println("Removendo: " + pilha.pop());
        pilha.imprimirPilha();
    }

}
