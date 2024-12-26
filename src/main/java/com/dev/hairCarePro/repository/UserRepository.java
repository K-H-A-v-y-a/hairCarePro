package com.dev.hairCarePro.repository;

import com.dev.hairCarePro.model.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
