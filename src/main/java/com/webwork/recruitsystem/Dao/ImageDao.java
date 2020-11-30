package com.webwork.recruitsystem.Dao;

import org.apache.ibatis.annotations.Mapper;

import java.sql.Blob;

@Mapper
public interface ImageDao {
    Blob getImage(int id);
    int insertImage(Blob image);
}
