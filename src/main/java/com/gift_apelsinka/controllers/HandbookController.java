package com.gift_apelsinka.controllers;

import com.gift_apelsinka.entity.Handbook;
import com.gift_apelsinka.model.request.RequestChangeValueHandbook;
import com.gift_apelsinka.service.HandbookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class HandbookController {
    private final HandbookService handbookService;

    @GetMapping("handbook")
    public HashMap<String, Object> getAllHandbook() {
        return handbookService.getAll();
    }

    @GetMapping("handbook/{key}")
    public Handbook getValueByKey(@PathVariable String key) {
        return handbookService.getValueByKey(key);
    }

    @PostMapping("handbook")
    public HashMap<String, Object> setValueByKey(@RequestBody RequestChangeValueHandbook request) {
        return handbookService.setValueByKey(request.getKey(), request.getValue());
    }
}
