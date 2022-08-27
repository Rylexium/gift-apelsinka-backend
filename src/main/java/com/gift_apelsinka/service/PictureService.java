package com.gift_apelsinka.service;

import com.gift_apelsinka.entity.Pictures;
import com.gift_apelsinka.repo.PicturesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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


    public HashMap<String, Object> getAllApelsinkaPicture(Pageable pageable) {
        return getAllPicture(1, pageable);
    }
    public HashMap<String, Object> getAllOscarPicture(Pageable pageable) {
        return getAllPicture(2, pageable);
    }
    public HashMap<String, Object> getAllLeraPicture(Pageable pageable) {
        return getAllPicture(3, pageable);
    }
    public HashMap<String, Object> getAllRylexiumPicture(Pageable pageable) {
        return getAllPicture(4, pageable);
    }
    public HashMap<String, Object> getAllMainPicture(Pageable pageable) {
        return getAllPicture(5, pageable);
    }
    public HashMap<String, Object> getAllLogoPicture(Pageable pageable) {
        return getAllPicture(6, pageable);
    }

    private HashMap<String, Object> getAllPicture(Integer value, Pageable pageable) {
        return new HashMap<>() {{  put("picture", picturesRepository.findAllByBelongs(value, pageable));  }};
    }
}
