package com.example.continuada3.documentos;

public class Moto extends Veiculos {

    //atributo

    private Integer cilindradas;

    //construtor

    public Moto(String nome, String marca, Integer anoLancamento, Double valor, Integer cilindradas) {
        super(nome, marca, anoLancamento, valor);
        this.cilindradas = cilindradas;
    }

    //get e setters

    public Integer getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(Integer cilindradas) {
        this.cilindradas = cilindradas;
    }

    //implementação do metodo

    @Override
    public Double getValorDoc() {
        return getValor() * 0.15;
    }
}
