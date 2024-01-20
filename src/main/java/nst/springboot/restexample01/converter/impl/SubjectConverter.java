/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.converter.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import nst.springboot.restexample01.controller.domain.Department;
import nst.springboot.restexample01.controller.domain.Subject;
import nst.springboot.restexample01.controller.service.DepartmentService;
import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.DepartmentDto;
import nst.springboot.restexample01.dto.SubjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author student2
 */

@Component
public class SubjectConverter implements DtoEntityConverter<SubjectDto, Subject>{

    public SubjectConverter(nst.springboot.restexample01.controller.service.DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    
    private final DepartmentService departmentService;
    @Autowired
    private DepartmentConverter departmentConverter;
    
    @Override
    public SubjectDto toDto(Subject entity) {
        Department d = entity.getDepartment();
        return new SubjectDto(
                entity.getId(), 
                entity.getName(), entity.getEsbp(), d.getId(), d.getName()
                
        );
    }

    @Override
    public Subject toEntity(SubjectDto dto) {
        try {
            Department d = departmentService.findById(dto.getDepartmentId());
           
            return new Subject(
                    dto.getId(),
                    dto.getName(),
                    dto.getEsbp(),
                    (d)
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        } return null;
    }
    
}
