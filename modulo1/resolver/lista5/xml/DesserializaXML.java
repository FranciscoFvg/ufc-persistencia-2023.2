package modulo1.resolver.lista5.xml;

import java.io.File;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/* @Author: Vitor Gomes
 * @version 1.0
 * @since 1.0
 * @see modulo1.resolver.lista5.xml
 * 
 * 5. Crie uma classe java de nome DesserializaXML para ler / desserializar os 
 * objetos Serializados na Questão 4 e exibi-los.
 * 
 * 
 */

public class DesserializaXML {
    public static void main(String[] args) throws Exception {
        File file = new File("../../assets/exercicios.xml");
        XmlMapper xmlMapper = new XmlMapper();
        Exercicios e = xmlMapper.readValue(file, Exercicios.class);
        System.out.println(e);
    }

}
