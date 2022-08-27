package com.gift_apelsinka.controllers;

import com.gift_apelsinka.model.request.RequestChangeTitlePicture;
import com.gift_apelsinka.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public HashMap<String, Object> getAllApelsinkaPicture(@PageableDefault Pageable pageable) {
        return pictureService.getAllApelsinkaPicture(pageable);
    }

    @GetMapping("pictures/oscar")
    public HashMap<String, Object> getAllOscarPicture(@PageableDefault Pageable pageable) {
        return pictureService.getAllOscarPicture(pageable);
    }

    @GetMapping("pictures/lera")
    public HashMap<String, Object> getAllLeraPicture(@PageableDefault Pageable pageable) {
        return pictureService.getAllLeraPicture(pageable);
    }

    @GetMapping("pictures/rylexium")
    public HashMap<String, Object> getAllRylexiumPicture(@PageableDefault Pageable pageable) {
        return pictureService.getAllRylexiumPicture(pageable);
    }

    @GetMapping("pictures/main")
    public HashMap<String, Object> getAllMainPicture(@PageableDefault Pageable pageable) {
        return pictureService.getAllMainPicture(pageable);
    }

    @GetMapping("pictures/logo")
    public HashMap<String, Object> getAllLogoPicture(@PageableDefault Pageable pageable) {
        return pictureService.getAllLogoPicture(pageable);
    }
}
