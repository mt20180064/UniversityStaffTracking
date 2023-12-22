/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import nst.springboot.restexample01.controller.domain.AcademicTitle;
import nst.springboot.restexample01.controller.domain.AcademicTitleHistory;
import nst.springboot.restexample01.controller.domain.Member;
import nst.springboot.restexample01.controller.service.AcademicTitleHistoryService;
import nst.springboot.restexample01.controller.service.AcademicTitleService;
import nst.springboot.restexample01.controller.service.MemberService;
import nst.springboot.restexample01.converter.impl.AcademicTitleHistoryConverter;
import nst.springboot.restexample01.converter.impl.MemberConverter;
import nst.springboot.restexample01.dto.AcademicTitleHistoryDto;
import nst.springboot.restexample01.dto.MemberDto;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    List<AcademicTitleHistory> historiesofall= new LinkedList<>();
    
    public MemberController(nst.springboot.restexample01.controller.service.MemberService memberService, AcademicTitleHistoryService academicTitleHistoryService, MemberConverter memberConverter, AcademicTitleHistoryConverter academicTitleHistoryConverter, nst.springboot.restexample01.controller.service.AcademicTitleService academicTitleService) {
        this.memberService = memberService;
        this.academicTitleHistoryService = academicTitleHistoryService;
        this.memberConverter=memberConverter;
        this.academicTitleHistoryConverter=academicTitleHistoryConverter;
        this.academicTitleService = academicTitleService;
    }
   private final MemberService memberService;
   
   
   
   @GetMapping("/all")
    public ResponseEntity<List<MemberDto>> getAll(){
       List<MemberDto> members = memberService.getAll();
        return new ResponseEntity<>(members, HttpStatus.OK); 
    }
    
    @PostMapping("/save")
    public ResponseEntity<MemberDto> save (@Valid @RequestBody MemberDto memberDto) throws Exception{
        MemberDto m = memberService.save(memberDto);
        return new ResponseEntity<>(m,HttpStatus.CREATED);
    }
    
    @GetMapping("/findmember")
    public ResponseEntity<MemberDto> findById (@RequestParam Long id) throws Exception{
        MemberDto m = memberService.findById(id);
        
            return new ResponseEntity<>(m, HttpStatus.FOUND);
      
    }
    
    @PutMapping("/updateTitle")
  public ResponseEntity <MemberDto> updateTitle (@RequestParam Long id, @RequestParam Long at) throws Exception{
     MemberDto m = memberService.findById(id);
       
     AcademicTitle old = m.getAcademic_title();
        
     AcademicTitle academicTitle= academicTitleService.findById(at);
        
     m.setAcademic_title(academicTitle);
      
      
    AcademicTitleHistoryDto ath = new AcademicTitleHistoryDto(9l, memberConverter.toEntity(m), LocalDate.now(), LocalDate.now(), old, m.getScientific_field());
        System.out.println(ath);
     //m.getAcademicTitleHistories().add(academicTitleHistoryConverter.toEntity(ath));
        System.out.println("ovde");
     MemberDto me = memberService.save(m);
     System.out.println(me.getFirstname());
        System.out.println(me.getLastname());
        System.out.println(me.getAcademic_title().getName());
        System.out.println("sredjeni dto:"+me);
     AcademicTitleHistoryDto d = academicTitleHistoryService.save(ath);
     return new ResponseEntity<>(me, HttpStatus.OK);
  }
   
  
}
