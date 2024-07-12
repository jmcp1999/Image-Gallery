package com.example.imagegallery.controller;

import com.example.imagegallery.model.Image;
import com.example.imagegallery.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "http://localhost:3000")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/add")
    public void addImage(@RequestBody Image image) {
        imageService.addImage(image);
    }

    @GetMapping("/list")
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }
}
