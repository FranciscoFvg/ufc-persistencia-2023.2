import java.io.*;

/* @Author: Vitor Gomes
 * @version 1.0
 * @since 1.0
 * @see modulo1.resolver.lista2
 * 
 * 2. Escreva uma aplicação Java para fazer exatamente o que foi pedido na Questão 1, mas com uma única diferença:
 * 
 * - A leitura e gravação devem ser realizadas em blocos de bytes (buffer) e não byte a byte.
 * - Dica: usar os métodos read(byte[] b) e write(byte[] b) de FileInputStream e FileOutputStream, respectivamente.
 *          Testar a cópia com arquivos grandes. Usar blocos de 8192 bytes. Exemplo:
 *          byte[] buffer = new byte[8192];
 *          fis.read(buffer);
 * - Comparar o tempo de cópia de arquivos grandes usando a Questão 1 e a Questão 2.
 * 
 * Command line to run:
 * java Q2.java ../../assets/arquivo1l2.txt ../../assets/saida1l2.txt
 * 
 */

public class Q2 {
    public static void main(String[] args) throws IOException {
        long bpb = bytePerByte(args);
        long pb = perBuffer(args);

        if (bpb == 0 || pb == 0) {
            System.out.println("Erro: Tempo de execução invalido");
        } else if (bpb < pb) {
            System.out.println("Copia Byte a Byte " + (pb / bpb) + " vezes mais rapida");
        } else {
            System.out.println("Copia por Buffer " + (bpb / pb) + " vezes mais rapida");
        }
    }

    public static long bytePerByte(String[] args) throws IOException {
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
            System.out.println("Copia Byte a Byte concluida em: " + elapsedTime + " milisegundos");

            return elapsedTime;
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            return 0;
        }
    }
    public static long perBuffer(String[] args) throws IOException {
        try {
            long startTime = System.currentTimeMillis();

            InputStream is = new FileInputStream(args[0]);
            OutputStream os = new FileOutputStream(args[1]);

            byte[] buffer = new byte[8192];
            int byteRead;
            while ((byteRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, byteRead);
            }
            os.close();
            is.close();

            long endTime = System.currentTimeMillis();

            long elapsedTime = endTime - startTime;
            System.out.println("Copia por Buffer concluida em: " + elapsedTime + " milisegundos");

            return elapsedTime;
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            return 0;
        }
    }
}