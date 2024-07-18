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

    @GetMapping
    public ResponseEntity<List<ImageGallery>> getAllImages() {
        List<ImageGallery> images = imageService.getAllImages();
        return ResponseEntity.ok(images);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageGallery> getImageById(@PathVariable Long id) {
        Optional<ImageGallery> imageOptional = imageService.getImageById(id);

        return imageOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/image/{id}")
    public void updateImage(@RequestBody ImageGallery image, @PathVariable Long id){
        image.setId(id);
        imageService.updateImage(image);
    }

    
    @DeleteMapping(path = "image/{id}")
    public String deleteImage(@PathVariable("id")Long id) {

		return imageService.deleteImage(id);
    }

}


