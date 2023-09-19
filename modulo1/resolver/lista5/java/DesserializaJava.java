package modulo1.resolver.lista5.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/* @Author: Vitor Gomes
 * @version 1.0
 * @since 1.0
 * @see modulo1.resolver.lista5.java
 * 
 * 3. Crie uma classe java de nome DesserializaJava para ler / desserializar 
 * os objetos Serializados na Questão 2 e exibi-los. 
 * 
 * 
 */

public class DesserializaJava  {
    public static void main(String[] args) throws IOException {

        List<Exercicio> exercicios = new ArrayList<Exercicio>();

        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("../../assets/sjava.ser"))) {
            exercicios.add(0,(Exercicio) oos.readObject());
        }catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println(exercicios);
    }
}
