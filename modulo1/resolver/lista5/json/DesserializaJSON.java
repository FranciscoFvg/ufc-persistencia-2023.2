package modulo1.resolver.lista5.json;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/* @Author: Vitor Gomes
 * @version 1.0
 * @since 1.0
 * @see modulo1.resolver.lista5.xml
 * 
 * 7. Crie uma classe java de nome DesserializaJSON para ler / desserializar 
 * os objetos Serializados na Questão 6 e exibi-los.
 * 
 * 
 */

public class DesserializaJSON {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            Exercicios exercicios = mapper.readValue(new File("../../assets/exercicios.json"), Exercicios.class);

            System.out.println(exercicios);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
