package com.hqjin.tmall.util;

import org.springframework.web.multipart.MultipartFile;

public class UploadedImageFile {
    private MultipartFile image;
    public void setImage(MultipartFile image){
        this.image=image;
    }

    public MultipartFile getImage() {
        return image;
    }
}
