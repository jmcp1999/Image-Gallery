package com.Image.Gallery.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Image.Gallery.Models.ImageGallery;
import com.Image.Gallery.Repositories.IimageGalleryRepository;
import java.util.List;


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

    public ImageGallery getById(Long id){
        ImageGallery imageGallery;
        imageGallery = imageGalleryRepository.findById(id).orElseThrow();
        return imageGallery;

    }

    public void updateImage(ImageGallery images){
        imageGalleryRepository.save(images);
    }
    

    public String deleteImages(Long id){
        try{
            imageGalleryRepository.deleteById(id);
            return "todo ok";
        }catch (Exception error){
        return "todo mal";

        }
    }

}
    
