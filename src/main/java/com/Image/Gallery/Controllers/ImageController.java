package com.Image.Gallery.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.Image.Gallery.Models.ImageGallery;
import com.Image.Gallery.Services.ImageService;
import org.springframework.web.server.ResponseStatusException;

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
    @ResponseStatus(HttpStatus.CREATED)
    public ImageGallery addImage(@RequestBody ImageGallery newImage) {
        return imageService.saveImage(newImage);
    }

    @GetMapping(path = "/images")
    public List<ImageGallery> getAllImages() {
        return imageService.getAllImages();
    }

    @GetMapping(path = "/images/{id}")
    public ImageGallery getImageById(@PathVariable Long id) {
        return imageService.getImageById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Image not found"));
    }

    @PutMapping(path = "/images/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateImage(@RequestBody ImageGallery image, @PathVariable Long id) {
        image.setId(id);
        imageService.updateImage(image)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Image not found"));
    }

    @DeleteMapping(path = "/images/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteImage(@PathVariable Long id) {
        if (!imageService.deleteImage(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Image not found");
        }
    }
}
