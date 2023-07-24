package com.airhacks.todo.service;


import com.airhacks.rest.TodoItemDTO;
import com.airhacks.todo.model.TodoItem;
import com.airhacks.todo.repository.TodoItemDatabase;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Stateless
public class TodoItemService {

    @Inject
    private TodoItemDatabase database;

    public void addItem(String todoItemString) {
        TodoItem item = new TodoItem();
        item.setName(todoItemString);
        database.addTodoItem(item);
    }

    public List<String> getTodoItemStrings() {
        return database.getTodoItems().stream().map(e -> e.getName()).collect(Collectors.toList());
    }

    public List<String> getTodoItemStrings(String filterName) {
        if(filterName ==null ){
            return getTodoItemStrings();
        }
        return database.getTodoItems().stream()
                .filter(e -> e.getName().equals(filterName))
                .map(e -> e.getName()).collect(Collectors.toList());
    }

    public Optional<TodoItemDTO> getTodoItem(Long id) {
        return database.getTodoItems().stream()
                .filter(e -> e.getId().equals(id))
                .map(e -> map(e)).findAny();
    }

    private TodoItemDTO map(TodoItem item){
        TodoItemDTO dto = new TodoItemDTO();
        dto.setId(item.getId());
        dto.setName(item.getName());
        return dto;
    }


    public void deleteTodoItems() {
        database.deleteAll();
    }

//    public void delete(Long id) {
//        Optional<TodoItem> todoItemOptional = database.getTodoItems().stream()
//                .filter(e -> e.getId().equals(id))
//                .map(e -> map(e)).findAny();
//    }



}
