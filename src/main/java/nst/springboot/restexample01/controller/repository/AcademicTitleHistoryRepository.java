/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package nst.springboot.restexample01.controller.repository;

import java.util.List;
import java.util.Optional;
import nst.springboot.restexample01.controller.domain.AcademicTitleHistory;
import nst.springboot.restexample01.controller.domain.Member;
import nst.springboot.restexample01.dto.AcademicTitleHistoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface AcademicTitleHistoryRepository extends JpaRepository<AcademicTitleHistory, Long>{

    public List<AcademicTitleHistory> findByMemberId(Long memberId);
   
    
    
    
}
