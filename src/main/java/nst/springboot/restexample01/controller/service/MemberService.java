/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package nst.springboot.restexample01.controller.service;

import java.util.List;
import nst.springboot.restexample01.controller.domain.AcademicTitleHistory;
import nst.springboot.restexample01.dto.MemberDto;

/**
 *
 * @author user
 */
public interface MemberService {
    MemberDto save(MemberDto memberDto)throws Exception;
    List<MemberDto> getAll();
    void delete(Long id) throws Exception;
    void update(MemberDto memberDto)throws Exception;
    MemberDto findById(Long id)throws Exception;
     void addAcademicTitleHistory(Long memberId, AcademicTitleHistory academicTitleHistory)throws Exception;
}
