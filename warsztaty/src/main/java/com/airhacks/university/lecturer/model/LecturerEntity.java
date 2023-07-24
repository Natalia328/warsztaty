package com.airhacks.university.lecturer.model;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "lecturer")
public class LecturerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "lecturer", fetch = FetchType.LAZY)
    private Collection<SubjectEntity> subjects;

    public Collection<SubjectEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(Collection<SubjectEntity> subjects) {
        this.subjects = subjects;
    }
}
