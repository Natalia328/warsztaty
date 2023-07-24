package com.airhacks.todo.service;

import com.airhacks.rest.TodoItemDTO;
import com.airhacks.rest.TodoItemResponse;
import com.airhacks.todo.model.jpa.TodoItemEntity;
import com.airhacks.todo.repository.TodoItemDao;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class TodoDatabaseService {

    @Inject
    private TodoItemDao todoItemDao;

    public void addItem(String name, int priority) {

        todoItemDao.addNewTodoItem(name, priority);
    }

    public TodoItemResponse getItem(Long id){
        TodoItemResponse response = new TodoItemResponse();
        TodoItemEntity entity = todoItemDao.getItem(id);
        response.setName(entity.getName());
        response.setPriority(entity.getPriority());
        response.setId(entity.getId());
        return response;
    }
}
