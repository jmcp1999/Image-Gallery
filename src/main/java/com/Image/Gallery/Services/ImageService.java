package com.Image.Gallery.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Image.Gallery.Models.ImageGallery;
import com.Image.Gallery.Repositories.IimageGalleryRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    private final IimageGalleryRepository imageGalleryRepository;

    @Autowired
    public ImageService(IimageGalleryRepository imageGalleryRepository) {
        this.imageGalleryRepository = imageGalleryRepository;
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

    public void updateImage(ImageGallery image) {
        imageGalleryRepository.save(image);
    }

    public String deleteImage(Long id) {
        try {
            imageGalleryRepository.deleteById(id);
        return "all good";
    }catch (Exception error) {
        return "all bad";  
    }

  }

}