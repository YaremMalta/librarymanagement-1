package com.example.library.repository;

import com.example.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Kullanıcı e-posta adresine göre bulunur
    Optional<User> findByEmail(String email);
    
    // Kullanıcı adıyla kullanıcıları listele
    List<User> findByFirstName(String firstName);
    
    // Soyadıyla kullanıcıları listele
    List<User> findByLastName(String lastName);

}



