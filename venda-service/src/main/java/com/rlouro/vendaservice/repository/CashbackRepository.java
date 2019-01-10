package com.rlouro.vendaservice.repository;

import java.time.DayOfWeek;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rlouro.vendaservice.model.Cashback;

@Repository
public interface CashbackRepository extends JpaRepository<Cashback, Long> {
	Cashback findByGeneroIdAndDiaSemana(Long generoId, DayOfWeek diaSemana);
}
