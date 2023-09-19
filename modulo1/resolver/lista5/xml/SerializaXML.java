package modulo1.resolver.lista5.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import modulo1.resolver.lista5.java.Exercicio;

/* @Author: Vitor Gomes
 * @version 1.0
 * @since 1.0
 * @see modulo1.resolver.lista5.xml
 * 
 * 4. Crie uma classe Java de nome SerializaXML para instanciar objetos da classe 
 * definida na Questão 1 e adicionar esses objetos em uma Lista. 
 * Depois percorrer a lista e Serializar os objetos em disco/ssd. 
 * Serialize usando a Serialização de objetos da biblioteca Jackson. 
 * 
 * 
 */

public class SerializaXML {
    public static void main(String[] args) throws IOException {
        Exercicio e1 = new Exercicio("Abdominal", "Exercício para o Abdomen", new Date(), 30, "Cardio", "media", "Cadeira", 4, 10);
        Exercicio e2 = new Exercicio("Agachamento", "Exercício para a coxa", new Date(), 30, "Cardio", "media", "Cadeira", 4, 10);

        List<Exercicio> lista = new ArrayList<Exercicio>();

        lista.add(0, e1);
        lista.add(1, e2);

        Exercicios exercicios = new Exercicios(lista);

        File f = new File("../../assets/exercicios.xml");

        XmlMapper xm = new XmlMapper();
        xm.enable(SerializationFeature.INDENT_OUTPUT);
        xm.writeValue(f, exercicios);
        System.out.println("Arquivo serializado com sucesso!");
    }
}
