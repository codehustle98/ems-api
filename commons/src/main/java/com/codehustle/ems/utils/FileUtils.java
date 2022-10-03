package com.codehustle.ems.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {

    public static File getBirthdayImg() throws IOException {
        Resource resource = new ClassPathResource("assets/birthday.jpg");
        InputStream inputStream = resource.getInputStream();
        return resource.getFile();
    }
}
