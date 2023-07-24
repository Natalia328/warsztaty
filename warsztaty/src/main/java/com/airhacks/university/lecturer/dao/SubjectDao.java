package com.airhacks.university.lecturer.dao;

import com.airhacks.university.lecturer.model.LecturerEntity;
import com.airhacks.university.lecturer.model.SubjectEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SubjectDao {

    @PersistenceContext(unitName = "pawUnitMySQL")
    private EntityManager entityManager;

    public void addNewSubject(SubjectEntity subject){
        entityManager.persist(subject);
    }

    public SubjectEntity getSubject(Long id) {
        return entityManager.find(SubjectEntity.class, id);
    }

}
