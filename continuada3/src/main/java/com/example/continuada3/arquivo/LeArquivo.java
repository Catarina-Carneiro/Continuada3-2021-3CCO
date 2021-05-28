package com.example.continuada3.arquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeArquivo {

    public static void leArquivo(String nomeArq) {
        BufferedReader entrada = null;
        String registro;
        String tipoRegistro;
        String cpf, nome, cidade, mae, pai;
        Integer dataDeNascimento;
        int contRegistro = 0;

        // Abre o arquivo
        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        // Lê os registros do arquivo
        try {
            // Lê um registro
            registro = entrada.readLine();

            while (registro != null) {
                // Obtém o tipo do registro
                tipoRegistro = registro.substring(0, 2); // obtém os 2 primeiros caracteres do registro

                if (tipoRegistro.equals("00")) {
                    System.out.println("Header");
                    System.out.println("Tipo de arquivo: " + registro.substring(2, 6));
                    int periodo = Integer.parseInt(registro.substring(6, 11));
                    System.out.println("Período: " + periodo);
                    System.out.println("Data/hora de geração do arquivo: " + registro.substring(11, 30));
                    System.out.println("Versão do layout: " + registro.substring(30, 32));
                } else if (tipoRegistro.equals("01")) {
                    System.out.println("\nTrailer");
                    int qtdRegistro = Integer.parseInt(registro.substring(3, 7));
                    if (qtdRegistro == contRegistro) {
                        System.out.println("Quantidade de registros gravados compatível com quantidade lida");
                    } else {
                        System.out.println("Quantidade de registros gravados não confere com quantidade lida");
                    }
                } else if (tipoRegistro.equals("02")) {
                    if (contRegistro == 0) {
                        System.out.println();
                        System.out.printf("%11s %8s %-30s %-15s %-30s %-30s\n",
                                "CPF", "DATADENASCIMENTO", "NOME", "CIDADE", "MAE", "PAI");

                    }

                    cpf = registro.substring(2, 13);
                    dataDeNascimento = Integer.parseInt(registro.substring(13, 21));
                    nome = registro.substring(21, 51);
                    cidade = registro.substring(51, 66);
                    mae = registro.substring(66, 96);
                    pai = registro.substring(96, 126);


                    System.out.printf("%11s %8d %-30s %-15s %-30s %-30s\n",
                            cpf, dataDeNascimento, nome, cidade, mae, pai);
                    contRegistro++;
                } else if (tipoRegistro.equals("03")) {
                    if (contRegistro == 0) {
                        System.out.println();
                        System.out.printf("%11s %8d %-30s %-15s %-30s %-30s\n",
                                "TIPO");
                    }

                    nome = registro.substring(2, 17);

                    System.out.printf("%-15s\n",
                            nome);
                    contRegistro++;
                } else {
                    System.out.println("Tipo de registro inválido");
                }

                // lê o próximo registro
                registro = entrada.readLine();
            }

            // Fecha o arquivo
            entrada.close();
        } catch (IOException e) {
            System.err.printf("Erro ao ler arquivo: %s.\n", e.getMessage());
        }
    }

//    public static void main(String[] args) {
//        String nomeArq = "Certidoes.txt";
//        leArquivo(nomeArq);
//    }

}
