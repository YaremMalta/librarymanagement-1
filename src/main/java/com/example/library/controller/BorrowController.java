
package com.example.library.controller;

import com.example.library.dto.BorrowDto;
import com.example.library.model.Borrow;
import com.example.library.service.BorrowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.library.model.BorrowStatus; 

import java.util.List;

@RestController
@RequestMapping("/api/borrows") // API için temel URL
public class BorrowController {

    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    // Tüm ödünç alma işlemlerini listeleme
    @GetMapping
    public List<Borrow> getAllBorrows() {
        return borrowService.findAll();
    }

    // Yeni bir ödünç alma işlemi ekleme
    @PostMapping
    public ResponseEntity<Borrow> createBorrow(@RequestBody BorrowDto borrowDto) {
        Borrow borrow = borrowService.convertToEntity(borrowDto);
        Borrow createdBorrow = borrowService.save(borrow);
        return ResponseEntity.ok(createdBorrow);
    }

    // Belirli bir ödünç alma işlemini ID ile bulma
    @GetMapping("/{id}")
    public ResponseEntity<Borrow> getBorrowById(@PathVariable Long id) {
        Borrow borrow = borrowService.findById(id);
        if (borrow != null) {
            return ResponseEntity.ok(borrow);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Belirli bir ödünç alma işlemini güncelleme
    @PutMapping("/{id}")
    public ResponseEntity<Borrow> updateBorrow(@PathVariable Long id, @RequestBody BorrowDto borrowDto) {
        Borrow existingBorrow = borrowService.findById(id);
        if (existingBorrow != null) {
            // Burada güncellemeleri yapın
            existingBorrow.setStartDate(borrowDto.getStartDate()); // Start date'i güncelle
            existingBorrow.setEndDate(borrowDto.getEndDate()); // End date'i güncelle
            existingBorrow.setBorrowStatus(BorrowStatus.valueOf(borrowDto.getBorrowStatus()));
            // Kitap ve kullanıcıyı güncelleyin
            // existingBorrow.setBook(yourBookObject);
            // existingBorrow.setUser(yourUserObject);

            Borrow updatedBorrow = borrowService.save(existingBorrow);
            return ResponseEntity.ok(updatedBorrow);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Belirli bir ödünç alma işlemini silme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrow(@PathVariable Long id) {
        borrowService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


