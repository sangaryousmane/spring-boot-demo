package com.dailycodebuffer.springbootdemo.repository.users;

import com.dailycodebuffer.springbootdemo.entities.users.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
