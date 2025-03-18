package controller;

import util.ListaArray;
import util.ListaArrayString;
import util.Pilha;
import java.util.Scanner;

public class CtrlProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho da lista de inteiros: ");
        int tamanhoLista = scanner.nextInt();
        ListaArray lista = new ListaArray(tamanhoLista);
        System.out.println("Digite " + tamanhoLista + " números inteiros:");
        for (int i = 0; i < tamanhoLista; i++) {
            int num = scanner.nextInt();
            lista.adicionar(num);
        }
        System.out.println("Lista de inteiros:");
        lista.imprimirLista();

        System.out.print("Digite um número para inserir na posição 1: ");
        int numInserir = scanner.nextInt();
        lista.adicionarNaPosicao(numInserir, 1);
        lista.imprimirLista();

        System.out.println("Removendo o elemento na posição 1.");
        lista.remover(1);
        lista.imprimirLista();

        System.out.print("Digite o tamanho da lista de nomes: ");
        int tamanhoListaStr = scanner.nextInt();
        scanner.nextLine();
        ListaArrayString listaString = new ListaArrayString(tamanhoListaStr);
        System.out.println("Digite " + tamanhoListaStr + " nomes:");
        for (int i = 0; i < tamanhoListaStr; i++) {
            String nome = scanner.nextLine();
            listaString.adicionar(nome);
        }
        System.out.println("Lista de nomes:");
        listaString.imprimirLista();

        System.out.print("Digite um nome para buscar na lista: ");
        String nomeBusca = scanner.nextLine();
        int indice = listaString.buscar(nomeBusca);
        if (indice != -1) {
            System.out.println("Nome " + nomeBusca + " encontrado na posição: " + indice);
        } else {
            System.out.println("Nome " + nomeBusca + " não encontrado.");
        }

        System.out.println("Removendo o elemento na posição 1 da lista de nomes.");
        listaString.remover(1);
        listaString.imprimirLista();

        System.out.print("Digite o tamanho da pilha: ");
        int tamanhoPilha = scanner.nextInt();
        Pilha pilha = new Pilha(tamanhoPilha);
        System.out.println("Digite " + tamanhoPilha + " números para empilhar:");
        for (int i = 0; i < tamanhoPilha; i++) {
            int valor = scanner.nextInt();
            pilha.push(valor);
        }
        pilha.imprimirPilha();
        System.out.println("Topo da pilha: " + pilha.peek());
        System.out.println("Removendo elemento do topo: " + pilha.pop());
        pilha.imprimirPilha();

        scanner.close();
    }
}
