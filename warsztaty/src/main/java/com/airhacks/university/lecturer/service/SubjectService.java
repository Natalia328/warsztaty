package com.airhacks.university.lecturer.service;

import com.airhacks.rest.LecturerDTO;
import com.airhacks.rest.LecturerResponse;
import com.airhacks.rest.SubjectRequest;
import com.airhacks.rest.SubjectResponse;
import com.airhacks.university.lecturer.dao.LecturerDao;
import com.airhacks.university.lecturer.dao.SubjectDao;
import com.airhacks.university.lecturer.model.LecturerEntity;
import com.airhacks.university.lecturer.model.SubjectEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class SubjectService {

    @Inject
    private SubjectDao subjectDao;
    @Inject
    private LecturerDao lecturerDao;


    public void addNewSubject(SubjectRequest request){
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setName(request.getName());
        subjectEntity.setYear(request.getYear());
        LecturerEntity lecturerEntity = lecturerDao.getLecturer(request.getLecturerId());
        subjectEntity.setLecturer(lecturerEntity);

        subjectDao.addNewSubject(subjectEntity);
    }

    public SubjectResponse getSubject(Long id){
        SubjectResponse response = new SubjectResponse();
        SubjectEntity subjectEntity = subjectDao.getSubject(id);
        response.setId(subjectEntity.getId());
        response.setName(subjectEntity.getName());
        response.setYear(subjectEntity.getYear());
        LecturerDTO lecturer = new LecturerDTO();
        LecturerEntity lecturerEntity = subjectEntity.getLecturer();
        lecturer.setEmail(lecturerEntity.getEmail());
        lecturer.setFirstName(lecturerEntity.getFirstName());
        lecturer.setLastName(lecturerEntity.getLastName());
        lecturer.setId(lecturerEntity.getId());
        response.setLecturer(lecturer);
        return response;
    }


}
