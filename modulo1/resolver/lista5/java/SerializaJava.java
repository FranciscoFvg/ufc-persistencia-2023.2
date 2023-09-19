package modulo1.resolver.lista5.java;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* @Author: Vitor Gomes
 * @version 1.0
 * @since 1.0
 * @see modulo1.resolver.lista5.java
 * 
 * 2. Crie uma classe Java de nome SerializaJava para instanciar objetos da classe 
 * definida na Questão 1 e adicionar esses objetos em uma Lista. 
 * Depois percorrer a lista e Serializar os objetos em disco/ssd. 
 * Serialize usando a Serialização de objetos da própria API Java. 
 * 
 * 
 */

public class SerializaJava {
    public static void main(String[] args) throws IOException {
        List<Exercicio> exercicios = new ArrayList<Exercicio>();
        Exercicio e1 = new Exercicio("Abdominal", "Exercício para o Abdomen", new Date(), 30, "Cardio", "media", "Cadeira", 4, 10);
        Exercicio e2 = new Exercicio("Agachamento", "Exercício para a coxa", new Date(), 30, "Cardio", "media", "Cadeira", 4, 10);

        exercicios.add(0, e1);
        exercicios.add(0, e2);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("../../assets/sjava.ser"))) {
            for (Exercicio exercicio : exercicios) {
                oos.writeObject(exercicio);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
