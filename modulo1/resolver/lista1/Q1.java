import java.io.*;

/* @Author: Vitor Gomes
 * @version 1.0
 * @since 1.0
 * @see modulo1.resolver.lista1
 * 
 * 1. Crie uma classe Java para receber via argumento de linha de comando um 
 * caminho/nome de um arquivo em formato texto e, em seguida, listar as 10 
 * primeiras linhas do arquivo selecionado. Algo semelhante ao que faz o 
 * comando head do Linux.
 * 
 * Command line to run:
 * java Q1.java ../../assets/arquivo1l1.txt
 * 
 */

public class Q1 {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream(args[0]);
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        String s;
        for (int i = 0; i<10;i++){
            s = br.readLine();
            System.out.println(s);
        }

        br.close();
    }
}