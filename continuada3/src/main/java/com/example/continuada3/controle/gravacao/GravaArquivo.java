package com.example.continuada3.controle.gravacao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GravaArquivo {

    public static void gravaRegistro (String nomeArq, String registro) {
        BufferedWriter saida = null;
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        try {
            saida.append(registro + "\n");
            saida.close();

        } catch (IOException e) {
            System.err.printf("Erro ao gravar arquivo: %s.\n", e.getMessage());
        }
    }


    public static void main(String[] args) {

        String nomeArq = "ArquivoNotas.txt";
        String header = "";
        String corpo = "";
        String trailer = "";
        int contRegDados = 0;

        // Monta o registro header
        Date dataDeHoje = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        header += "novos";
        header += formatter.format(dataDeHoje);
        header += "01";

        // Grava o registro header
        gravaRegistro(nomeArq, header);

        corpo += "02";

        corpo += String.format("%11s", "728.364.189-22");// cpf
        corpo += String.format("%04d", 1999);// ano de nascimento
        corpo += String.format("%-30s", "Axl Rose");  //nome
        corpo += String.format("%-15s", "Sao caetano"); //cidade
        corpo += String.format("%-30s", "Laddy gaga"); //mae
        corpo += String.format("%-30s", "thomas shelby"); //pai
        contRegDados++;
        gravaRegistro(nomeArq,corpo);


        corpo = "02";
        corpo += String.format("%11s", "924.435.392-10");// cpf
        corpo += String.format("%04d", 2001);// ano de nascimento
        corpo += String.format("%-30s", "tuco silva");  //nome
        corpo += String.format("%-15s", "Sao caetano"); //cidade
        corpo += String.format("%-30s", "nene silva"); //mae
        corpo += String.format("%-30s", "linel silva"); //pai
        gravaRegistro(nomeArq,corpo);


        // monta o trailer
        trailer += "01";
        trailer += String.format("%010d", contRegDados);
        gravaRegistro(nomeArq,trailer);
    }

}
