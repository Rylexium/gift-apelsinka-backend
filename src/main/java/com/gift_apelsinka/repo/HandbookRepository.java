package com.gift_apelsinka.repo;

import com.gift_apelsinka.entity.Handbook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HandbookRepository extends JpaRepository<Handbook, String> {
}
