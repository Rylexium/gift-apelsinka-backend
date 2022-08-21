package com.gift_apelsinka.service;

import com.gift_apelsinka.entity.Handbook;
import com.gift_apelsinka.repo.HandbookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class HandbookService {
    private final HandbookRepository handbookRepository;

    public HashMap<String, Object> getAll() {
        return new HashMap<>(){
            {
                put("handbook" , handbookRepository.findAll());
            }
        };
    }

    public Handbook getValueByKey(String key) {
        return handbookRepository.findById(key).orElse(null);
    }
    public HashMap<String, Object> setValueByKey(String key, String value) {
        Handbook handbook = handbookRepository.findById(key).orElse(null);
        if(handbook == null) {
            return new HashMap<>(){
                {
                    put("status" , "failed");
                }
            };
        }
        handbook.setValue(value);
        handbookRepository.save(handbook);
        return new HashMap<>(){
            {
                put("status" , "successfully");
            }
        };
    }
}
