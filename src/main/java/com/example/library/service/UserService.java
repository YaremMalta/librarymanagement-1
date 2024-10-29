package com.example.library.service;

import com.example.library.model.User;
import com.example.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Kullanıcıyı kaydet
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // ID ile kullanıcıyı bul
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    // Email ile kullanıcıyı bul
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // FirstName ile kullanıcıları bul
    public List<User> findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    // LastName ile kullanıcıları bul
    public List<User> findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    // Kullanıcıyı güncelle
    public Optional<User> updateUser(Long id, User user) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            // Burada diğer alanları güncelle
            return userRepository.save(existingUser);
        });
    }

    // Kullanıcıyı sil
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Tüm kullanıcıları bul
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    
}



