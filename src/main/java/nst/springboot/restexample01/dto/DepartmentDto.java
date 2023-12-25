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
    private List<Member> members;
    private List<Subject> subjects;
    private Member manager_id;
    private Member secretary_id;
    
  private List<ManagerHistory>managerHistories;
  private List<SecretaryHistory>secretaryHistories;
    public DepartmentDto() {
    }

    public DepartmentDto(Long id, String name, List<Member> members, List<Subject> subjects, Member manager_id, Member secretary_id, List<ManagerHistory> managerHistories, List<SecretaryHistory> secretaryHistories) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.subjects = subjects;
        this.manager_id = manager_id;
        this.secretary_id = secretary_id;
        this.managerHistories = managerHistories;
        this.secretaryHistories = secretaryHistories;
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

    public List<Member> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        return "DepartmentDto{" + "id=" + id + ", name=" + name + ", members=" + members + ", manager_id=" + manager_id + ", secretary_id=" + secretary_id + ", managerHistories=" + managerHistories + ", secretaryHistories=" + secretaryHistories + '}';
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

   

 
   

    

    

    public Member getManager_id() {
        return manager_id;
    }

    public void setManager_id(Member manager_id) {
        this.manager_id = manager_id;
    }

    public Member getSecretary_id() {
        return secretary_id;
    }

    public void setSecretary_id(Member secretary_id) {
        this.secretary_id = secretary_id;
    }

    public List<ManagerHistory> getManagerHistories() {
        return managerHistories;
    }

    public void setManagerHistories(List<ManagerHistory> managerHistories) {
        this.managerHistories = managerHistories;
    }

    public List<SecretaryHistory> getSecretaryHistories() {
        return secretaryHistories;
    }

    public void setSecretaryHistories(List<SecretaryHistory> secretaryHistories) {
        this.secretaryHistories = secretaryHistories;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

 

    

    
    
}
