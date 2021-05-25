//package com.example.continuada3.dominio;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Positive;
//import javax.validation.constraints.Size;
//import java.util.List;
//
//@Entity
//public class Cartorio {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    private String protocolo;
//
//    @Positive
//    @NotNull
//    private Integer cartorioDeBusca;
//
//    @NotNull
//    private String nome;
//
//    @NotNull
//    private String rua;
//
//    @NotNull
//    private String bairro;
//
//    @Positive
//    @NotNull
//    private Integer numero;
//
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getProtocolo() {
//        return protocolo;
//    }
//
//    public void setProtocolo(String protocolo) {
//        this.protocolo = protocolo;
//    }
//
//    public Integer getCartorioDeBusca() {
//        return cartorioDeBusca;
//    }
//
//    public void setCartorioDeBusca(Integer cartorioDeBusca) {
//        this.cartorioDeBusca = cartorioDeBusca;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getRua() {
//        return rua;
//    }
//
//    public void setRua(String rua) {
//        this.rua = rua;
//    }
//
//    public String getBairro() {
//        return bairro;
//    }
//
//    public void setBairro(String bairro) {
//        this.bairro = bairro;
//    }
//
//    public Integer getNumero() {
//        return numero;
//    }
//
//    public void setNumero(Integer numero) {
//        this.numero = numero;
//    }
//}
