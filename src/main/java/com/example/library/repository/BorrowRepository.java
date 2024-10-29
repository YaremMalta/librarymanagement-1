package com.example.library.repository;

import com.example.library.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {

    // Belirli bir tarih aralığında ödünç alma işlemlerini bulma
    List<Borrow> findByStartDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    
    // Belirli bir kullanıcıya ait tüm ödünç alma işlemlerini bulma
    List<Borrow> findByUserId(Long userId);

    // Belirli bir kitaba ait ödünç alma işlemlerini bulma
    List<Borrow> findByBookId(Long bookId);

    // Belirli bir tarih sonrası ödünç alma işlemlerini bulma
    List<Borrow> findByEndDateAfter(LocalDateTime endDate);
    
    // Belirli bir tarih öncesi ödünç alma işlemlerini bulma
    List<Borrow> findByStartDateBefore(LocalDateTime startDate);
}
