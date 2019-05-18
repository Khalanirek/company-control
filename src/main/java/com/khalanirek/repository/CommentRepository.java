package com.khalanirek.repository;

import org.springframework.data.repository.CrudRepository;

import com.khalanirek.entity.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
