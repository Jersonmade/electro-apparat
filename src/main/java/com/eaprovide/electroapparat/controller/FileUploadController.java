package com.eaprovide.electroapparat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/upload")
@CrossOrigin(origins = "*")
public class FileUploadController {

    @PostMapping("/docs")
    public ResponseEntity<String> handleFileDocumentationUpload(@RequestParam("file") MultipartFile file) {
        String uploadPath = "C:\\Users\\Asus\\OneDrive\\Рабочий стол\\spring";

        try {
            byte[] bytes = file.getBytes();
            java.nio.file.Path path = Paths.get(uploadPath + File.separator + file.getOriginalFilename());
            Files.write(path, bytes);
            return ResponseEntity.ok("Файл успешно загружен!");
        }
        catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Ошибка загрузки файла");
        }
    }

    @PostMapping("/photo")
    public ResponseEntity<String> handleFilePhotoUpload(@RequestParam("file") MultipartFile file) {
        String uploadPath = "C:\\Users\\Asus\\OneDrive\\Рабочий стол\\spring";

        try {
            byte[] bytes = file.getBytes();
            java.nio.file.Path path = Paths.get(uploadPath + File.separator + file.getOriginalFilename());
            Files.write(path, bytes);
            return ResponseEntity.ok("Файл успешно загружен");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Ошибка загрузки файла");
        }
    }
}
