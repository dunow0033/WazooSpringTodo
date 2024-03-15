package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import com.example.demo.models.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long>{
	
}
