import java.io.*;

/* @Author: Vitor Gomes
 * @version 1.0
 * @since 1.0
 * @see modulo1.resolver.lista1
 * 
 * 2. Crie uma classe Java para receber via argumento de linha de comando: (1) um
 * caminho/nome de um arquivo em formato texto e (2) uma string S. Ao executar, a
 * classe deve exibir somente as linhas do arquivo que tenham a string S como
 * substring. Algo semelhante ao que faz o comando grep do Linux.
 * 
 * Command line to run:
 * java Q2.java ../../assets/arquivo1.txt tecnologia
 */

public class Q2 {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream(args[0]);
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        String s = br.readLine();
        do{
            if(s.contains(args[1])){
                System.out.println(s);
            }
            s = br.readLine();
        }while(s != null);

        br.close();
    }
}