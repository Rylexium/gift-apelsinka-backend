package com.gift_apelsinka.repo;

import com.gift_apelsinka.entity.Pictures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PicturesRepository extends JpaRepository<Pictures, Integer> {

    @Query(value = "select * from pictures where belongs=:value", nativeQuery = true)
    List<Pictures> findAllByBelongs(@Param("value") Integer value);
}
