/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.controller.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import nst.springboot.restexample01.controller.domain.AcademicTitleHistory;
import nst.springboot.restexample01.controller.domain.Department;

import nst.springboot.restexample01.controller.domain.Member;
import nst.springboot.restexample01.controller.repository.AcademicTitleHistoryRepository;
import nst.springboot.restexample01.controller.repository.DepartmentRepository;
import nst.springboot.restexample01.controller.repository.MemberRepository;
import nst.springboot.restexample01.controller.service.MemberService;
import nst.springboot.restexample01.converter.impl.AcademicTitleHistoryConverter;
import nst.springboot.restexample01.converter.impl.MemberConverter;
import nst.springboot.restexample01.dto.AcademicTitleHistoryDto;
import nst.springboot.restexample01.dto.DepartmentDto;
import nst.springboot.restexample01.dto.MemberDto;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberConverter memberConverter;
    private final MemberRepository memberRepository;
    private final AcademicTitleHistoryRepository academicTitleHistoryRepository;
    private final AcademicTitleHistoryConverter academicTitleHistoryConverter;
    private final DepartmentRepository departmentRepository;

    public MemberServiceImpl(nst.springboot.restexample01.converter.impl.MemberConverter memberConverter, nst.springboot.restexample01.controller.repository.MemberRepository memberRepository, nst.springboot.restexample01.controller.repository.AcademicTitleHistoryRepository academicTitleHistoryRepository, nst.springboot.restexample01.converter.impl.AcademicTitleHistoryConverter academicTitleHistoryConverter, nst.springboot.restexample01.controller.repository.DepartmentRepository departmentRepository) {
        this.memberConverter = memberConverter;
        this.memberRepository = memberRepository;
        this.academicTitleHistoryRepository= academicTitleHistoryRepository;
        this.academicTitleHistoryConverter = academicTitleHistoryConverter;
        this.departmentRepository = departmentRepository;
    }
    @Override
    @Transactional
    public MemberDto save(MemberDto memberDto) throws Exception {
         if (memberDto.getDepartmentId()==null){
             throw new Exception("You can not save a member without an existing department!");
         }
         Member member = memberConverter.toEntity(memberDto);
            member = memberRepository.save(member);
            return memberConverter.toDto(member);
        }
    

    @Override
    public List<MemberDto> getAll() {
        return memberRepository
                .findAll()
                .stream().map(entity -> memberConverter.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) throws Exception {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) {
            Member m = member.get();
            List<Department> deps = departmentRepository.findAll();
            for (Department dep : deps) {
                if (dep.getManager()==m){
                    dep.setManager(null);
                }
                if (dep.getSecretary()==m){
                    dep.setSecretary(null);
                }
            }
            memberRepository.delete(m);
        } else {
            throw new Exception("Member does not exist!");
        }
    }

    @Override
    public void update(MemberDto memberDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MemberDto findById(Long id) throws Exception {
       Optional<Member> m = memberRepository.findById(id);
        if (m.isPresent()) {
            //postoji
            Member member = m.get();
            System.out.println("u serviceimpl" +member);
            return memberConverter.toDto(member);
        } else {
            throw new Exception("Member does not exist!");
        }
    }
    
    
   

    @Override
    @Transactional
    public void updateAcademicTitleHistory(Member member, AcademicTitleHistoryDto academicTitleHistoryDto) {
        AcademicTitleHistory academicTitleHistory = academicTitleHistoryConverter.toEntity(academicTitleHistoryDto);
        member.getAcademicTitleHistories().add(academicTitleHistory);
        memberRepository.save(member);
    }
    
    
    
}

    

