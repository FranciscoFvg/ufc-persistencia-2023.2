import java.io.*;

/* @Author: Vitor Gomes
 * @version 1.0
 * @since 1.0
 * @see modulo1.resolver.lista2
 * 
 * 4. Escreva uma aplicação Java para obter via teclado uma sequência de linhas 
 * de texto até que uma linha contendo somente a String "FIM" seja digitada. 
 * Depois disso, solicitar o nome do arquivo via teclado e salvar todas as linhas
 * de texto digitadas no arquivo solicitado. A linha contendo a String "FIM" não
 * deve ser salva no arquivo.  
 * 
 * Command line to run:
 * java Q4.java
 * 
 */

public class Q4 {
    public static void main(String[] args) throws IOException {
        try {
            String[] lines = new String[1000];

            InputStream is = System.in;
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line = br.readLine();
            int count = 0;

            while (!line.contains("FIM")) {
                lines[count++] = line;
                line = br.readLine();
            }
            System.out.println("Digite o nome do arquivo: ");
            String fileName = br.readLine();

            OutputStream os = new FileOutputStream(fileName);

            for (int i = 0; i < count; i++) {
                os.write(lines[i].getBytes());
                os.write("\n".getBytes());
            }

            os.close();

            System.out.println("Conversao concluida");
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
        
    }
}