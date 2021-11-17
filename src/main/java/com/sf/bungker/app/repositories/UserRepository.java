package com.sf.bungker.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sf.bungker.app.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    public User findByEmail(String email);
}