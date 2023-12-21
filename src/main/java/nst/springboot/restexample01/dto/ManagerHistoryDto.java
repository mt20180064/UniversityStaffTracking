/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.dto;

import java.io.Serializable;
import java.time.LocalDate;
import nst.springboot.restexample01.controller.domain.Department;
import nst.springboot.restexample01.controller.domain.Member;

/**
 *
 * @author user
 */
public class ManagerHistoryDto implements Serializable{
     private Long id;
    private Member membed_id;
    private Department department_id;
    private LocalDate start_date;
    private LocalDate end_date;

    public ManagerHistoryDto() {
    }

    public ManagerHistoryDto(Long id, Member membed_id, Department department_id, LocalDate start_date, LocalDate end_date) {
        this.id = id;
        this.membed_id = membed_id;
        this.department_id = department_id;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMembed_id() {
        return membed_id;
    }

    public void setMembed_id(Member membed_id) {
        this.membed_id = membed_id;
    }

    public Department getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Department department_id) {
        this.department_id = department_id;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }
    
    
    
    
}
