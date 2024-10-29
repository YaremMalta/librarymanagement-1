package com.example.library.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitle(String title);  // Kitap başlığına göre kitap bulma
    List<Book> findByAuthor(String author);    // Yazar adına göre kitap bulma
    List<Book> findByBookType(String bookType); // Kitap türüne göre kitap bulma (isteğe bağlı)


}






