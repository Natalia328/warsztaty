package com.airhacks.rest;

import com.airhacks.todo.service.TodoItemService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;


public class GetTodoItemResponse {


    private List<String> todoItems;


    public List<String> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<String> todoItems) {
        this.todoItems = todoItems;
    }

}
