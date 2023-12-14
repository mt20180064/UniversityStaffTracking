/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.dto;

import nst.springboot.restexample01.controller.domain.Department;

/**
 *
 * @author user
 */
public class MemberDto {
    private Long member_id;
    private String firstname;
    private String lastname;
    private String academic_title;
    private String education_title;
    private String scientific_field;
    private DepartmentDto departmentDto;

    public MemberDto() {
    }

    public MemberDto(Long member_id, String firstname, String lastname, String academic_title, String education_title, String scientific_field, DepartmentDto departmentDto) {
        this.member_id = member_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.academic_title = academic_title;
        this.education_title = education_title;
        this.scientific_field = scientific_field;
        this.departmentDto = departmentDto;
    }

    public DepartmentDto getDepartmentDto() {
        return departmentDto;
    }

    public void setDepartmentDto(DepartmentDto departmentDto) {
        this.departmentDto = departmentDto;
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
    
    
    
}
