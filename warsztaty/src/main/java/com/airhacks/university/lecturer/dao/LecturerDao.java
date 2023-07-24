package com.airhacks.university.lecturer.dao;

import com.airhacks.rest.LecturerDTO;
import com.airhacks.todo.model.jpa.TodoItemEntity;
import com.airhacks.university.lecturer.model.LecturerEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class LecturerDao {

    @PersistenceContext(unitName = "pawUnitMySQL")
    private EntityManager entityManager;

    public void addNewLecturer(LecturerEntity lecturer) {
        entityManager.persist(lecturer);
    }


    public LecturerEntity getLecturer(Long id) {
        return entityManager
                .createQuery("SELECT l FROM LecturerEntity l " + "WHERE l.id = :id",
                        LecturerEntity.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<LecturerEntity> getLecturers(){
        return entityManager
                .createQuery("SELECT l FROM LecturerEntity l", LecturerEntity.class)
                .getResultList();
    }

    public List<LecturerDTO> getLecturersDto() {
        return entityManager
                .createQuery("SELECT new com.airhacks.rest.LecturerDTO(l.id, l.firstName," +
                        "l.lastName, l.email) FROM LecturerEntity l", LecturerDTO.class)
                .getResultList();
    }

}
