package com.Image.Gallery.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Image.Gallery.Models.ImageGallery;
import com.Image.Gallery.Services.ImageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "*")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    public ResponseEntity<ImageGallery> addImage(@RequestBody ImageGallery newImage) {
        ImageGallery savedImage = imageService.saveImage(newImage);
        return ResponseEntity.status(201).body(savedImage);
    }

}