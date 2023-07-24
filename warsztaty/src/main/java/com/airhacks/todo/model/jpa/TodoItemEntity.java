package com.airhacks.todo.model.jpa;

import javax.persistence.*;

    @Entity
    @Table(name = "todo_item")
    public class TodoItemEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "name", unique = true)
        private String name;

        @Column(name = "priority", nullable = false)
        private int priority;

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

