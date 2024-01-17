/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.dto;

import java.io.Serializable;

/**
 *
 * @author Dules
 */

public class SubjectDto implements Serializable {
    private Long id;
    private String name;
    private int esbp;
    private Long departmentId;
    private String departmentName;

    public SubjectDto() {
    }

    public SubjectDto(Long id, String name, int esbp, Long departmentId, String departmentName) {
        this.id = id;
        this.name = name;
        this.esbp = esbp;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEsbp() {
        return esbp;
    }

    public void setEsbp(int esbp) {
        this.esbp = esbp;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

   
   
    
}
