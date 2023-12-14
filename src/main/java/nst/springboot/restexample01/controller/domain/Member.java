/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.controller.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

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
    private Long member_id;
    @Column (name = "firstname")
    private String firstname;
    @Column (name = "lastname")
    private String lastname;
    @Column (name = "academic_title")
    private String academic_title;
    @Column (name = "education_title")
    private String education_title;
    @Column (name = "scientific_field")
    private String scientific_field;
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "member")
    private List<AcademicTitleHistory> academicTitleHistories;
    public Member() {
    }

    public Member(Long member_id, String firstname, String lastname, String academic_title, String education_title, String scientific_field, Department department) {
        this.member_id = member_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.academic_title = academic_title;
        this.education_title = education_title;
        this.scientific_field = scientific_field;
        this.department = department;
    }

    public Long getMember_id() {
        return member_id;
    }

    public void setMember_id(Long member_id) {
        this.member_id = member_id;
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

    public String getAcademic_title() {
        return academic_title;
    }

    public void setAcademic_title(String academic_title) {
        this.academic_title = academic_title;
    }

    public String getEducation_title() {
        return education_title;
    }

    public void setEducation_title(String education_title) {
        this.education_title = education_title;
    }

    public String getScientific_field() {
        return scientific_field;
    }

    public void setScientific_field(String scientific_field) {
        this.scientific_field = scientific_field;
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
    
    
    
}
