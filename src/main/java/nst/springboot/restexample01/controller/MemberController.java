/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import nst.springboot.restexample01.controller.domain.AcademicTitle;
import nst.springboot.restexample01.controller.domain.AcademicTitleHistory;
import nst.springboot.restexample01.controller.domain.Department;
import nst.springboot.restexample01.controller.domain.Member;
import nst.springboot.restexample01.controller.service.AcademicTitleHistoryService;
import nst.springboot.restexample01.controller.service.AcademicTitleService;
import nst.springboot.restexample01.controller.service.MemberService;
import nst.springboot.restexample01.converter.impl.AcademicTitleHistoryConverter;
import nst.springboot.restexample01.converter.impl.DepartmentConverter;
import nst.springboot.restexample01.converter.impl.MemberConverter;
import nst.springboot.restexample01.dto.AcademicTitleHistoryDto;
import nst.springboot.restexample01.dto.DepartmentDto;
import nst.springboot.restexample01.dto.MemberDto;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberConverter memberConverter;
    private final AcademicTitleHistoryService academicTitleHistoryService;
    private final AcademicTitleHistoryConverter academicTitleHistoryConverter;
    private final AcademicTitleService academicTitleService;
    private final DepartmentConverter departmentConverter;
    
    
    public MemberController(nst.springboot.restexample01.controller.service.MemberService memberService, AcademicTitleHistoryService academicTitleHistoryService, MemberConverter memberConverter, AcademicTitleHistoryConverter academicTitleHistoryConverter, nst.springboot.restexample01.controller.service.AcademicTitleService academicTitleService, nst.springboot.restexample01.converter.impl.DepartmentConverter departmentConverter) {
        this.memberService = memberService;
        this.academicTitleHistoryService = academicTitleHistoryService;
        this.memberConverter=memberConverter;
        this.academicTitleHistoryConverter=academicTitleHistoryConverter;
        this.academicTitleService = academicTitleService;
        this.departmentConverter = departmentConverter;
    }
   private final MemberService memberService;
   
   
   
   @GetMapping
    public ResponseEntity<List<MemberDto>> getAll(){
       List<MemberDto> members = memberService.getAll();
        return new ResponseEntity<>(members, HttpStatus.OK); 
    }
    
    @PostMapping
    public ResponseEntity<MemberDto> save (@Valid @RequestBody MemberDto memberDto) throws Exception{
        //kada cuvam novog membera koji nema istoriju promene titule, problem je sto nemam na koju listu da dodam trenutnu
        //titulu pa cu sada to da implementiram
        if (memberDto.getAcademicTitleHistories()==null){
            memberDto.setAcademicTitleHistories(new ArrayList<>());
            System.out.println("uslo u petlju");
        }
        MemberDto m = memberService.save(memberDto);
        return new ResponseEntity<>(m,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        memberService.delete(id);
        return new ResponseEntity<>("Member removed!", HttpStatus.OK);

    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> findById (@PathVariable Long id) throws Exception{
        MemberDto m = memberService.findById(id);
        Member mem = memberConverter.toEntity(m);
        Department d = mem.getDepartment();
        m.setDepartmentId(d.getId());
        m.setDepartmentName(d.getName());
            return new ResponseEntity<>(m, HttpStatus.FOUND);
    }
    
 /*   @PutMapping("/updateTitle")
  public ResponseEntity <MemberDto> updateTitle (@RequestParam Long id, @RequestParam Long at) throws Exception{
     MemberDto m = memberService.findById(id);
     AcademicTitle old = m.getAcademic_title();
     AcademicTitle academicTitle= academicTitleService.findById(at);
     m.setAcademic_title(academicTitle);
     int duzinaliste = m.getAcademicTitleHistories().size();
     
          LocalDate ds;   
     if (duzinaliste>0){
      ds = m.getAcademicTitleHistories().get(duzinaliste-1).getEndDate();
  } 
     else {
          ds = m.getTitle_start();
     }
    AcademicTitleHistoryDto ath = new AcademicTitleHistoryDto(90l, memberConverter.toEntity(m), ds, LocalDate.now(), old, m.getScientific_field());
     MemberDto me = memberService.save(m);
     AcademicTitleHistoryDto d = academicTitleHistoryService.save(ath);
     return new ResponseEntity<>(me, HttpStatus.OK);
  }*/
    
@PutMapping("/{id}")
public ResponseEntity<MemberDto> updateMember(
    @RequestParam Long memberId,
    @RequestBody MemberDto memberDto,
    @RequestParam(required = true) Boolean updateAcademicTitleHistory) throws Exception {
    
    MemberDto memberToUpdate = memberService.findById(memberId);
       if (memberDto.getAcademicTitleHistories()!=null && validateAth(memberDto.getAcademicTitleHistories())){
        for (AcademicTitleHistory academicTitleHistory : memberDto.getAcademicTitleHistories()) {
            memberToUpdate.getAcademicTitleHistories().add(academicTitleHistory);
        }
    }
            //ovde osim upisanih dodajemo i staru koja usled promene treba da se doda
            for (AcademicTitleHistory academicTitleHistory : memberToUpdate.getAcademicTitleHistories()) {
            if (academicTitleHistory.getEndDate()==null){
                if (Boolean.TRUE.equals(updateAcademicTitleHistory)&& validation(memberToUpdate, memberDto))
                academicTitleHistory.setEndDate( LocalDate.now());
            }
          //  LocalDate startDateOfTitle = last.getEndDate();
            //AcademicTitleHistory ath = new AcademicTitleHistory(memberConverter.toEntity(memberToUpdate), startDateOfTitle, LocalDate.now(), memberToUpdate.getAcademic_title(), memberToUpdate.getScientific_field());
            //memberToUpdate.getAcademicTitleHistories().add(ath);
            
    }
    
    if (memberDto.getFirstname()!=null && !memberDto.getFirstname().equals("string")){
        memberToUpdate.setFirstname(memberDto.getFirstname());
    }
 
     if (memberDto.getLastname()!=null && !memberDto.getLastname().equals("string")){
        memberToUpdate.setLastname(memberDto.getLastname());
    }
   
     if (memberDto.getAcademic_title().getId()!=null && memberDto.getAcademic_title().getId()!=0){
        memberToUpdate.setAcademic_title(memberDto.getAcademic_title());
        AcademicTitleHistory newath = new AcademicTitleHistory(memberConverter.toEntity(memberToUpdate), LocalDate.now(), null, memberToUpdate.getAcademic_title(), memberToUpdate.getScientific_field());  
        memberToUpdate.getAcademicTitleHistories().add(newath);
    }

 
    if (memberDto.getEducation_title().getId()!=null && memberDto.getEducation_title().getId()!=0){
       memberToUpdate.setEducation_title(memberDto.getEducation_title());
    }
   
    if (memberDto.getScientific_field().getId()!=null && memberDto.getScientific_field().getId()!=0){
        memberToUpdate.setScientific_field(memberDto.getScientific_field());
    }
    
    
    if (memberDto.getDepartmentId()!=null && memberDto.getDepartmentId()!=0){
       memberToUpdate.setDepartmentId(memberDto.getDepartmentId()); 
    }
    
    MemberDto updatedMember = memberService.update(memberToUpdate);
    return new ResponseEntity<>(updatedMember, HttpStatus.OK);
}

    private boolean validation(MemberDto memberToUpdate, MemberDto memberDto) throws Exception {
        if (memberDto.getAcademic_title().getId()==0){
            throw new Exception ("Choose not to update ath (choose false) or enter the new title.");
        }
       if (memberToUpdate.getAcademic_title().equals(memberDto.getAcademic_title())){
           throw new Exception ("Member already has that academic title.");
       }
       if (memberDto.getAcademic_title()==null  ){
           throw new Exception("If you want to update academic title history, you have to type new academic title. It can't stay null.");
       }

       else return true;
    }

    private boolean validateAth(List<AcademicTitleHistory> academicTitleHistories) {
        for (AcademicTitleHistory academicTitleHistory : academicTitleHistories) {
            if (academicTitleHistory.getAcademicTitle().getId()==0 || academicTitleHistory.getAcademicTitle()==null) return false;
            if (academicTitleHistory.getScientificField().getId()==0 || academicTitleHistory.getScientificField()==null) return false;
        } return true;
    }
   
  
}
