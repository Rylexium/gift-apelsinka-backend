package com.gift_apelsinka.repo;

import com.gift_apelsinka.entity.Pictures;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PicturesRepository extends CrudRepository<Pictures, Integer> {

    Page<Pictures> findAll(Pageable pageable);
    @Query(value = "select * from pictures where belongs=:value", nativeQuery = true)
    Page<Pictures> findAllByBelongs(@Param("value") Integer value, Pageable pageable);
}
