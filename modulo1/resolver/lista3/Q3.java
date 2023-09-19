import java.io.*;
import java.util.Properties;

/* @Author: Vitor Gomes
 * @version 1.0
 * @since 1.0
 * @see modulo1.resolver.lista3
 * 
 * 3. Escreva um arquivo de propriedades Java via editor de textos.
 * Esse arquivo deve ter os dados de chave e valor. Exemplo:
 * 
 * arquivo config.properties
 * arquivo = meu_arquivo.txt
 * linha_inicial = 1
 * linha_final = 3
 * Depois, escreva uma classe Java que exibe da linha_inicial até a linha_final do arquivo, conforme definidos no arquivo de propriedades config.properties.
 * 
 * Command line to run:
 * java Q3.java
 * 
 */

public class Q3 {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("../../assets/config.properties"));
        
        String filePath = prop.getProperty("arquivo");
        int startLine = Integer.parseInt(prop.getProperty("linha_inicial"));
        int endLine = Integer.parseInt(prop.getProperty("linha_final"));

        InputStream is = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        String s;
        for (int i = startLine - 1; i<endLine;i++){
            s = br.readLine();
            System.out.println(s);
        }

        br.close();
    }

}