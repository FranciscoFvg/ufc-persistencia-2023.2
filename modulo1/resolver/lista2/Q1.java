import java.io.*;

/* @Author: Vitor Gomes
 * @version 1.0
 * @since 1.0
 * @see modulo1.resolver.lista2
 * 
 * 1. Escreva uma aplicação Java para ler um arquivo texto ou binário qualquer e gravá-lo em outro arquivo (arquivo destino).
 * 
 * - Os nomes dos arquivos (origem e destino) devem ser definidos via argumentos de linha de comando (Dica: usar o String args[] do método main).
 * - A leitura e gravação devem ser realizadas byte a byte.
 * - Ao final, deve-se exibir o tempo total da cópia em milisegundos, caso a cópia tenha sido bem sucedida. Dica: pode-se usar o método System.currentTimeMillis().
 * - Em caso de qualquer erro, enviar uma mensagem pela saída padrão de erro (System.err).
 * 
 * Command line to run:
 * java Q1.java ../../assets/arquivo1l2.txt ../../assets/saida1l2.txt
 * 
 */

public class Q1 {
    public static void main(String[] args) throws IOException {
        try {
            long startTime = System.currentTimeMillis();

            InputStream is = new FileInputStream(args[0]);
            OutputStream os = new FileOutputStream(args[1]);
            
            int byteRead;
            while ((byteRead = is.read()) != -1) {
                os.write(byteRead);
            }
            os.close();
            is.close();

            long endTime = System.currentTimeMillis();

            long elapsedTime = endTime - startTime;
            System.out.println("Copia concluida em: " + elapsedTime + " milisegundos");
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
        
    }
}