/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package nst.springboot.restexample01.controller.service;

import java.util.List;
import nst.springboot.restexample01.controller.domain.Department;
import nst.springboot.restexample01.dto.DepartmentDto;
import org.springframework.data.domain.Pageable;
/**
 *
 * @author student2
 */
public interface DepartmentService {
    DepartmentDto save(DepartmentDto departmentDto) throws Exception;
    DepartmentDto update (DepartmentDto departmentDto) throws Exception;
    List<DepartmentDto> getAll(Pageable pageable);
    List<DepartmentDto> getAll();
    void delete(Long id) throws Exception;
    Department findById(Long id) throws Exception;
}
