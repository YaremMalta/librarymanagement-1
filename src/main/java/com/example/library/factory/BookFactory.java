package com.example.library.factory;

import com.example.library.model.Book;
import com.example.library.model.BookGenre;

public interface BookFactory {
    Book createBook(BookGenre genre);
}
