package com.airhacks.store.service;

import com.airhacks.rest.*;
import com.airhacks.rest.store_rest.UserDTO;
import com.airhacks.rest.store_rest.UserRequest;
import com.airhacks.rest.store_rest.UserResponse;
import com.airhacks.rest.store_rest.UsersResponse;
import com.airhacks.store.dao.UserDao;
import com.airhacks.store.model.jpa.UserEntity;


import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserService {

        @Inject
        private UserDao userDao;

        public void addUser(UserRequest request) {
            UserEntity userEntity = new UserEntity();
            userEntity.setFirstName(request.getFirstName());
            userEntity.setLastName(request.getLastName());
            userEntity.setEmail(request.getEmail());
            userEntity.setPassword(request.getPassword());
            userDao.addNewUser(userEntity);
        }

        public UserResponse getUser(Long id){
            UserResponse response = new UserResponse();
            UserEntity entity = userDao.getUser(id);
            response.setFirstName(entity.getFirstName());
            response.setLastName(entity.getLastName());
            response.setEmail(entity.getEmail());
            response.setPassword(entity.getPassword());
            response.setId(entity.getId());

//            Collection<SubjectDTO> subjectDTOS = getSubjectDTOS(entity);
//            response.setSubjects(subjectDTOS);
            return response;
        }

//        private Collection<SubjectDTO> getSubjectDTOS(LecturerEntity entity) {
//            Collection<SubjectEntity> subjectEntities = entity.getSubjects();
//            Collection<SubjectDTO> subjectDTOS = new ArrayList<>();
//
//            for (SubjectEntity subjectEntity: subjectEntities) {
//                SubjectDTO subjectDTO = new SubjectDTO();
//                subjectDTO.setId(subjectEntity.getId());
//                subjectDTO.setName(subjectEntity.getName());
//                subjectDTO.setYear(subjectEntity.getYear());
//                subjectDTOS.add(subjectDTO);
//            }
//            return subjectDTOS;
//        }


        public UsersResponse getUsers(){
            UsersResponse response = new UsersResponse();
            List<UserEntity> userEntities = userDao.getUsers();
            List<UserDTO> userDTOS = new ArrayList<>();
            for (UserEntity userEntity: userEntities){
                UserDTO userDTO = new UserDTO();
                userDTO.setId(userEntity.getId());
                userDTO.setFirstName(userEntity.getFirstName());
                userDTO.setLastName(userEntity.getLastName());
                userDTO.setEmail(userEntity.getEmail());
                userDTO.setPassword(userEntity.getPassword());
                userDTOS.add(userDTO);
            }
            response.setUsers(userDTOS);
            return response;
        }

        public UsersResponse getUserDto() {
            UsersResponse response = new UsersResponse();
            List<UserDTO> userDTOS = userDao.getUsersDto();
            response.setUsers(userDTOS);
            return response;
        }
    }

