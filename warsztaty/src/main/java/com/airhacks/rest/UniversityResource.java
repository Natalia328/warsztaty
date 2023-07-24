package com.airhacks.rest;

import com.airhacks.university.lecturer.service.LecturerService;
import com.airhacks.university.lecturer.service.SubjectService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;

@Path("university")
@Consumes("application/json")
@Produces("application/json")
public class UniversityResource {

    @Inject
    private LecturerService lecturerService;

    @Inject
    private SubjectService subjectService;

    @POST
    @Path("lecturer")
    public void addNewLecturer(@RequestBody LecturerRequest request){
        lecturerService.addLecturer(request);
    }
    @GET
    @Path("lecturer/{id}")
    public LecturerResponse getLecturer(@PathParam("id") Long id){
        return lecturerService.getLecturer(id);
    }

    @GET
    @Path("lecturers")
    public LecturersResponse getLecturers(){
      return lecturerService.getLecturers();
    }

    @POST
    @Path("subject")
    public void addNewSubject(@RequestBody SubjectRequest request){
        subjectService.addNewSubject(request);

    }

    @GET
    @Path("subject/{id}")
    public SubjectResponse getSubject(@PathParam("id") Long id) {
        return subjectService.getSubject(id);
    }


}
