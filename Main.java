public class Main {
    public static void main(String args[]) throws Exception {
        for (int i = 5; i <= 13; i++) {
            MinHeap lista = new MinHeap();
            LeitorTXT.importarTXT("teste" + i, lista);
            System.out.println("Teste" + i + ": " + lista.howManyAreBalanced());
        }
    }
}