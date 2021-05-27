package com.example.continuada3.dominio;


import br.com.caelum.stella.bean.validation.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Certidao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CPF
    @Column(name = "cpf", length = 11)
    private String cpf;

    @Past
    private LocalDate dataNascimento; // aaaa-mm-dd

    @NotBlank
    @Size(min = 2, max = 30)
    @NotNull
    private String nome;

    @NotBlank
    @Size(min = 2, max = 15)
    @NotNull
    private String cidadeDeNascimento;

    @NotBlank
    @Size(min = 2, max = 30)
    @NotNull
    private String mae;

    @NotBlank
    @Size(min = 2, max = 30)
    @NotNull
    private String pai;

    @ManyToOne
    private TipoCertidao tipo;


    //getters e setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setTipo(TipoCertidao tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidadeDeNascimento() {
        return cidadeDeNascimento;
    }

    public void setCidadeDeNascimento(String cidadeDeNascimento) {
        this.cidadeDeNascimento = cidadeDeNascimento;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public TipoCertidao getTipo() {
        return tipo;
    }



}
