/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import java.util.List;
import nst.springboot.restexample01.controller.domain.AcademicTitleHistory;
import nst.springboot.restexample01.controller.service.MemberService;
import nst.springboot.restexample01.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/member")
public class MemberController {

    public MemberController(nst.springboot.restexample01.controller.service.MemberService memberService) {
        this.memberService = memberService;
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
    
     @PutMapping("/{memberId}/academic-title-history")
    public ResponseEntity<String> updateAcademicTitleHistory(@PathVariable Long memberId, @RequestBody AcademicTitleHistory academicTitleHistory) throws Exception {
        memberService.addAcademicTitleHistory(memberId, academicTitleHistory);
        return ResponseEntity.ok("Academic title history updated successfully.");
    }
}
