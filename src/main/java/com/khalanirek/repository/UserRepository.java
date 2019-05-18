package com.khalanirek.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.khalanirek.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
}
