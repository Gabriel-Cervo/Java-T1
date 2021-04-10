import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MinHeap {
    public ArrayList<Computador> elems;
    private int size;

    public MinHeap() {
        this.size = 0;
        elems = new ArrayList<Computador>(1000);
    }

    /**
     * Insere um computador no heap.
     * @param element o computador a ser inserido.
     */
    void insert(Computador element) {
        elems.add(size++, element);
    }

    /**
     * Verifica quantos elementos são balanceados
     * @return o numero de elementos balanceados
     */
    int howManyAreBalanced() {
        if (size == 0) {
            return 0;
        }

        HashMap<String, int[]> computersWithWorkCalculated = new HashMap<>();

        int indexOflastComputerWithName = getLastComputerWithName();
        int half = indexOflastComputerWithName / 2 - 1;

        for (int i = indexOflastComputerWithName; i > half; i--) {
            Computador thisComputer = elems.get(i);

            Computador leftChild = elems.get(i * 2 + 1);
            Computador rightChild = elems.get(i * 2 + 2);

            int work = leftChild.getTrabalho() + rightChild.getTrabalho();
            int isBalanced = leftChild.getTrabalho() == rightChild.getTrabalho() ? 1 : -1;
            
            int[] values = { isBalanced, work };
            computersWithWorkCalculated.put(thisComputer.getNome(), values);
        }

        for (int i = half; i >= 0; i--) {
            Computador thisComputer = elems.get(i);

            String leftChildName = "X" + (i * 2 + 1);
            String rightChildName = "X" + (i * 2 + 2);

            int[] leftChild = computersWithWorkCalculated.get(leftChildName);
            int[] rightChild = computersWithWorkCalculated.get(rightChildName);

            int isBalanced = leftChild[1] == rightChild[1] ? 1 : -1;
            int work = leftChild[1] + rightChild[1];
            
            int[] values = { isBalanced, work };
            computersWithWorkCalculated.put(thisComputer.getNome(), values);
        }

        int balancedElements = 0;
        Iterator it = computersWithWorkCalculated.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if (computersWithWorkCalculated.get(pair.getKey())[0] == 1) {
                balancedElements++;
            }
            it.remove();
        }
        return balancedElements;
    }

    /**
     * Pega o ultimo indice do computador ainda com nome
     * Ex: 'X30', sendo os filhos dele computadores sem nome
     * @return o indice do ultimo computador com nome
     */
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
