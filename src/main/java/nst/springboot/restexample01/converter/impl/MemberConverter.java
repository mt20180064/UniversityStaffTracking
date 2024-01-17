/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.converter.impl;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import nst.springboot.restexample01.controller.domain.Department;
import nst.springboot.restexample01.controller.domain.Member;
import nst.springboot.restexample01.controller.service.DepartmentService;
import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.DepartmentDto;
import nst.springboot.restexample01.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author user
 */
@Component
public class MemberConverter implements DtoEntityConverter<MemberDto, Member> {

    public MemberConverter(nst.springboot.restexample01.controller.service.DepartmentService DepartmentService) {
        this.DepartmentService = DepartmentService;
    }
    private final DepartmentService DepartmentService;
    @Autowired
    private DepartmentConverter departmentConverter;
    @Override
    public MemberDto toDto(Member e) {
       Department d = e.getDepartment();
        return new MemberDto(
                e.getId(), 
                e.getFirstname(),e.getLastname(), e.getAcademic_title(),e.getEducation_title(), e.getScientific_field(), 
                 e.getAcademicTitleHistories(), e.getTitle_start(),e.getDepartment().getId(), e.getDepartment().getName());
    }

    @Override
    public Member toEntity(MemberDto t) {
        try {
            DepartmentDto department =  DepartmentService.findById(t.getDepartmentId());
            return new Member (t.getId(), t.getFirstname(), t.getLastname(), t.getAcademic_title(), t.getEducation_title(), t.getScientific_field(), departmentConverter.toEntity(department), t.getAcademicTitleHistories(), LocalDate.MIN);
        } catch (Exception ex) {
            ex.printStackTrace();
        }return null;
    }
    
}
