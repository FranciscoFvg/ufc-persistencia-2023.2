import java.io.*;

/* @Author: Vitor Gomes
 * @version 1.0
 * @since 1.0
 * @see modulo1.resolver.lista2
 * 
 * 3. Escreva uma aplicação Java para ler um arquivo texto com codificação ISO-8859-1 e convertê-lo para UTF-8.
 * 
 * - Os nomes dos arquivos (origem e destino) devem ser definidos via argumentos de linha de comando (Dica: usar o String args[] do método main).
 * 
 * Command line to run:
 * java Q3.java ../../assets/arquivo2l2.txt ../../assets/saida2l2.txt
 * 
 */

public class Q3 {
    public static void main(String[] args) throws IOException {
        try {

            BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "ISO-8859-1"));
            BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), "UTF-8"));
            
            int byteRead;
            while ((byteRead = r.read()) != -1) {
                w.write(byteRead);
            }
            w.close();
            r.close();

            System.out.println("Conversao concluida");
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
        
    }
}