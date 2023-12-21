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
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author user
 */
@Entity
@Table(name="tbl_secretary_history")
public class SecretaryHistory {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonIgnore
    private Member member_id;
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department_id;
    
    @Column(name="start_date")
    private LocalDate start_date;
    @Column(name="end_date")
    private LocalDate end_date;

    public SecretaryHistory() {
    }

    public SecretaryHistory(Long id, Member member_id, Department department_id, LocalDate start_date, LocalDate end_date) {
        this.id = id;
        this.member_id = member_id;
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

    public Member getMember_id() {
        return member_id;
    }

    public void setMember_id(Member member_id) {
        this.member_id = member_id;
    }
    
    
    
}
