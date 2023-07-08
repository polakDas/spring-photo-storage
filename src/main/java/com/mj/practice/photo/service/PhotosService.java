package com.mj.practice.photo.service;

import org.springframework.stereotype.Service;

import com.mj.practice.photo.model.Photo;
import com.mj.practice.photo.repository.PhotosRepository;

@Service
public class PhotosService {

    private final PhotosRepository photosRepository;

    public PhotosService(PhotosRepository photosRepository) {
        this.photosRepository = photosRepository;
    }

    public Iterable<Photo> get() {
        return photosRepository.findAll();
    }

    public Photo get(Integer id) {
        return photosRepository.findById(id).orElse(null);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
        photosRepository.save(photo);
        return photo;
    }

    public void remove(Integer id) {
        photosRepository.deleteById(id);
    }
}
