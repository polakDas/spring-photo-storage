package com.mj.practice.photo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;

@Table("PHOTOS")
public class Photo {
    @Id // primary key
    private Integer id;

    @NotBlank(message = "Filename shouldn't be empty") // fileName shouldn't be empty
    private String fileName;

    private String contentType;

    public Photo() { // empty constructor
    }

    // every other methods of this class are setter and getter. nothing special

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @JsonIgnore // I don't want to add this data when calling api
    private byte[] data;

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
