package com.example.continuada3.documentos;

public class Carro extends Veiculos {


    //construtor

    public Carro(String nome, String marca, Integer anoLancamento, Double valor) {
        super(nome, marca, anoLancamento, valor);
    }

    //Iplementação do metodo
    @Override
    public Double getValorDoc() {
        return getValor() * 0.20;
    }

}
