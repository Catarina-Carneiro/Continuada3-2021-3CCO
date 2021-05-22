package com.example.continuada3.repository;

import com.example.continuada3.arquivo.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnexoRepository extends JpaRepository<Arquivo, Integer> {
}
