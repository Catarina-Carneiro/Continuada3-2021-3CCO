package com.example.continuada3.repository;
import com.example.continuada3.dominio.Certidao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertidoesRepository extends  JpaRepository<Certidao, Integer> {

   // List<Certidao> delete(int id);
}