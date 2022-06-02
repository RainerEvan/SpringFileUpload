package com.example.demo.service;

import java.io.IOException;
import java.util.stream.Stream;

import com.example.demo.model.FileInfo;
import com.example.demo.repo.FileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {
    
    @Autowired
    private FileRepository fileRepository;

    public FileInfo store(MultipartFile file) throws IOException{
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileInfo fileInfo = new FileInfo(fileName, file.getContentType(), file.getBytes());

        return fileRepository.save(fileInfo);
    }

    public FileInfo getFile(Long id){
        return fileRepository.findById(id).get();
    }

    public Stream<FileInfo> getAllFiles(){
        return fileRepository.findAll().stream();
    }
}
