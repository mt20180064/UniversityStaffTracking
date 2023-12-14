/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.controller.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

/**
 *
 * @author user
 */
@Entity
public class AcademicTitleHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDate startDate;
    private LocalDate endDate;
    private String academicTitle;
    private String scientificField;

    public AcademicTitleHistory() {
    }

    public AcademicTitleHistory(Long id, Member member, LocalDate startDate, LocalDate endDate, String academicTitle, String scientificField) {
        this.id = id;
        this.member = member;
        this.startDate = startDate;
        this.endDate = endDate;
        this.academicTitle = academicTitle;
        this.scientificField = scientificField;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getAcademicTitle() {
        return academicTitle;
    }

    public void setAcademicTitle(String academicTitle) {
        this.academicTitle = academicTitle;
    }

    public String getScientificField() {
        return scientificField;
    }

    public void setScientificField(String scientificField) {
        this.scientificField = scientificField;
    }
    
    
    
}
