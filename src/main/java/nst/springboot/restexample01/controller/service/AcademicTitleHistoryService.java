/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package nst.springboot.restexample01.controller.service;

import java.util.List;
import java.util.Optional;
import nst.springboot.restexample01.controller.domain.Member;
import nst.springboot.restexample01.dto.AcademicTitleHistoryDto;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */

public interface AcademicTitleHistoryService {
    List<AcademicTitleHistoryDto> findByMember (Long memberId);
     Optional <AcademicTitleHistoryDto> findById (Long id);
    AcademicTitleHistoryDto save(AcademicTitleHistoryDto academicTitleHistoryDto) throws Exception;
}
