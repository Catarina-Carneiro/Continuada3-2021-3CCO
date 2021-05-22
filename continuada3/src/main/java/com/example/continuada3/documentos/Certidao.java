package com.example.continuada3.documentos;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Certidao {

    @Id
    private String protocolo;

    private String cpf;
    private Integer anoDeNascimento;
    private String nome;
    private String cidadeDeNascimento;
    private String  nomeDaMae;
    private String  nomeDoPai;

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

//getters e setters

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getAnoDeNascimento() {
        return anoDeNascimento;
    }

    public void setAnoDeNascimento(Integer anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
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

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public String getNomeDoPai() {
        return nomeDoPai;
    }

    public void setNomeDoPai(String nomeDoPai) {
        this.nomeDoPai = nomeDoPai;
    }
}
