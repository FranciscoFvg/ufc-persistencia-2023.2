import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* @Author: Vitor Gomes
 * @version 1.0
 * @since 1.0
 * @see modulo1.resolver.lista4
 * 
 * 1. Crie uma aplicação em Java que recebe via linha de comando (1) o
 * nome de um arquivo compactado a ser criado e (2) uma pasta. Compactar 
 * todos os arquivos e subpastas em um arquivo compactado com extensão zip.
 * 
 * Command line to run:
 * java Q1.java ../../assets/ ../../assets/assets.zip
 * 
 */

public class Q1 {
    public static void main(String[] args) throws IOException {
        try (ZipOutputStream zips = new ZipOutputStream(new FileOutputStream(args[1]))) {
            zipFolder("", args[0], zips);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addFileToZip(String path, String srcFile, ZipOutputStream zip) throws IOException {

        File folder = new File(srcFile);
        
        if (folder.isDirectory()) {
            zipFolder(path, srcFile, zip);
        } else {
            byte[] buf = new byte[4069];
            int len;
            FileInputStream in = new FileInputStream(srcFile);
            zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));

            while ((len = in.read(buf)) > 0) {
                zip.write(buf, 0, len);
            }

            in.close();
        }
    }

    public static void zipFolder(String path, String srcFolder, ZipOutputStream zip) throws IOException {
        File folder = new File(srcFolder);

        for (String fileName : folder.list()) {
            if (path.equals("")) {
                addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
            } else {
                addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
            }
        }
    }

}