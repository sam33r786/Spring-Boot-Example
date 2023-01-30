package com.sjahangir.springboottestjpa.repositories.user;

import com.sjahangir.springboottestjpa.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
