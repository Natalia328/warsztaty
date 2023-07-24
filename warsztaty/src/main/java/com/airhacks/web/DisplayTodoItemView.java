package com.airhacks.web;

import com.airhacks.todo.service.TodoItemService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class DisplayTodoItemView implements Serializable {

    private List<String> todoItemStrings;

    public List<String> getTodoItemStrings() {
        return todoItemStrings;
    }

    public void setTodoItemStrings(List<String> todoItemStrings) {
        this.todoItemStrings = todoItemStrings;
    }

    @Inject
    private TodoItemService todoItemService;


    @PostConstruct
    public void init() {
        todoItemStrings = todoItemService.getTodoItemStrings();
    }

}
