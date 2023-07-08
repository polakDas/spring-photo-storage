package com.mj.practice.photo.repository;

import org.springframework.data.repository.CrudRepository;

import com.mj.practice.photo.model.Photo;

public interface PhotosRepository extends CrudRepository<Photo, Integer> {

}
