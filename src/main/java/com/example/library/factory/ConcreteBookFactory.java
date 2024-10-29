package com.example.library.factory;

import com.example.library.model.Book;
import com.example.library.model.BookGenre;
import org.springframework.stereotype.Component;

@Component
public class ConcreteBookFactory implements BookFactory {
    @Override
    public Book createBook(BookGenre genre) {
        Book book = new Book();
        book.setBookType(genre);

        // BookGenre türüne göre switch-case yapısı
        switch (genre) {
            case ROMANTIC:
                System.out.println("Creating a Romantic book.");
                // Romantik kitap için ek ayarlar
                break;
            case SCIENCEFICTION:
                System.out.println("Creating a Science Fiction book.");
                // Bilim kurgu kitabı için ek ayarlar
                break;
            case ADVENTURE:
                System.out.println("Creating an Adventure book.");
                // Macera kitabı için ek ayarlar
                break;
            case CLASSIC:
                System.out.println("Creating a Classic book.");
                // Klasik kitap için ek ayarlar
                break;
            case CHILDREN:
                System.out.println("Creating a Children's book.");
                // Çocuk kitabı için ek ayarlar
                break;
            default:
                System.out.println("Unknown genre.");
                break;
        }

        return book;
    }
}



