package com.gift_apelsinka.controllers;

import com.gift_apelsinka.repo.HandbookRepository;
import com.gift_apelsinka.repo.PicturesRepository;
import com.gift_apelsinka.repo.StatementsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class MainController {
    private final HandbookRepository handbookRepository;
    private final PicturesRepository picturesRepository;
    private final StatementsRepository statementsRepository;

    @GetMapping("all")
    public HashMap<String, Object> getAll() {
        return new HashMap<>(){
            {
                put("handbook" , handbookRepository.findAll());
                put("statements" , statementsRepository.findAll());
                put("pictures" , picturesRepository.findAll());
            }
        };
    }

}