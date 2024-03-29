/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import javax.print.attribute.standard.Severity;
import nst.springboot.restexample01.controller.domain.ManagerHistory;
import nst.springboot.restexample01.controller.domain.Member;
import nst.springboot.restexample01.controller.domain.SecretaryHistory;
import nst.springboot.restexample01.controller.domain.Subject;

/**
 *
 * @author student2
 */
public class DepartmentDto implements Serializable{
    private Long id;
    
    @NotNull
    private String name;
    private Long manager;
    private Long secretary;
    private List<SecretaryHistory> secretaryHistorys;
    private List<ManagerHistory> managerHistorys;
 
    public DepartmentDto() {
    }

    public DepartmentDto(Long id, String name, Long manager, Long secretary, List<SecretaryHistory> secretaryHistorys, List<ManagerHistory> managerHistorys) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.secretary = secretary;
        this.secretaryHistorys = secretaryHistorys;
        this.managerHistorys = managerHistorys;
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

    public Long getManager() {
        return manager;
    }

    public void setManager(Long manager) {
        this.manager = manager;
    }

    public Long getSecretary() {
        return secretary;
    }

    public void setSecretary(Long secretary) {
        this.secretary = secretary;
    }

    public List<SecretaryHistory> getSecretaryHistorys() {
        return secretaryHistorys;
    }

    public void setSecretaryHistorys(List<SecretaryHistory> secretaryHistorys) {
        this.secretaryHistorys = secretaryHistorys;
    }

    public List<ManagerHistory> getManagerHistorys() {
        return managerHistorys;
    }

    public void setManagerHistorys(List<ManagerHistory> managerHistorys) {
        this.managerHistorys = managerHistorys;
    }

 

    

    
    
}
