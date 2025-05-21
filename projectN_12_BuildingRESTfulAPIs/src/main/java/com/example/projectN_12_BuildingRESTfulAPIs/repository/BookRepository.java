package com.example.projectN_12_BuildingRESTfulAPIs.repository;

import com.example.projectN_12_BuildingRESTfulAPIs.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

