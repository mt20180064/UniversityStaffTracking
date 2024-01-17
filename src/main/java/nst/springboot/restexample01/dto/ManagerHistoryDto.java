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
    private MemberDto member_id;
    private LocalDate start_date;
    private LocalDate end_date;

    public ManagerHistoryDto() {
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

    public ManagerHistoryDto(Long id, MemberDto member_id, LocalDate start_date, LocalDate end_date) {
        this.id = id;
        this.member_id = member_id;
        this.start_date = start_date;
        this.end_date = end_date;
    }

  

 

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public MemberDto getMember_id() {
        return member_id;
    }

    public void setMember_id(MemberDto member_id) {
        this.member_id = member_id;
    }
    
    
    
    
}
