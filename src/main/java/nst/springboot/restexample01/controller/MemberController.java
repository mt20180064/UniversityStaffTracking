/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import nst.springboot.restexample01.controller.domain.AcademicTitleHistory;
import nst.springboot.restexample01.controller.domain.Member;
import nst.springboot.restexample01.controller.service.AcademicTitleHistoryService;
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
    
    public MemberController(nst.springboot.restexample01.controller.service.MemberService memberService, AcademicTitleHistoryService academicTitleHistoryService, MemberConverter memberConverter, AcademicTitleHistoryConverter academicTitleHistoryConverter) {
        this.memberService = memberService;
        this.academicTitleHistoryService = academicTitleHistoryService;
        this.memberConverter=memberConverter;
        this.academicTitleHistoryConverter=academicTitleHistoryConverter;
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
    
   @PutMapping("/newATH")
public ResponseEntity<MemberDto> updateAcademicTitleHistory(@RequestParam Long memberId, @RequestBody AcademicTitleHistory ath) throws Exception {
    MemberDto m = memberService.findById(memberId);
    Member member = memberConverter.toEntity(m);

    // Create AcademicTitleHistory instance without saving it yet
    AcademicTitleHistory current = new AcademicTitleHistory(member, LocalDate.now(), LocalDate.now(), m.getAcademic_title(), m.getScientific_field());

    // Save AcademicTitleHistory first
    AcademicTitleHistoryDto athd = academicTitleHistoryService.save(academicTitleHistoryConverter.toDto(current));

    // Update Member with AcademicTitleHistory reference
    m.setAcademic_title(ath.getAcademicTitle());
    m.setScientific_field(ath.getScientificField());

    // Add AcademicTitleHistory to Member's collection
    m.getAcademicTitleHistories().add(current);

    // Set the Member for the AcademicTitleHistory
    current.setMember(member);

    // Save the updated Member
    MemberDto finalMember = memberService.save(m);

    return new ResponseEntity<>(finalMember, HttpStatus.OK);
}
   
}
