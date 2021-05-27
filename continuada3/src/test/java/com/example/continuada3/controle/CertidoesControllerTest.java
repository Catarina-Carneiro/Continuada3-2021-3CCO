package com.example.continuada3.controle;


import com.example.continuada3.dominio.Certidao;
import com.example.continuada3.repository.CertidoesRepository;
import com.example.continuada3.repository.TipoCertidaoRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CertidoesControllerTest {


    @Autowired
    CertidoesController controller;

    @MockBean
    TipoCertidaoRepository tipoCertidaoRepository;

    @MockBean
    CertidoesRepository repository;


    @Test
    @DisplayName("GET /certidoes - Quando houverem registros - status 200 e número certo de registros")
    void getCertidoes() {
        List<Certidao> certidao  = Arrays.asList(new Certidao(), new Certidao(), new Certidao());

        Mockito.when(repository.findAll()).thenReturn(certidao);

        ResponseEntity<List<Certidao>> resposta = controller.getCertidoes();

        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(3, resposta.getBody().size());
    }

    @Test
    void postCertidao() {
    }

    @Test
    void deletarCertidao() {
    }

    @Test
    void desfazerDelete() {
    }
}