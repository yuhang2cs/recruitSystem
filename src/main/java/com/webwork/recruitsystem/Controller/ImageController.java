package com.webwork.recruitsystem.Controller;

import com.webwork.recruitsystem.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;
import java.sql.SQLException;


@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/image",produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_PNG_VALUE})
    public byte[] selectImage(@RequestParam("id") int id) {
        Blob image=imageService.selectImage(id);
        byte[] res;
        try {
            int blobLength = (int) image.length();
            res=image.getBytes(1, blobLength);
        }
        catch (SQLException e){
            System.out.println("get blob error");
            return null;
        }
        return res;
    }

    @RequestMapping("/upload/image")
    @ResponseBody
    public String insertImage(@RequestParam("file") MultipartFile multipartFile){
        return "fail";
    }
}
