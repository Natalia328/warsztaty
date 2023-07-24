package com.airhacks.university.lecturer.service;

import com.airhacks.rest.*;
import com.airhacks.university.lecturer.dao.LecturerDao;
import com.airhacks.university.lecturer.model.LecturerEntity;
import com.airhacks.university.lecturer.model.SubjectEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Stateless
public class LecturerService {

    @Inject
    private LecturerDao lecturerDao;

    public void addLecturer(LecturerRequest request) {
        LecturerEntity lecturerEntity = new LecturerEntity();
        lecturerEntity.setFirstName(request.getFirstName());
        lecturerEntity.setLastName(request.getLastName());
        lecturerEntity.setEmail(request.getEmail());
        lecturerDao.addNewLecturer(lecturerEntity);
    }

    public LecturerResponse getLecturer(Long id){
        LecturerResponse response = new LecturerResponse();
        LecturerEntity entity = lecturerDao.getLecturer(id);
        response.setFirstName(entity.getFirstName());
        response.setLastName(entity.getLastName());
        response.setEmail(entity.getEmail());
        response.setId(entity.getId());

        Collection<SubjectDTO> subjectDTOS = getSubjectDTOS(entity);

        response.setSubjects(subjectDTOS);
        return response;
    }

    private Collection<SubjectDTO> getSubjectDTOS(LecturerEntity entity) {
        Collection<SubjectEntity> subjectEntities = entity.getSubjects();
        Collection<SubjectDTO> subjectDTOS = new ArrayList<>();

        for (SubjectEntity subjectEntity: subjectEntities) {
            SubjectDTO subjectDTO = new SubjectDTO();
            subjectDTO.setId(subjectEntity.getId());
            subjectDTO.setName(subjectEntity.getName());
            subjectDTO.setYear(subjectEntity.getYear());
            subjectDTOS.add(subjectDTO);
        }
        return subjectDTOS;
    }


    public LecturersResponse getLecturers(){
        LecturersResponse response = new LecturersResponse();
        List<LecturerEntity> lecturerEntities = lecturerDao.getLecturers();
        List<LecturerDTO> lecturerDTOS = new ArrayList<>();
        for (LecturerEntity lecturerEntity: lecturerEntities){
            LecturerDTO lecturerDTO = new LecturerDTO();
            lecturerDTO.setId(lecturerEntity.getId());
            lecturerDTO.setFirstName(lecturerEntity.getFirstName());
            lecturerDTO.setLastName(lecturerEntity.getLastName());
            lecturerDTO.setEmail(lecturerEntity.getEmail());
            lecturerDTOS.add(lecturerDTO);
        }
        response.setLecturers(lecturerDTOS);
        return response;
    }

    public LecturersResponse getLecturerDto() {
        LecturersResponse response = new LecturersResponse();
        List<LecturerDTO> lecturerDTOS = lecturerDao.getLecturersDto();
        response.setLecturers(lecturerDTOS);
        return response;
    }
}
