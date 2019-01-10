package com.rlouro.vendaservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rlouro.vendaservice.model.Disco;

@Repository
public interface DiscoRepository extends JpaRepository<Disco, Long> {
    Page<Disco> findByGeneroId(Long generoId, Pageable pageable);
}
