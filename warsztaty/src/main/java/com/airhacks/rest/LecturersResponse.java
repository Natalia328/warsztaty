package com.airhacks.rest;

import java.util.Collection;

public class LecturersResponse {

    private Collection<LecturerDTO> lecturers;

    public Collection<LecturerDTO> getLecturers() {
        return lecturers;
    }

    public void setLecturers(Collection<LecturerDTO> lecturers) {
        this.lecturers = lecturers;
    }
}
