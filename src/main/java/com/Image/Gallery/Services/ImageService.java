package com.example.imagegallery.service;
package com.example.imagegallery.service;

import com.imagegallery.model.Image;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {
    private List<Image> gallery = new ArrayList<>();

    public void addImage(Image image) {
        gallery.add(image);
    }

    public List<Image> getAllImages() {
        return gallery;
    }
}