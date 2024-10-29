
package com.example.library.service;

import com.example.library.dto.BorrowDto;
import com.example.library.model.Borrow;
import com.example.library.model.BorrowStatus;
import com.example.library.model.Book;
import com.example.library.model.User;
import com.example.library.repository.BorrowRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {

    private final BorrowRepository borrowRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    public BorrowService(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    // Tüm ödünç alma işlemlerini bulma
    public List<Borrow> findAll() {
        return borrowRepository.findAll();
    }

    // Yeni ödünç alma işlemi ekleme
    public Borrow save(Borrow borrow) {
        return borrowRepository.save(borrow);
    }

    // ID ile ödünç alma işlemi bulma
    public Borrow findById(Long id) {
        Optional<Borrow> optionalBorrow = borrowRepository.findById(id);
        return optionalBorrow.orElse(null);
    }

    // ID ile ödünç alma işlemini silme
    public void deleteById(Long id) {
        borrowRepository.deleteById(id);
    }
    
    public Borrow convertToEntity(BorrowDto borrowDto) {
        System.out.println("Converting BorrowDto: " + borrowDto);
        
        Borrow borrow = new Borrow();
        
        if (borrowDto.getId() != null) {
            borrow.setId(borrowDto.getId());
        }
        
        borrow.setStartDate(borrowDto.getStartDate());
        borrow.setEndDate(borrowDto.getEndDate());
        
        // Kitap ve kullanıcı nesnelerini burada ayarlayın
        Book book = bookService.findBookById(borrowDto.getBookId())
            .orElseThrow(() -> new RuntimeException("Book not found with ID: " + borrowDto.getBookId()));
        borrow.setBook(book);
        
        User user = userService.findUserById(borrowDto.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found with ID: " + borrowDto.getUserId()));
        borrow.setUser(user);
        
        borrow.setBorrowStatus(BorrowStatus.valueOf(borrowDto.getBorrowStatus()));
        return borrow;
    }
    
    
     
}
