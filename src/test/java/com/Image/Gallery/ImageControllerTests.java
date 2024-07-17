package com.Image.Gallery;

import com.Image.Gallery.Models.ImageGallery;
import com.Image.Gallery.Repositories.IimageGalleryRepository;
import com.Image.Gallery.Services.ImageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ImageServiceTest {

    @Mock
    private IimageGalleryRepository imageGalleryRepository;

    @InjectMocks
    private ImageService imageService;

    private ImageGallery image1;
    private ImageGallery image2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        image1 = new ImageGallery(1L, "Title1", "URL1", "Description1");
        image2 = new ImageGallery(2L, "Title2", "URL2", "Description2");
    }

    @Test
    void saveImage() {
        when(imageGalleryRepository.save(image1)).thenReturn(image1);
        ImageGallery savedImage = imageService.saveImage(image1);
        assertEquals(image1, savedImage);
    }

    @Test
    void getAllImages() {
        List<ImageGallery> images = Arrays.asList(image1, image2);
        when(imageGalleryRepository.findAll()).thenReturn(images);

        List<ImageGallery> result = imageService.getAllImages();
        assertEquals(2, result.size());
        assertEquals(images, result);
    }

    @Test
    void getImageById() {
        when(imageGalleryRepository.findById(1L)).thenReturn(Optional.of(image1));
        Optional<ImageGallery> result = imageService.getImageById(1L);
        assertTrue(result.isPresent());
        assertEquals(image1, result.get());
    }

    @Test
    void updateImage() {
        when(imageGalleryRepository.existsById(image1.getId())).thenReturn(true);
        imageService.updateImage(image1);
        verify(imageGalleryRepository, times(1)).save(image1);
    }

    @Test
    void deleteImage() {
        when(imageGalleryRepository.existsById(1L)).thenReturn(true);
        String result = imageService.deleteImage(1L);
        verify(imageGalleryRepository, times(1)).deleteById(1L);
        assertEquals("Image deleted successfully", result);
    }
}