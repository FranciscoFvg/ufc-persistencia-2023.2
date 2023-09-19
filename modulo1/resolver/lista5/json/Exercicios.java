package modulo1.resolver.lista5.json;

import java.util.List;

import modulo1.resolver.lista5.java.Exercicio;

/* @Author: Vitor Gomes
 * @version 1.0
 * @since 1.0
 * @see modulo1.resolver.lista5.json
 * 
 * 1. Crie uma classe Java de entidade. Escolha uma entidade que você já propôs para
 * seu Trabalho Prático. Exemplo: classe Filme (id, titulo, sinopse, diretor).
 * A classe deve implementar a interface java.io.Serializable.
 * Crie também uma classe que possua uma lista de objetos da entidade escolhida.
 * Exemplo: classe Filmes, possuindo uma lista de Filme (List<Filme> filmes).
 * Veja, nos slides sobre XML, os exemplos das classes Pessoa e Pessoas.
 * 
 * 
 */

public class Exercicios {
    public Exercicios() {}
    
    public Exercicios(List<Exercicio> exercicios) {
        this.Exercicios = exercicios;
    }

    private List<Exercicio> Exercicios;

    public List<Exercicio> getExercicios() {
        return Exercicios;
    }

    public void setExercicio(List<Exercicio> exercicios) {
        this.Exercicios = exercicios;
    }

    @Override
    public String toString() {
        return this.Exercicios.toString();
    }

}