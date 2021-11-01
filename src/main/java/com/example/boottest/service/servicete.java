package com.example.boottest.service;

import com.example.boottest.dto.person;
import org.springframework.web.multipart.MultipartFile;

public interface servicete {
    public String mergetest(MultipartFile file, person ob);
    public Integer updateuser(String name);

//    public void testPublic();


}
