/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.controller.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import nst.springboot.restexample01.controller.domain.AcademicTitleHistory;
import nst.springboot.restexample01.controller.domain.Member;
import nst.springboot.restexample01.controller.repository.AcademicTitleHistoryRepository;
import nst.springboot.restexample01.controller.repository.MemberRepository;
import nst.springboot.restexample01.controller.service.AcademicTitleHistoryService;
import nst.springboot.restexample01.converter.impl.AcademicTitleHistoryConverter;
import nst.springboot.restexample01.dto.AcademicTitleHistoryDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Service
public class AcademicTitleHistoryServiceImpl implements AcademicTitleHistoryService{
private final AcademicTitleHistoryRepository academicTitleHistoryRepository;
private final MemberRepository memberRepository;
private final AcademicTitleHistoryConverter academicTitleHistoryConverter;
    public AcademicTitleHistoryServiceImpl(AcademicTitleHistoryRepository academicTitleHistoryRepository, MemberRepository memberRepository, AcademicTitleHistoryConverter academicTitleHistoryConverter) {
        this.academicTitleHistoryRepository = academicTitleHistoryRepository;
        this.memberRepository= memberRepository;
        this.academicTitleHistoryConverter=academicTitleHistoryConverter;
    }

  
    @Override
    public List<AcademicTitleHistoryDto> findByMember(Long m) {
       
         return academicTitleHistoryRepository
                .findByMemberId(m)
                .stream().map(entity -> academicTitleHistoryConverter.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AcademicTitleHistoryDto> findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AcademicTitleHistoryDto save(AcademicTitleHistoryDto academicTitleHistoryDto) throws Exception {
          AcademicTitleHistory a = academicTitleHistoryConverter.toEntity(academicTitleHistoryDto);
        System.out.println(a);
        AcademicTitleHistory ath =academicTitleHistoryRepository.save(a);
        System.out.println(ath);
        return academicTitleHistoryConverter.toDto(ath);
    }

    @Override
    public List<AcademicTitleHistory> getAll() {
    List<AcademicTitleHistory> ath = academicTitleHistoryRepository.findAll();
    return ath;
    }

    
    

   
    
}
