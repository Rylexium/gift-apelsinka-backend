package com.gift_apelsinka.service;

import com.gift_apelsinka.entity.Pictures;
import com.gift_apelsinka.repo.PicturesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class PictureService {
    private final PicturesRepository picturesRepository;

    public HashMap<String, Object> getAll() {
        return new HashMap<>() {
            {
                put("picture", picturesRepository.findAll());
            }
        };
    }

    public HashMap<String, String> setTitlePicture(Integer id, String title) {
        Pictures pictures = picturesRepository.findById(id).orElse(null);
        if(pictures == null) {
            return new HashMap<>() {
                {
                    put("status", "failed");
                }
            };
        }
        pictures.setTitle(title);
        picturesRepository.save(pictures);
        return new HashMap<>() {
            {
                put("status", "successfully");
            }
        };
    }


    public HashMap<String, Object> getAllApelsinkaPicture() {
        return getAllPicture(1);
    }
    public HashMap<String, Object> getAllOscarPicture() {
        return getAllPicture(2);
    }
    public HashMap<String, Object> getAllLeraPicture() {
        return getAllPicture(3);
    }
    public HashMap<String, Object> getAllRylexiumPicture() {
        return getAllPicture(4);
    }
    public HashMap<String, Object> getAllMainPicture() {
        return getAllPicture(5);
    }
    public HashMap<String, Object> getAllLogoPicture() {
        return getAllPicture(6);
    }

    private HashMap<String, Object> getAllPicture(Integer value) {
        return new HashMap<>() {{  put("picture", picturesRepository.findAllByBelongs(value));  }};
    }
}
