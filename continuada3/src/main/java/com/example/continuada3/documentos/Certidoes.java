package com.example.continuada3.documentos;

import com.example.Continuada1.repository.Documentavel;

public class Certidoes implements Documentavel {

    private String nome;
    private Integer cpf;
    private Integer qntdCertidoes;

    //construtor

    public Certidoes(String nome, Integer cpf, Integer qntdCertidoes) {
        this.nome = nome;
        this.cpf = cpf;
        this.qntdCertidoes = qntdCertidoes;
    }


    //get

    public String getNome() {
        return nome;
    }

    public Integer getCpf() {
        return cpf;
    }

    public Integer getQntdCertidoes() {
        return qntdCertidoes;
    }
    //IMPLEMENTAÇÃO DO METODO

    @Override
    public Double getValorDoc() {
        return 80.00 * qntdCertidoes;
    }
}
