/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.dto;

import java.io.Serializable;
import java.util.List;
import nst.springboot.restexample01.controller.domain.AcademicTitle;
import nst.springboot.restexample01.controller.domain.AcademicTitleHistory;
import nst.springboot.restexample01.controller.domain.Department;
import nst.springboot.restexample01.controller.domain.EducationTitle;
import nst.springboot.restexample01.controller.domain.ScientificField;

/**
 *
 * @author user
 */
public class MemberDto implements Serializable{
    private Long id;
    private String firstname;
    private String lastname;
    private AcademicTitle academic_title;
    private EducationTitle education_title;
    private ScientificField scientific_field;
    private DepartmentDto departmentDto;
    private List<AcademicTitleHistory> academicTitleHistories;

    public MemberDto() {
    }

   

    public MemberDto(Long id, String firstname, String lastname, AcademicTitle academic_title, EducationTitle education_title, ScientificField scientific_field, DepartmentDto departmentDto, List<AcademicTitleHistory> academicTitleHistories) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.academic_title = academic_title;
        this.education_title = education_title;
        this.scientific_field = scientific_field;
        this.departmentDto = departmentDto;
        this.academicTitleHistories = academicTitleHistories;
    }

  


  

    public DepartmentDto getDepartmentDto() {
        return departmentDto;
    }

    public void setDepartmentDto(DepartmentDto departmentDto) {
        this.departmentDto = departmentDto;
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

    public List<AcademicTitleHistory> getAcademicTitleHistories() {
        return academicTitleHistories;
    }

    public void setAcademicTitleHistories(List<AcademicTitleHistory> academicTitleHistories) {
        this.academicTitleHistories = academicTitleHistories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

   
    
    
    
}
