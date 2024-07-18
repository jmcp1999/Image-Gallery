package com.Image.Gallery.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Image.Gallery.Models.ImageGallery;
import com.Image.Gallery.Services.ImageService;


import java.util.List;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping(path = "/images")
    public ImageGallery addImage(@RequestBody ImageGallery newImage) {
        return imageService.saveImage(newImage);
    }

    @GetMapping
    public List<ImageGallery> getAllImages() {
        return imageService.getAllImages();
    }

    @GetMapping(path = "/images/{id}")
    public ImageGallery getImageById(@PathVariable("id") Long id) {
        return imageService.getById(id);
    }

    @PutMapping(path = "/images/{id}")
    public void updateImage(@RequestBody ImageGallery images, @PathVariable Long id) {
        images.setId(id);
        imageService.updateImage(images);
    }

    @DeleteMapping(path = "/images/{id}")
    public String deleteImage(@PathVariable("id") Long id) {
        return imageService.deleteImages(id);
    }
}