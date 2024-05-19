package com.example.demo.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements UploadService{

    @Value("${amazonProperties.bucketName}")
    private String bucketName;

    @Value("${amazonProperties.endpointUrl}")
    private String endpointUrl;

    @Value("${upload.path}")
    private String pathUpload;

    @Value("${image.url:}")
    private String imageUrl;

    @Value("${environment.name}")
    private String environmentName;

//    @Autowired
//    private AmazonS3 s3Client;

    //    private File convertMultiPartFileToFile(MultipartFile file) {
//        File convertedFile = new File(file.getOriginalFilename());
//        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
//            fos.write(file.getBytes());
//        } catch (IOException e) {
//            log.error("Error converting multipartFile to file", e);
//        }
//        return convertedFile;
//    }
//    public ResponseApi<String> uploadFile(MultipartFile file) {
//        File fileObj = convertMultiPartFileToFile(file);
//        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
//        s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
//        fileObj.delete();
//        return new ResponseApi<String>("Upload file success",200, endpointUrl + "/" + bucketName + "/" + fileName.replaceAll(" ",""));
//    }

    private String getFileExtension(String fileName) {
        int lastIndexOf = fileName.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return fileName.substring(lastIndexOf);
    }

//    public ResponseEntity<ResponseApi<?>> uploadMultipleFile(MultipartFile[] files) {
//        try {
//            List<String> listFile = new ArrayList<String>();
//            Path path = Paths.get(pathUpload);
//            if (!Files.isDirectory(path)) {
//                Files.createDirectories(path);
//            }
//            for (MultipartFile file : files) {
//                UUID uuid = UUID.randomUUID();
//                String randomFileName = uuid.toString();
//                String fileName = file.getOriginalFilename();
//                Path fileUploadPath = Paths.get(pathUpload, randomFileName + getFileExtension(fileName));
//                Files.copy(file.getInputStream(), fileUploadPath);
//                listFile.add(fileUploadPath.toAbsolutePath().toString());
//            }
//            return new ResponseEntity<>(new ResponseApi<>("Upload success", 200, listFile), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(new ResponseApi<>("Upload failure", 400), HttpStatus.BAD_REQUEST);
//        }
//    }


    @Override
    public String uploadFile(MultipartFile file) {
        try {
            Path path = Paths.get(pathUpload);
            if (!Files.isDirectory(path)) {
                Files.createDirectories(path);
            }
            UUID uuid = UUID.randomUUID();
            String randomFileName = uuid.toString();
            String originalFilename = file.getOriginalFilename();
            String fileName = randomFileName + getFileExtension(originalFilename);
            Path fileUploadPath = Paths.get(pathUpload, fileName);
            Files.copy(file.getInputStream(), fileUploadPath);
            return imageUrl + fileName;
        } catch (Exception e) {
            return null;
        }
    }

//    public ResponseApi<?> deleteFile(String fileName) {
//        s3Client.deleteObject(bucketName, fileName);
//        return new ResponseApi<>("Delete file success", 200);
//    }
//
//    public ResponseApi<?> createBucket(String name) {
//        if (s3Client.doesBucketExistV2(name)) {
//            return new ResponseApi<>("This bucket already exist", 400);
//        } else {
//            try {
//                s3Client.createBucket(name);
//                return new ResponseApi<>("Create bucket success", 200);
//            } catch (AmazonS3Exception e) {
//                return new ResponseApi<>("Cannot create bucket", 400);
//            }
//        }
//    }
//
//    public ResponseApi<?> getListBucket() {
//        List<Bucket> buckets = s3Client.listBuckets();
//        return new ResponseApi<List<Bucket>>("Get list bucket success", 200, buckets);
//    }
}