package com.mj.practice.photo.web;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mj.practice.photo.model.Photo;
import com.mj.practice.photo.service.PhotosService;

@RestController
public class DownloadController {

    private final PhotosService photosService;

    public DownloadController(PhotosService photosService) {
        this.photosService = photosService;
    }

    @GetMapping("/download/{id}") // download the image by image id
    public ResponseEntity<byte[]> download(@PathVariable Integer id) { // response entity for download
        Photo photo = photosService.get(id);
        if (photo == null) // if no photo found return 404
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        byte[] data = photo.getData();
        HttpHeaders headers = new HttpHeaders(); // for multimedia requests
        headers.setContentType(MediaType.valueOf(photo.getContentType()));
        ContentDisposition build = ContentDisposition.builder("attachment").filename(photo.getFileName()).build();
        headers.setContentDisposition(build);

        return new ResponseEntity<byte[]>(data, headers, HttpStatus.OK);
    }
}
