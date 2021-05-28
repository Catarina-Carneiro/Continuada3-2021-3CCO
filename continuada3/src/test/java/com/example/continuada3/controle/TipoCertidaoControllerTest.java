package com.example.continuada3.controle;

import com.example.continuada3.dominio.Certidao;
import com.example.continuada3.dominio.TipoCertidao;
import com.example.continuada3.repository.TipoCertidaoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TipoCertidaoControllerTest {

    @Autowired
    TipoCertidaoController controller;

    @MockBean
    TipoCertidaoRepository repository;

    @Test
    void getTipoDone() {
        //passou

        List<TipoCertidao> certidaoTeste = Arrays.asList(new TipoCertidao(), new TipoCertidao(), new TipoCertidao());

        Mockito.when(repository.findAll()).thenReturn(certidaoTeste);

        ResponseEntity<List<TipoCertidao>> resposta = controller.getTipo();

        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(3, resposta.getBody().size());

    }


    @Test
    void getTipoFail() {

        Mockito.when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity<List<TipoCertidao>> resposta = controller.getTipo();

        assertEquals(204, resposta.getStatusCodeValue());
        assertNull(resposta.getBody());
    }


    @Test
    void postTipoDone() {

        //passou

       TipoCertidao tipo = new TipoCertidao();

       tipo.setNome("furto");

        ResponseEntity resposta = controller.postTipo(tipo);

        assertEquals(201, resposta.getStatusCodeValue());
    }

    @Test
    void postTipoDoneVazio() {

        //passou

        TipoCertidao tipo = new TipoCertidao();

        tipo.setNome("");

        ResponseEntity resposta = controller.postTipo(tipo);

        assertEquals(201, resposta.getStatusCodeValue());
    }







}