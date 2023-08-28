import java.io.*;

/* @Author: Vitor Gomes
 * @version 1.0
 * @since 1.0
 * @see modulo1.resolver.lista1
 * 
 * 3. Crie uma classe Java para receber via argumento de linha de comando os
 * caminhos/nomes de 2 arquivos em formato texto e, em seguida, listar todas
 * as linhas de ambos os arquivos. Algo semelhante ao que faz o comando cat
 * do Linux.
 * 
 * Command line to run:
 * java Q3.java ../../assets/arquivo1.txt ../../assets/arquivo2.txt
 */

public class Q3 {
    public static void main(String[] args) throws IOException {
        showFileContent(args[0]);
        showFileContent(args[1]);
    }

    public static void showFileContent(String filePath) throws IOException{
        InputStream is = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String s = br.readLine();
        do{
            System.out.println(s);
            s = br.readLine();
        }while(s != null);

        br.close();
    }
}