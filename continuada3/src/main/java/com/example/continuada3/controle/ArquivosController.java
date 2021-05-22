package com.example.continuada3.controle;

import com.example.continuada3.arquivo.Arquivo;
import com.example.continuada3.repository.AnexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/arquivos")
public class ArquivosController {

    @Autowired
    private AnexoRepository repository;

    /*
    Upload usando MultipartFile. Características:
    1 - Recebe arquivo vindo de uma tag <input type="file"> numa <form> em um HTML
    2 - Conseguimos obter o tipo de arquivo (content type)
    3 - Conseguimos recuperar o nome original do arquivo

    Usamos essa técnica quando queremos obter não só o conteúdo, mas alguns detalhes do arquivo

    No exemplo abaixo, a tag ficaria:
    <input type="file" name="arquivo">
         */
    @PostMapping
    public ResponseEntity criarArquivo(@RequestParam MultipartFile arquivo) throws IOException {

        // recuperando o nome original do arquivo
        System.out.println("Recebendo um arquivo de nome: " + arquivo.getOriginalFilename());

        // recuperando o tipo do arquivo
        System.out.println("Recebendo um arquivo do tipo: " + arquivo.getContentType());

        // recuperando o conteúdo do arquivo
        byte[] conteudo = arquivo.getBytes();

        // aqui estamos gravando o arquivo na pasta de trabalho da API
        Path path = Paths.get(arquivo.getOriginalFilename());
        Files.write(path, conteudo);

        return ResponseEntity.status(201).build();
    }

    @PostMapping("/anexo")
    public ResponseEntity criarAnexo(@RequestParam MultipartFile arquivo) throws IOException {

        Arquivo novoAnexo = new Arquivo();
        novoAnexo.setNomeArquivo(arquivo.getOriginalFilename());
        novoAnexo.setConteudoArquivo(arquivo.getBytes());

        repository.save(novoAnexo);

        return ResponseEntity.status(201).build();
    }

}
