package com.rlouro.vendaservice.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rlouro.vendaservice.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
	List<Venda> findByDataVendaBetween(LocalDateTime inicio, LocalDateTime fim, Pageable pageable);
}