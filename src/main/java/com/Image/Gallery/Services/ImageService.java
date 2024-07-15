package com.Image.Gallery.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Image.Gallery.Models.ImageGallery;
import com.Image.Gallery.Repositories.IimageGalleryRepository;

@Service
public class ImageService {

    @Autowired
    private IimageGalleryRepository imageGalleryRepository;

    public ImageGallery saveImage(ImageGallery image) {
        return imageGalleryRepository.save(image);
    }

    public ImageGallery saveImage(ImageGallery image) {
        return imageGalleryRepository.save(image);
    }

    public List<ImageGallery> getAllImages() {
        return imageGalleryRepository.findAll();
    }

    public Optional<ImageGallery> getImageById(Long id) {
        return imageGalleryRepository.findById(id);
    }

}