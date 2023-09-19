import java.io.*;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* @Author: Vitor Gomes
 * @version 1.0
 * @since 1.0
 * @see modulo1.resolver.lista3
 * 
 * 4. Crie uma aplicação em Java que recebe via linha de comando o nome de um arquivo
 * para geração/armazenamento dos hashes md5, sha1 e sha256 do arquivo especificado.
 * A aplicação deve mostrar o tempo de execução de cada uma dessas operações.
 * Dica: veja o seguinte tutorial: MD5 Hashing in Java | Baeldung
 * 
 * Command line to run:
 * java Q4.java ../../assets/teste.csv ../../assets/hashs.txt
 * 
 */

public class Q4 {
    public static void main(String[] args) throws IOException {
        try {
            String[] hashs = new String[3];

            hashs[0] = "MD5";
            hashs[1] = "SHA-1";
            hashs[2] = "SHA-256";
            String hashString;
            long startTime;
            long endTime;

            for (int i = 0; i < 3; i++) {
                startTime = System.currentTimeMillis();

                hashString = hash(args[0], hashs[i]);

                endTime = System.currentTimeMillis();

                hashs[i] = "Algoritmo: " + hashs[i] + " - Hash: " + hashString + " - " + (endTime - startTime) + " milisegundos";

                System.out.println(hashs[i]);
            }

            OutputStream os = new FileOutputStream(args[1]);
            
            for (int i = 0; i < 3; i++) {
                os.write(hashs[i].getBytes());
                os.write("\n".getBytes());
            }
            os.close();
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public static String hash(String inputFile, String hashName){
        try {
            MessageDigest md = MessageDigest.getInstance(hashName);
            DigestInputStream dis = new DigestInputStream(new FileInputStream(inputFile), md);

            byte[] buffer = new byte[8192];
            while (dis.read(buffer) != -1) {
            }

            byte[] digest = md.digest();

            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                hexString.append(String.format("%02x", b));
            }

            dis.close();
            
            return hexString.toString();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}