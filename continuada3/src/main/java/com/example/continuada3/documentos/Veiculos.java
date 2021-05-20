package com.example.continuada3.documentos;

import com.example.Continuada1.repository.Documentavel;

public abstract class Veiculos implements Documentavel {
//---------JUSTIFICATIVA DE USO DE CLASSE----------------
//Estou usando essa classe abstrata com Carro e moto pois
// elas herdam os mesmo atributos da classe pai Veiculos
//exmp as duas tem uma merca e um ano de lançamento;


    //atributos
    private String nome;
    private String marca;
    private Integer anoLancamento;
    private Double valor;

    //construtor


    public Veiculos(String nome, String marca, Integer anoLancamento, Double valor) {
        this.nome = nome;
        this.marca = marca;
        this.anoLancamento = anoLancamento;
        this.valor = valor;
    }

    //get e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }


    public abstract Double getValorDoc();
}
