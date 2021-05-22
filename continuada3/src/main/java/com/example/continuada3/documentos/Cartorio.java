package com.example.continuada3.documentos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cartorio {

    @Id
    private String protocolo;
    private Integer cartorioDeBusca;
    private String nome;
    private String rua;
    private String bairro;
    private Integer numero;

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public Integer getCartorioDeBusca() {
        return cartorioDeBusca;
    }

    public void setCartorioDeBusca(Integer cartorioDeBusca) {
        this.cartorioDeBusca = cartorioDeBusca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
