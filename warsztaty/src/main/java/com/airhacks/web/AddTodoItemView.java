package com.airhacks.web;

import com.airhacks.todo.service.TodoItemService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;


@Named
@RequestScoped
public class AddTodoItemView implements Serializable {

    private String todoItemString;

    public String getTodoItemString() {
        return todoItemString;
    }

    public void setTodoItemString(String todoItemString) {
        this.todoItemString = todoItemString;
    }

    @Inject
    private TodoItemService todoItemService;

    public String addTodoItem(){
        todoItemService.addItem(todoItemString);
        return "displaytodoitem";
    }

}
