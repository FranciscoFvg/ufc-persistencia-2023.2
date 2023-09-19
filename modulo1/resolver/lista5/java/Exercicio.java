package modulo1.resolver.lista5.java;

import java.util.Date;
import java.io.Serializable;

/* @Author: Vitor Gomes
 * @version 1.0
 * @since 1.0
 * @see modulo1.resolver.lista5.java
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

public class Exercicio implements Serializable {
    private String nome;
    private String descricao;
    private Date dataRealizacao;
    private int duracao;
    private String tipo;
    private String intensidade;
    private String equipamento;
    private int series;
    private int repeticoes;

    public Exercicio() {
        
    }

    public Exercicio(String nome, String descricao, Date dataRealizacao, int duracao, String tipo, String intensidade, String equipamento, int series, int repeticoes) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataRealizacao = dataRealizacao;
        this.duracao = duracao;
        this.tipo = tipo;
        this.intensidade = intensidade;
        this.equipamento = equipamento;
        this.series = series;
        this.repeticoes = repeticoes;
        
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Date getDataRealizacao() {
        return dataRealizacao;
    }
    public void setDataRealizacao(Date dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }
    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getIntensidade() {
        return intensidade;
    }
    public void setIntensidade(String intensidade) {
        this.intensidade = intensidade;
    }
    public String getEquipamento() {
        return equipamento;
    }
    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }
    public int getSeries() {
        return series;
    }
    public void setSeries(int series) {
        this.series = series;
    }
    public int getRepeticoes() {
        return repeticoes;
    }
    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    @Override
    public String toString() {
        return "Exercicio{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataRealizacao=" + dataRealizacao +
                ", duracao=" + duracao +
                ", tipo='" + tipo + '\'' +
                ", intensidade='" + intensidade + '\'' +
                ", equipamento='" + equipamento + '\'' +
                ", series=" + series +
                ", repeticoes=" + repeticoes +
                '}';
    }

}
