package com.gift_apelsinka.controllers;

import com.gift_apelsinka.repo.StatementsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class StatementsController {
    private final StatementsRepository statementsRepository;
    @GetMapping("statements")
    public HashMap<String, Object> getStatements(@PageableDefault Pageable pageable) {

        return new HashMap<>(){
            {
                put("statements" , statementsRepository.findAll(pageable));
            }
        };
    }
}
