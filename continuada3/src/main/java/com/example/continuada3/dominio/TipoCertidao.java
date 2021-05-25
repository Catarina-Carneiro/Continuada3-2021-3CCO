package com.example.continuada3.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class TipoCertidao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "tipo")
    @JsonIgnore
    private List<Certidao> certidoes;

//get e setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Certidao> getCertidoes() {
        return certidoes;
    }

    public void setCertidoes(List<Certidao> certidoes) {
        this.certidoes = certidoes;
    }
}
