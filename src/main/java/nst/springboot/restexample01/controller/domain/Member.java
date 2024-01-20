/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.controller.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.beans.Transient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author user
 */
@Entity
@Table (name = "tbl_member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;
    @Column (name = "firstname")
    private String firstname;
    @Column (name = "lastname")
    private String lastname;
     @ManyToOne
    @JoinColumn(name = "academic_title_id")
     @JsonIgnore
    private AcademicTitle academic_title;
     @ManyToOne
    @JoinColumn(name = "education_title_id")
     @JsonIgnore
    private EducationTitle education_title;
     @ManyToOne
    @JoinColumn(name = "scientific_field_id")
     @JsonIgnore
    private ScientificField scientific_field;
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AcademicTitleHistory> academicTitleHistories;
    
    
    
    
    public Member() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        return id != null ? id.equals(member.id) : member.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    

    public Member(Long id, String firstname, String lastname, AcademicTitle academic_title, EducationTitle education_title, ScientificField scientific_field, Department department, List<AcademicTitleHistory> academicTitleHistories) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.academic_title = academic_title;
        this.education_title = education_title;
        this.scientific_field = scientific_field;
        this.department = department;
        this.academicTitleHistories = academicTitleHistories;

    }

   

 

   

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<AcademicTitleHistory> getAcademicTitleHistories() {
        return academicTitleHistories;
    }

    public void setAcademicTitleHistories(List<AcademicTitleHistory> academicTitleHistories) {
        this.academicTitleHistories = academicTitleHistories;
    }

    public AcademicTitle getAcademic_title() {
        return academic_title;
    }

    public void setAcademic_title(AcademicTitle academic_title) {
        this.academic_title = academic_title;
    }

    public EducationTitle getEducation_title() {
        return education_title;
    }

    public void setEducation_title(EducationTitle education_title) {
        this.education_title = education_title;
    }

    public ScientificField getScientific_field() {
        return scientific_field;
    }

    public void setScientific_field(ScientificField scientific_field) {
        this.scientific_field = scientific_field;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  
    
    
    
}
