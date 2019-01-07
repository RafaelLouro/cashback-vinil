package com.rlouro.vendaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rlouro.vendaservice.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
}