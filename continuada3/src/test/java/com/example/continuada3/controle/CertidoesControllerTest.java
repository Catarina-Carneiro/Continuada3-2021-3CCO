package com.example.continuada3.controle;

import br.com.caelum.stella.bean.validation.CPF;
import com.example.continuada3.dominio.Certidao;
import com.example.continuada3.dominio.TipoCertidao;
import com.example.continuada3.repository.CertidoesRepository;
import com.example.continuada3.repository.TipoCertidaoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CertidoesControllerTest {


    @Autowired
    CertidoesController controller;

    @Autowired
    private TipoCertidaoRepository tipoCertidaoRepository;

    @MockBean
    CertidoesRepository repository;

    @Test
    @DisplayName("GET /certidoes - Quando houverem registros - status 200 e número certo de registros")
    void getCertidoesComRegistros() {

        List<Certidao> certidaosTeste = Arrays.asList(new Certidao(), new Certidao(), new Certidao());

        Mockito.when(repository.findAll()).thenReturn(certidaosTeste);

        ResponseEntity<List<Certidao>> resposta = controller.getCertidoes();

        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(3, resposta.getBody().size());
    }


    @Test
    void getCertidoesSemRegistro() {


    }



    @Test
    void postCertidao() {

//
//        Certidao certidao = new Certidao();
//        TipoCertidao tipoCertidao = new TipoCertidao();
//
//        tipoCertidao.setId(1);
//        tipoCertidao.setNome("furto");
//
//        certidao.setId(1);
//        certidao.setCpf("12345678910");
//        certidao.setDataNascimento(20010712);
//        certidao.setNome("paulo");
//        certidao.setCidadeDeNascimento("sp");
//        certidao.setMae("maria");
//        certidao.setPai("roberto");
//        certidao.setTipo(1);
//
//
//        ResponseEntity resposta = controller.postCertidao(certidao);
//
//
//        assertEquals(201, resposta.getStatusCodeValue());

    }


    @Test
    void deletarCertidao() {
    }

    @Test
    void desfazerDelete() {
    }
}