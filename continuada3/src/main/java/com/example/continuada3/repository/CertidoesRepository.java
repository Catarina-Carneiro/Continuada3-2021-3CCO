package com.example.continuada3.repository;
import com.example.continuada3.dominio.Certidao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertidoesRepository extends  JpaRepository<Certidao, Integer> {

    void delete(int id);

}