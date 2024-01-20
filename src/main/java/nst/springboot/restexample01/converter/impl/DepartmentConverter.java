/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.converter.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import nst.springboot.restexample01.controller.domain.Department;
import nst.springboot.restexample01.controller.domain.Member;
import nst.springboot.restexample01.controller.service.MemberService;
import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.DepartmentDto;
import nst.springboot.restexample01.dto.MemberDto;
import org.springframework.stereotype.Component;

/**
 *
 * @author student2
 */

@Component
public class DepartmentConverter implements DtoEntityConverter<DepartmentDto, Department>{

    
    @Override
    public DepartmentDto toDto(Department department) {
        
      DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setId(department.getId());
        departmentDto.setName(department.getName());
if (department.getManager() != null) {
            departmentDto.setManager(department.getManager().getId());
        }

        if (department.getSecretary() != null) {
            departmentDto.setSecretary(department.getSecretary().getId());
        }
        return departmentDto;
    }

    @Override
    public Department toEntity(DepartmentDto dto) {
        
        Department department = new Department();
        department.setName(dto.getName());
    
/* try {
        MemberDto m = memberService.findById(dto.getManager());
        department.setManager(memberConverter.toEntity(m));
       
    } catch (Exception ex) {
        department.setManager(null);
       
    }
    try {
        MemberDto s= memberService.findById(dto.getSecretary());
        department.setSecretary(memberConverter.toEntity(s));
        
    } catch(Exception ex){
        department.setSecretary(null);
    }*/
        return department;
    }
    
}
