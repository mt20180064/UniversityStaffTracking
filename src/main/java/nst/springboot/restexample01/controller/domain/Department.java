/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.controller.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.List;

/**
 *
 * @author student2
 */
@Entity
@Table(name = "tbl_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message = "Ime je obavezno polje")
    @Column(name = "name")
    private String name;

     @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST)
     @JsonIgnore
    private List<Member> members;
    
     @OneToMany(mappedBy="department", cascade=CascadeType.PERSIST)
     @JsonIgnore
     private List<Subject> subjects;
     
     @ManyToOne 
     @JoinColumn(name = "manager_id")
     @JsonIgnore
     private Member manager;
     @ManyToOne
    @JoinColumn(name = "secretary_id")
     @JsonIgnore
     private Member secretary;
     @OneToMany(mappedBy = "department_id", cascade = CascadeType.ALL)
     //@JsonIgnore
     private List<ManagerHistory> managerHistories;
     @OneToMany(mappedBy = "department_id", cascade = CascadeType.ALL)
     //@JsonIgnore
     private List<SecretaryHistory> secretaryHistories;
     
     
     
    public Department() {
    }

    public Department(Long id, String name, List<Member> members, List<Subject> subjects, Member manager, Member secretary, List<ManagerHistory> managerHistories, List<SecretaryHistory> secretaryHistories) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.subjects = subjects;
        this.manager = manager;
        this.secretary = secretary;
        this.managerHistories = managerHistories;
        this.secretaryHistories = secretaryHistories;
    }

  

   

   

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getManager() {
        return manager;
    }

    public void setManager(Member manager) {
        this.manager = manager;
    }

    public Member getSecretary() {
        return secretary;
    }

    public void setSecretary(Member secretary) {
        this.secretary = secretary;
    }

    public List<SecretaryHistory> getSecretaryHistories() {
        return secretaryHistories;
    }

    public void setSecretaryHistories(List<SecretaryHistory> secretaryHistories) {
        this.secretaryHistories = secretaryHistories;
    }

    public List<ManagerHistory> getManagerHistories() {
        return managerHistories;
    }

    public void setManagerHistories(List<ManagerHistory> managerHistories) {
        this.managerHistories = managerHistories;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    
}
