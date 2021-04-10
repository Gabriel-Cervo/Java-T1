import java.io.*;

public class LeitorCSV {
    public static void importarCSV(String nomeArquivo, MinHeap lista) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(nomeArquivo + ".csv"));  
        String line = "";
        Boolean isFirstIteration = true;

        while ((line = br.readLine()) != null) {  
            String[] computador = line.split(" ");  
            if (isFirstIteration) {
                lista.insert(new Computador(computador[0]));
                isFirstIteration = false;
            }

            if (computador[1].contains("X")) {
                lista.insert(new Computador(computador[1]));
                lista.insert(new Computador(computador[2]));
            } else {
                lista.insert(new Computador(Integer.parseInt(computador[1])));
                lista.insert(new Computador(Integer.parseInt(computador[2])));
            }
        }
        
        br.close();
    }
}
