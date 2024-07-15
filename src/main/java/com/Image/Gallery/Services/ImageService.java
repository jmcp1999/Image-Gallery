package com.Image.Gallery.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Image.Gallery.Models.ImageGallery;
import com.Image.Gallery.Repositories.ImageGalleryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageGalleryRepository imageGalleryRepository;

    public ImageGallery saveImage(ImageGallery image) {
        return imageGalleryRepository.save(image);
    }

}