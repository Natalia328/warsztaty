package com.airhacks.todo.repository;

import com.airhacks.todo.model.TodoItem;

import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class TodoItemDatabase {

    private long todoItemIdCounter = 1L;
    private List<TodoItem> todoItems = new ArrayList<>();
    public void addTodoItem(TodoItem item) {
        item.setId(todoItemIdCounter);
        todoItemIdCounter = todoItemIdCounter +1;
        todoItems.add(item);
    }


    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void deleteAll() {
        todoItems.clear();
    }

    public void delete(TodoItem item) {
        todoItems.remove(item);
    }
}
