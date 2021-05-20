package com.example.continuada3.documentos;

import com.example.Continuada1.repository.Documentavel;

public class Imovel implements Documentavel {

    // atributos

    private String bairro;
    private String rua;
    private Integer numero;
    private Double valorDoImovel;

    //get e setters

    public Imovel(String bairro, String rua, Integer numero, Double valorDoImovel) {
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.valorDoImovel = valorDoImovel;
    }

    //implementação dos metodos


    @Override
    public Double getValorDoc() {
        return valorDoImovel * 0.30;
    }
}
