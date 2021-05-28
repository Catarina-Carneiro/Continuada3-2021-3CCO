package com.example.continuada3.controle;

import com.example.continuada3.dominio.Certidao;
import com.example.continuada3.dominio.TipoCertidao;
import com.example.continuada3.obj.PilhaObj;
import com.example.continuada3.repository.CertidoesRepository;
import com.example.continuada3.repository.TipoCertidaoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CertidoesControllerTest {

    @Autowired
    CertidoesController controller;

    @MockBean
    CertidoesRepository repository;

    @Test
    void getCertidoesDone() {

        List<Certidao> certidaoTeste = Arrays.asList(new Certidao(), new Certidao(), new Certidao());

        Mockito.when(repository.findAll()).thenReturn(certidaoTeste);

        ResponseEntity<List<Certidao>> resposta = controller.getCertidoes();

        assertEquals(200, resposta.getStatusCodeValue());
        assertEquals(3, resposta.getBody().size());
    }

    @Test
    void getCertidoesFail() {

        List<Certidao> certidaoTeste = Arrays.asList(new Certidao(), new Certidao(), new Certidao());

        Mockito.when(repository.findAll()).thenReturn(certidaoTeste);

        ResponseEntity<List<Certidao>> resposta = controller.getCertidoes();

        assertEquals(204, resposta.getStatusCodeValue());
        assertNull(resposta.getBody());
    }


    @Test
    void desfazerDeleteDone() {

        List<Certidao> certidaoTeste = Arrays.asList(new Certidao(), new Certidao(), new Certidao());
        PilhaObj<Certidao> certidaoDeletada = new PilhaObj(3);

        //certidaoDeletada.push(certidaoTeste.get());

        ResponseEntity resposta = controller.desfazerDelete();
        assertEquals(201, resposta.getStatusCodeValue());
        assertNull(resposta.getBody());

    }


    @Test
    void postCertidaoFail() {

        List<Certidao> certidaoTeste = Arrays.asList(new Certidao(), new Certidao(), new Certidao());

        Certidao certidao = new Certidao();

        certidao.setCpf("123456789010");
        //certidao.setDataNascimento(20010707);
        certidao.setNome("lady gaga");
        certidao.setCidadeDeNascimento("sp");
        certidao.setMae("maria");
        certidao.setPai("jose");

        ResponseEntity resposta = controller.postCertidao(certidao);
        assertEquals(400, resposta.getStatusCodeValue());
    }


}