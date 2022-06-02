package com.example.demo.repo;

import com.example.demo.model.FileInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileInfo,Long> {
    
}
