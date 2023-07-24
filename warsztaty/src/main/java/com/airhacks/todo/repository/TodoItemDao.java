package com.airhacks.todo.repository;

import com.airhacks.todo.model.jpa.TodoItemEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TodoItemDao {
    @PersistenceContext (unitName = "pawUnitMySQL")
    private EntityManager entityManager;


    public void addNewTodoItem(String name, int priority) {
        TodoItemEntity entity = new TodoItemEntity();
        entity.setName(name);
        entity.setPriority(priority);
        entityManager.persist(entity);
    }

    public TodoItemEntity getItem(Long id){
        return
                entityManager.find(TodoItemEntity.class, id);
    }
}
