import java.util.ArrayList;

public class MinHeap {
    public ArrayList<Computador> elems;
    private int size;

    public MinHeap() {
        this.size = 0;
        elems = new ArrayList<Computador>(1000);
    }

    /**
     * Retorna o pai do elem
     * @param pos posicao do elemento
     * @return retorna o pai
     */
    private int parent(int pos) {
        return pos / 2;
    }
  
    /**
     * Retorna o filho da esquerda
     * @param pos posicao do elemento
     * @return retorna o filho da esquerda
     */
    private int leftChild(int pos) {
        return (2 * pos);
    }
  
    /**
     * Retorna o filho da direita
     * @param pos posicao do elemento
     * @return retorna o filho da direita
     */
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    /**
     * Insere um valor inteiro no heap.
     * @param n o número a ser inserido.
     */
    void insert(Computador element) {
        elems.add(size++, element);
    }

    /**
     * Método que acessa e retorna do menor elemento do heap. Caso o heap esteja vazio, um valor null deve ser retornado.
     * @return o menor valor do heap.
     */
    Computador min() {
        if (size == 0) {
            return null;
        }
        return elems.get(0);
    }

    /**
     * Retorna o tamanho do heap em número de elementos dentro do heap.
     * @return number of items
     */
    Integer length() {
        return size - 1;
    }

    /**
     * Testa se o heap é vazio.
     * @return true caso o heap esteja vazio, false caso contrário.
     */
    boolean isEmpty() {
        return size == 0;
    }

    /**
     * Troca dois elementos de lugar
     * @param pos1 posição do primeiro elem
     * @param pos2 posição do segundo elem
     */
    void swap(int pos1, int pos2) {
        Computador temp = elems.get(pos1);
        elems.add(pos1, elems.get(pos2));
        elems.add(pos2, temp);
    }

    int howManyAreBalanced() {
        if (size == 0) {
            return 0;
        }

        Computador[] balanceados = new Computador[size];
        int lastComputerWithName = getLastComputerWithName();

        return -1;
    }

    int getLastComputerWithName() {
        int indexWithName = -1;
        for (int i = size - 1; i > 0; i--) {
            if(!elems.get(i).getNome().equals("Sem nome")) {
                indexWithName = i;
                break;
            }
        }

        return indexWithName;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Computador computador : elems) {
            str.append(computador.getNome());
            str.append("\n");
        }
        return str.toString();
    }
}
