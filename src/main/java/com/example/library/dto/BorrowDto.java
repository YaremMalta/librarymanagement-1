package com.example.library.dto;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.time.LocalDateTime;

public class BorrowDto {
    private Long id; // Ödünç işleminin ID'si
    private Long bookId; // Kitap ID'si
    private Long userId; // Kullanıcı ID'si

   
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startDate; // Ödünç alma başlangıç tarihi


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endDate; // Ödünç alma bitiş tarihi

    private String borrowStatus; // Ödünç durumu

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getBorrowStatus() { 
        return borrowStatus;
    }

    public void setBorrowStatus(String borrowStatus) { 
        this.borrowStatus = borrowStatus;
    }
}



