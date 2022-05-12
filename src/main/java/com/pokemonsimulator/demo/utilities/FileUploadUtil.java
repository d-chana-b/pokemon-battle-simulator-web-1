package com.pokemonsimulator.demo.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

//this is a utility class for creating directory if not exists, and save the uploaded file from MultipartFile object to a file system
public class FileUploadUtil {

    // public static void saveFile(String uploadDir, String fileName,
    //         MultipartFile multipartFile) throws IOException {
    //     Path uploadPath = Paths.get(uploadDir);

    //     if (!Files.exists(uploadPath)) {
    //         Files.createDirectories(uploadPath);
    //     }

    //     try (InputStream inputStream = multipartFile.getInputStream()) {
    //         Path filePath = uploadPath.resolve(fileName);
    //         Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
    //     } catch (IOException ioe) {
    //         throw new IOException("Could not save image file: " + fileName, ioe);
    //     }
    // }


    public static void saveFile(MultipartFile file, String uploadDirectory) throws IOException{
        String imageUUId;
        if (!file.isEmpty()) {
            imageUUId = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDirectory, imageUUId);
            Files.write(fileNameAndPath, file.getBytes());
        }
    }
}
