package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

import com.example.demo.models.TodoItem;
import com.example.demo.services.TodoItemService;

@Controller
public class TodoFormController {
	
	@Autowired
	private TodoItemService todoItemService;
	
	@GetMapping("/create-todo")
	public String showCreateForm(TodoItem todoItem)
	{
		return "new-todo-item";
	}
	
	@PostMapping("/todo")
	public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model)
	{
		TodoItem item = new TodoItem();
		item.setDescription(todoItem.getDescription());
		item.setIsComplete(todoItem.getIsComplete());
		
		todoItemService.save(todoItem);
		return "redirect:/";
	}
}
