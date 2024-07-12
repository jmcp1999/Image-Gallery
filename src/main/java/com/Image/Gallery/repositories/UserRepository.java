package com.Image.Gallery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Image.Gallery.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // No es necesario agregar métodos para leer un usuario por ID
    // Spring Data JPA proporcionará este método automáticamente
}
