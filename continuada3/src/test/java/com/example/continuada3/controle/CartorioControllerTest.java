package com.example.continuada3.controle;

import com.example.continuada3.dominio.Cartorio;
import com.example.continuada3.dominio.TipoCertidao;
import com.example.continuada3.repository.CartorioRepository;
import com.example.continuada3.repository.TipoCertidaoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartorioControllerTest {


    @Autowired
    CartorioController controller;

    @MockBean
    CartorioRepository repository;

    @Test
    void getCartorios() {

        List<Cartorio> cartorioTeste = Arrays.asList(new Cartorio(), new Cartorio(), new Cartorio());


        Mockito.when(repository.findAll()).thenReturn(cartorioTeste);

        ResponseEntity<List<Cartorio>> resposta = controller.getCartorios();

        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(3, resposta.getBody().size());


    }

    @Test
    void getCartorios2004() {

        List<Cartorio> cartorioTeste = Arrays.asList(new Cartorio(), new Cartorio(), new Cartorio());


        Mockito.when(repository.findAll()).thenReturn(cartorioTeste);

        ResponseEntity<List<Cartorio>> resposta = controller.getCartorios();

        assertEquals(204, resposta.getStatusCodeValue());
        assertEquals(3, resposta.getBody().size());


    }

    @Test
    void novaBusca() {

        Cartorio cartorio = new Cartorio();


        ResponseEntity resposta = controller.post(cartorio);

        assertEquals(201, resposta.getStatusCodeValue());
    }

    @Test
    void getSorteio() {

    }
}