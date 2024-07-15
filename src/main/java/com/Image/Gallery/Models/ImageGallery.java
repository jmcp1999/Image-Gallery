package com.Image.Gallery.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "image-gallery")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageGallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "url")
    private String url;

    @Column(name = "description")
    private String description;
}