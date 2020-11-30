package com.webwork.recruitsystem.Service;

import org.springframework.stereotype.Service;

import java.sql.Blob;


public interface ImageService {
    Blob selectImage(int id);
    int insertImage(Blob image);
}
