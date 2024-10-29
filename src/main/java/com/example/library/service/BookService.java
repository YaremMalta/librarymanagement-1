package com.example.library.service;

import com.example.library.factory.BookFactory;
import com.example.library.model.Book;
import com.example.library.model.BookGenre;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookFactory bookFactory;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Optional<Book> findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book createBook(BookGenre genre, Book bookDetails) {
        Book newBook = bookFactory.createBook(genre);
        newBook.setTitle(bookDetails.getTitle());
        newBook.setAuthor(bookDetails.getAuthor());
        newBook.setAvailable(bookDetails.isAvailable());
        newBook.setBookType(genre);

       

        return bookRepository.save(newBook);
    }

    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id).map(book -> {
            if (updatedBook.getTitle() != null) {
                book.setTitle(updatedBook.getTitle());
            }
            if (updatedBook.getAuthor() != null) {
                book.setAuthor(updatedBook.getAuthor());
            }
            book.setAvailable(updatedBook.isAvailable());

            if (updatedBook.getBookType() != null) {
                book.setBookType(updatedBook.getBookType());
            }

            return bookRepository.save(book);
        }).orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }

    public void deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new RuntimeException("Book not found with id " + id);
        }
    }
}





