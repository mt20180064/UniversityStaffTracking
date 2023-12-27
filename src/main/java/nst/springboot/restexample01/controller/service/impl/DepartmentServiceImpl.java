/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.controller.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.crypto.Mac;
import nst.springboot.restexample01.controller.domain.Department;
import nst.springboot.restexample01.controller.domain.Member;
import nst.springboot.restexample01.controller.domain.Subject;
import nst.springboot.restexample01.controller.repository.DepartmentRepository;
import nst.springboot.restexample01.controller.repository.MemberRepository;
import nst.springboot.restexample01.controller.repository.SubjectRepository;
import nst.springboot.restexample01.controller.service.DepartmentService;
import nst.springboot.restexample01.converter.impl.DepartmentConverter;
import nst.springboot.restexample01.dto.DepartmentDto;
import nst.springboot.restexample01.dto.MemberDto;
import nst.springboot.restexample01.exception.DepartmentAlreadyExistException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author student2
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentConverter departmentConverter;
    private DepartmentRepository departmentRepository;
    private final SubjectRepository subjectRepository;
    private final MemberRepository memberRepository;

    public DepartmentServiceImpl(
            DepartmentRepository departmentRepository, DepartmentConverter departmentConverter, nst.springboot.restexample01.controller.repository.SubjectRepository subjectRepository, nst.springboot.restexample01.controller.repository.MemberRepository memberRepository) {
        this.departmentRepository = departmentRepository;
        this.departmentConverter = departmentConverter;
        this.subjectRepository = subjectRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    @Transactional
    public DepartmentDto save(DepartmentDto departmentDto) throws Exception {
        if (departmentDto.getId()!=null){
            throw new Exception ("You can't specify ID. Database does that so leave it null");
        }
        List<Member> m=departmentDto.getMembers();
        for (Member member : m) {
            if (member.getId()!=null){
                throw new Exception("leave memberID null. Database will initiate it");
            }
            
        }
        List<Subject> s = departmentDto.getSubjects();
        for (Subject subject : s) {
            if (subject.getId()!=null){
                throw new Exception("leave subjectID null. Database will initiate it");
            }
            
        }
        if(departmentDto.getManager_id()!=null || departmentDto.getSecretary_id()!=null || departmentDto.getSecretaryHistories()!=null || departmentDto.getManagerHistories()!=null){
            throw new Exception ("you can't specify manager and secretary this way. First make the department and then use method UPDATEMANAGER/UPDATESECRETARY");
        }
            //DTO - > Entity
            //Department department = new Department(departmentDto.getId(), departmentDto.getName());
            Department department = departmentConverter.toEntity(departmentDto);
            department = departmentRepository.save(department);
            for (Subject subject : s) {
            subject.setDepartment(department);
        }
            for (Member member : m) {
            member.setDepartment(department);
        }
            return departmentConverter.toDto(department);
        
        }

    @Override
    public void delete(Long id) throws Exception {
        //proveri da li postoji department
        Optional<Department> dept = departmentRepository.findById(id);
        if (dept.isPresent()) {
            //postoji
            Department department = dept.get();
            if (!department.getMembers().isEmpty()){
                for (Member member : department.getMembers()) {
                    member.setDepartment(null);
                }
            }
            if (!department.getSubjects().isEmpty()){
                for (Subject subject : department.getSubjects()) {
                    subject.setDepartment(null);
                }
            }
            
            departmentRepository.delete(department);
        } else {
            throw new Exception("Department does not exist!");
        }

    }

   
    @Override
    public DepartmentDto findById(Long id) throws Exception {
        Optional<Department> dept = departmentRepository.findById(id);
        if (dept.isPresent()) {
            //postoji
            Department department = dept.get();
            System.out.println(department.getManagerHistories());
            System.out.println(department.getSecretaryHistories());
            return departmentConverter.toDto(department);
            
        } else {
            throw new Exception("Department does not exist!");
        }
    }

    @Override
    public List<DepartmentDto> getAll(Pageable pageable) {
        return departmentRepository
                .findAll(pageable).getContent()
                .stream().map(entity -> departmentConverter.toDto(entity))
                .collect(Collectors.toList());
    }
@Override
    public List<DepartmentDto> getAll() {
        return departmentRepository
                .findAll()
                .stream().map(entity -> departmentConverter.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public DepartmentDto update(DepartmentDto departmentDto) throws Exception {
       
            Department department = departmentConverter.toEntity(departmentDto);
            department = departmentRepository.save(department);
         
            return departmentConverter.toDto(department);
    }
}
