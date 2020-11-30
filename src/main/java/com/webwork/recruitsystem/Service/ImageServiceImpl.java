package com.webwork.recruitsystem.Service;

import com.webwork.recruitsystem.Dao.ImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Blob;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageDao imageDao;

    @Override
    public Blob selectImage(int id) {
        return imageDao.getImage(id);
    }

    @Override
    public int insertImage(Blob image) {
        return imageDao.insertImage(image);
    }
}
