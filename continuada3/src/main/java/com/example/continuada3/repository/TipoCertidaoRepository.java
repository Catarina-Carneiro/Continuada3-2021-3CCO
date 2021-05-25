package com.example.continuada3.repository;

import com.example.continuada3.dominio.Certidao;
import com.example.continuada3.dominio.TipoCertidao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoCertidaoRepository extends JpaRepository<TipoCertidao, Integer> {

}
