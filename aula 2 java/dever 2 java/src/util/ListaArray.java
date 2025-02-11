package util;

public class ListaArray {
    // CONSTANTES - Sempre definidas com todas as letras maiúsculas. Ao invés de usar uma
    // literal (valor) no código, devemos usar uma constante
    final public static int TAMANHO_INICIAL = 3;
    final public static int FATOR_CRESCIMENTO = 5;
    final public static int NAO_ESTA_PRESENTE = -1;

    // ATRIBUTOS
    private Object[] arrayInterno;
    private int numElementos;

    // MÉTODOS
    public ListaArray() {
        this.numElementos = 0; // Não precisaria, já que é a inicialização default
        this.arrayInterno = new Object[TAMANHO_INICIAL];
    }

    // Verifica a necessidade de crescimento do array interno. Este método é privado, pois só deve ser
    // visível internamente à classe ListaArray
    private void verificarNecessidadeDeCrescimento() {
        // Obtendo o tamanho do array referenciado por this.arrayInterno
        int tamanho = this.arrayInterno.length;
        // Se o tamanho é igual ao número de elementos, é porque o arrayInterno está cheio. Então
        // precisamos de um novo array
        if (tamanho == this.numElementos) {
            // Criação de um array maior
            Object[] novoArray = new Object[tamanho + FATOR_CRESCIMENTO];
            // Copiando as referências que estão no arrayInterno para o novo array
            for (int i = 0; i < tamanho; i++)
                novoArray[i] = this.arrayInterno[i];
            // O novo array passa a ser o arrayInterno (o antigo será eliminado pelo garbage
            // collection)
            this.arrayInterno = novoArray;
        }
    }

    public boolean adicionar(Object elemento) {
        // Verificando se o arrayInterno tem espaço para a inclusão do elemento
        this.verificarNecessidadeDeCrescimento();
        // Colocando a referência para o elemento na primeira posição livre do arrayInterno
        this.arrayInterno[this.numElementos] = elemento;
        // Incrementamos o numElementos
        this.numElementos++;
        // Informamos que a adição foi feita com sucesso
        return true;
    }

    public boolean adicionar(Object elemento, int posicao) {
        // Verificando se a posição indicada é plausível. Não pode ser negativa, pois não há posição
        // negativa em uma lista; não pode ser maior que o numElementos, pois não podemos deixar posições
        // nulas ("buracos") no array
        if (posicao < 0 || posicao > this.numElementos)
            return false;
        // Verificando se o arrayInterno tem espaço para a inclusão do elemento
        this.verificarNecessidadeDeCrescimento();
        // Deslocando elementos para abrir espaço para o elemento no array na posição indicada
        for (int i = this.numElementos; i > posicao; i--)
            this.arrayInterno[i] = this.arrayInterno[i - 1];
        // Colocando a referência para o elemento na posição passada
        this.arrayInterno[posicao] = elemento;
        // Incrementamos o numElementos
        this.numElementos++;
        // Informamos que a adição foi feita com sucesso
        return true;
    }

    // Retorna a referência para o elemento presente na posição indicada
    // @param posicao - índice para recuperação do elemento
    // @return referência para o elemento da posição ou null se a posição for inválida
    public Object obter(int posicao) {
        // Se a posição for inválida, retornamos null
        if (posicao < 0 || posicao >= this.numElementos)
            return null;
        // Retornando a referência para o elemento da posição
        return this.arrayInterno[posicao];
    }

    // Retorna a posição em que um elemento está presente
    // @param elemento referência para o elemento procurado
    // @return posição onde está o elemento ou NÃO_ESTA_PRESENTE se não for encontrado
    public int posicaoDe(Object elemento) {
        // Varrendo o arrayInterno à procura do elemento
        for (int i = 0; i < this.numElementos; i++)
            // Se na posição "i" estiver quem estamos procurando, retornamos o valor de "i"
            if (this.arrayInterno[i] == elemento)
                return i;
        // Retornando -1 para indicar que o elemento não foi encontrado
        return NAO_ESTA_PRESENTE;
    }

    // Remove o elemento da posição indicada. Precisará agrupar os elementos para não deixar null
    // ("buraco") no arrayInterno
    // @param posicao
    // @return
    public boolean remover(int posicao) {
        // Se a posição não for plausível, retornamos "false"
        if (posicao < 0 || posicao >= this.numElementos)
            return false;
        // Para retirar o elemento e não deixar um buraco no arrayInterno
        // Vamos trazer uma posição para trás os elementos da posição indicada até o último
        // elemento presente
        for (int i = posicao; i < this.numElementos - 1; i++)
            this.arrayInterno[i] = this.arrayInterno[i + 1];
        // Para que a última posição não fique duplicada, colocamos null
        this.arrayInterno[this.numElementos - 1] = null;
        // Diminuímos o número de elementos presentes na lista
        this.numElementos--;
        // Retornamos true informando que o elemento foi retirado
        return true;
    }

    // Remove o elemento da lista caso esteja presente
    // @param elemento - referência para o objeto a ser removido
    // @return true se o elemento estiver presente na lista; false caso contrário
    public boolean remover(Object elemento) {
        // Se o elemento estiver na lista, o método posicaoDe retornará o índice onde está presente
        // ou -1 (NAO_ESTA_PRESENTE)
        int posicao = this.posicaoDe(elemento);
        // Se não estiver na lista
        if (posicao == NAO_ESTA_PRESENTE)
            return false;
        // Utilizamos o método remover pela posição para a operação
        return this.remover(posicao);
    }

    // Retorna o número de elementos presentes na lista
    // @return número de elementos
    public int obterNumElementos() {
        return this.numElementos;
    }
}
