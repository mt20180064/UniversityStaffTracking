/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.controller.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Size(min = 2, max = 10, message = "Broj znakova je od 2 do 10")
    @Column(name = "name")
    private String name;

     @OneToMany(mappedBy = "department")
     @JsonIgnore
    private List<Member> members;
    
     @ManyToOne
    @JoinColumn(name = "manager_id")
     @JsonIgnore
     private Member manager;
     @ManyToOne
    @JoinColumn(name = "secretary_id")
     @JsonIgnore
     private Member secretary;
     
     @OneToMany(mappedBy = "department_id")
     @JsonIgnore
     private List<SecretaryHistory> secretaryHistories;
     @OneToMany(mappedBy = "department_id")
     @JsonIgnore
     private List<ManagerHistory> managerHistories;
     
    public Department() {
    }

    public Department(Long id, String name, List<Member> members, Member manager, Member secretary, List<SecretaryHistory> secretaryHistories, List<ManagerHistory> managerHistories) {
        this.id = id;
        this.name = name;
        this.members = members;
        this.manager = manager;
        this.secretary = secretary;
        this.secretaryHistories = secretaryHistories;
        this.managerHistories = managerHistories;
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

    
}
