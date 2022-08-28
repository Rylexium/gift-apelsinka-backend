package com.gift_apelsinka.repo;

import com.gift_apelsinka.entity.Statements;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface StatementsRepository extends CrudRepository<Statements, Integer> {
    Page<Statements> findAll(Pageable pageable);
}
