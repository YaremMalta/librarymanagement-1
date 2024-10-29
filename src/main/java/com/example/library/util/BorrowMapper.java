package com.example.library.util;

import com.example.library.dto.BorrowDto;
import com.example.library.model.Borrow;

public class BorrowMapper {
    
    public static BorrowDto toDTO(Borrow borrow) {
        BorrowDto dto = new BorrowDto();
        dto.setId(borrow.getId());
        dto.setBookId(borrow.getBook() != null ? borrow.getBook().getId() : null);
        dto.setUserId(borrow.getUser() != null ? borrow.getUser().getId() : null);
        
        // Tekil tarih alanlarını DTO'ya ekliyoruz
        dto.setStartDate(borrow.getStartDate()); // Ödünç alma başlangıç tarihi
        dto.setEndDate(borrow.getEndDate()); // Ödünç alma bitiş tarihi
    

        dto.setBorrowStatus(borrow.getBorrowStatus().name()); // Ödünç durumunu ekle
        return dto;
    }
    
    public static Borrow toEntity(BorrowDto dto) {
        Borrow borrow = new Borrow();
        borrow.setId(dto.getId());
        
        // Borrow nesnesine tarihleri ekliyoruz
        borrow.setStartDate(dto.getStartDate()); // Ödünç alma başlangıç tarihi
        borrow.setEndDate(dto.getEndDate()); // Ödünç alma bitiş tarihi
    
        

        return borrow;
    }
}



