package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/image/")
@CrossOrigin(origins = "*")
public class UploadController {
    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping(value = "/{imageName}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public byte[] getImage(@PathVariable String imageName) throws IOException {
        Path imagePath = Paths.get(uploadPath, imageName);
        return Files.readAllBytes(imagePath);
    }
}
