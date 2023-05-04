package com.smart.contact.manager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.contact.manager.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
