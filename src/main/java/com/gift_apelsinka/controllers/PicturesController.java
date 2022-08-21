package com.gift_apelsinka.controllers;

import com.gift_apelsinka.model.request.RequestChangeTitlePicture;
import com.gift_apelsinka.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class PicturesController {
    private final PictureService pictureService;

    @GetMapping("pictures")
    public HashMap<String, Object> getPictures() {
        return pictureService.getAll();
    }

    @PostMapping("pictures")
    public HashMap<String, String> setTitleForPicture(@RequestBody RequestChangeTitlePicture request) {
        return pictureService.setTitlePicture(request.getId(), request.getTitle());
    }
    @GetMapping("pictures/apelsinka")
    public HashMap<String, Object> getAllApelsinkaPicture() {
        return pictureService.getAllApelsinkaPicture();
    }

    @GetMapping("pictures/oscar")
    public HashMap<String, Object> getAllOscarPicture() {
        return pictureService.getAllOscarPicture();
    }

    @GetMapping("pictures/lera")
    public HashMap<String, Object> getAllLeraPicture() {
        return pictureService.getAllLeraPicture();
    }

    @GetMapping("pictures/rylexium")
    public HashMap<String, Object> getAllRylexiumPicture() {
        return pictureService.getAllRylexiumPicture();
    }

    @GetMapping("pictures/main")
    public HashMap<String, Object> getAllMainPicture() {
        return pictureService.getAllMainPicture();
    }

    @GetMapping("pictures/logo")
    public HashMap<String, Object> getAllLogoPicture() {
        return pictureService.getAllLogoPicture();
    }
}
