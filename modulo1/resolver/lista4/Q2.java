import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* @Author: Vitor Gomes
 * @version 1.0
 * @since 1.0
 * @see modulo1.resolver.lista3
 * 
 * 2. Crie uma aplicação em Java que recebe via linha de comando (1) o nome de
 * um arquivo a ser encriptado, (2) o nome do arquivo encriptado a ser criado
 * e (3) a chave de encriptação.
 * 
 * Command line to run:
 * java Q2.java ../../assets/teste.csv ../../assets/encriptado.csv teste246
 * 
 */

public class Q2 {
    public static void main(String[] args) throws IOException {
        try {
            byte[] keyBytes = args[2].getBytes();
            SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");

            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE, key);

            try (InputStream in = new FileInputStream(args[0]);
                CipherOutputStream cipherOs = new CipherOutputStream(new FileOutputStream(args[1]), cipher)) {

                byte[] buffer = new byte[2048];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    cipherOs.write(buffer, 0, bytesRead);
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