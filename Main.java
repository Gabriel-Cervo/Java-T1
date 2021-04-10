public class Main {
    public static void main(String args[]) throws Exception {
        MinHeap lista = new MinHeap();

        LeitorCSV.importarCSV("teste10", lista);
        System.out.println(lista.howManyAreBalanced());
    }
}