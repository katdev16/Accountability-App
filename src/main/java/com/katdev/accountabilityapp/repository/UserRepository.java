package com.katdev.accountabilityapp.repository;

import com.katdev.accountabilityapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {}
