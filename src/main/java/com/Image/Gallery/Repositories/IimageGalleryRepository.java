package com.Image.Gallery.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Image.Gallery.Models.ImageGallery;

@Repository
public interface IimageGalleryRepository extends JpaRepository<ImageGallery, Long> {
}