import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* @Author: Vitor Gomes
 * @version 1.0
 * @since 1.0
 * @see modulo1.resolver.lista3
 * 
 * 3. Crie uma aplicação em Java que recebe via linha de comando (1) o nome de um arquivo a ser
 * decriptado e (2) o nome do arquivo resultante da decriptação e (3) a chave de decriptação.
 * 
 * Command line to run:
 * java Q3.java ../../assets/encriptado.csv ../../assets/decriptado.csv teste246
 * 
 */

public class Q3 {
    public static void main(String[] args) throws IOException {
        try {
            byte[] keyBytes = args[2].getBytes();
            SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");

            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            cipher.init(Cipher.DECRYPT_MODE, key);

            try (InputStream in = new FileInputStream(args[0]);
                CipherInputStream cipherIn = new CipherInputStream(in, cipher);
                OutputStream os = new FileOutputStream(args[1])) {

                byte[] buffer = new byte[2048];
                int bytesRead;
                while ((bytesRead = cipherIn.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }

}