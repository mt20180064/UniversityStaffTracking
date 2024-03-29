/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import nst.springboot.restexample01.controller.domain.Department;
import nst.springboot.restexample01.controller.domain.ManagerHistory;
import nst.springboot.restexample01.controller.domain.Member;
import nst.springboot.restexample01.controller.domain.SecretaryHistory;
import nst.springboot.restexample01.controller.service.DepartmentService;
import nst.springboot.restexample01.controller.service.ManagerHistoryService;
import nst.springboot.restexample01.controller.service.MemberService;
import nst.springboot.restexample01.controller.service.SecretaryHistoryService;
import nst.springboot.restexample01.converter.impl.DepartmentConverter;
import nst.springboot.restexample01.converter.impl.MemberConverter;
import nst.springboot.restexample01.dto.DepartmentDto;
import nst.springboot.restexample01.dto.MemberDto;
import nst.springboot.restexample01.exception.DepartmentAlreadyExistException;
import nst.springboot.restexample01.exception.MyErrorDetails;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
 * @author student2
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final MemberService memberService;
    private final MemberConverter memberConverter;
    private final DepartmentConverter departmentConverter;
    

    public DepartmentController(DepartmentService departmentService, nst.springboot.restexample01.controller.service.MemberService memberService, MemberConverter memberConverter, DepartmentConverter departmentConverter, ManagerHistoryService managerHistoryService, nst.springboot.restexample01.controller.service.SecretaryHistoryService secretaryHistoryService) {
        this.departmentService = departmentService;

        System.out.println("nst.springboot.restexample01.controller.DepartmentController.<init>()");
        System.out.println("kreiran je konroller!");
        this.memberService = memberService;
        this.memberConverter=memberConverter;
        this.departmentConverter=departmentConverter;
        
    }

    //dodaj novi department
    @PostMapping
    public ResponseEntity<DepartmentDto> save(@Valid @RequestBody DepartmentDto departmentDto) throws Exception {
        //ResponseEntity
        
        DepartmentDto deptDto = departmentService.save(departmentDto);
        return new ResponseEntity<>(deptDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAll() {
        List<DepartmentDto> departments = departmentService.getAll();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/paging")
    public ResponseEntity<List<DepartmentDto>> getAllByPage(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "pageSize", defaultValue = "2") int pageSize,
            @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection) {
        
        Pageable pageable;
        if (sortDirection.equals("asc")) {
            pageable = PageRequest.of(page, pageSize, Sort.by(sortBy).ascending());
        } else {
            pageable = PageRequest.of(page, pageSize, Sort.by(sortBy).descending());
        }
        List<DepartmentDto> departments = departmentService.getAll(pageable);
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    //pronadji na osnovu ID/a
    //localhost:8080/department/1
    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long id) throws Exception {
        System.out.println("Controller: " + id);
        return departmentService.findById(id);
    }

    //pronadji na osnovu ID/a
    //localhost:8080/department/query?id=1
    @GetMapping("/query")
    public Department queryById(@RequestParam("id") Long id) throws Exception {
        //return departmentService.findById(id);
        throw new Exception("Nije implementirana.");
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        departmentService.delete(id);
        return new ResponseEntity<>("Department removed!", HttpStatus.OK);

    }
    
    
    @PutMapping("/{id}/update-manager")
    public ResponseEntity<DepartmentDto> updateDepartmentManager(@PathVariable Long id, 
            @RequestParam Long idmanager,
            @RequestParam(required = true) Boolean updateManagerHistory) throws Exception{
        
     
      Department m = departmentService.findById(id);
      
        if (Boolean.TRUE.equals(updateManagerHistory) && m.getManagerHistories()!=null){
         for (ManagerHistory managerHistory1 : m.getManagerHistories()) {
             if (managerHistory1.getEnd_date()==null){
                 managerHistory1.setEnd_date(LocalDate.now());
             }
         }
     }
         
        
       //ovaj deo se svakako desava, uneseni member postaje novi menadzer
       MemberDto ne= memberService.findById(idmanager);
       if (!m.getMembers().contains(memberConverter.toEntity(ne))){
         throw new Exception ("this member does not belong to the wanted department!");
     }
        m.setManager(memberConverter.toEntity(ne));
        //taj novi se svakako dodaje u istoriju 
        ManagerHistory newMh = new ManagerHistory(memberConverter.toEntity(ne), m, LocalDate.now(), null);
        m.getManagerHistories().add(newMh);
        
     
     DepartmentDto updated = departmentService.update(departmentConverter.toDto(m));
     return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    
     @PutMapping("/{id}/update-secretary")
    public ResponseEntity<DepartmentDto> updateDepartmentSecretary(@PathVariable Long id,
            @RequestParam Long idsecretary,
            @RequestParam (required=true) Boolean updateSecretaryHistory) throws Exception{
        
      //trazi se department sa kojim radimo
      Department m = departmentService.findById(id);
     
          if (Boolean.TRUE.equals(updateSecretaryHistory) && m.getSecretaryHistories()!=null){
         for (SecretaryHistory sh : m.getSecretaryHistories()) {
             if (sh.getEnd_date()==null){
                 sh.setEnd_date(LocalDate.now());
             }
         }
     }
       
        MemberDto sec= memberService.findById(idsecretary);
       if (!m.getMembers().contains(memberConverter.toEntity(sec))){
         throw new Exception ("this member does not belong to the wanted department!");
     }
        m.setSecretary(memberConverter.toEntity(sec));
        //taj novi se svakako dodaje u istoriju 
        SecretaryHistory secHis = new SecretaryHistory(memberConverter.toEntity(sec), m, LocalDate.now(), null);
        m.getSecretaryHistories().add(secHis);
        
       
     DepartmentDto updated = departmentService.update(departmentConverter.toDto(m));
         
     return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    
    
    @GetMapping("/{id}/members")
    public List<Member> getDepartmentMembers(@PathVariable Long id) throws Exception{
        Department dep= departmentService.findById(id);
        return dep.getMembers();
    }
    
    /*
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> handleException(Exception e){
        System.out.println("nst.springboot.restexample01.controller.DepartmentController.handleException()");
        System.out.println("-----------pozvana metoda za obradu izuzetka u kontroleru -------------");
        
        MyErrorDetails myErrorDetails = new MyErrorDetails(e.getMessage());
        
        return new ResponseEntity<>(myErrorDetails, HttpStatus.NOT_FOUND);

    }*/
    @ExceptionHandler(DepartmentAlreadyExistException.class)
    public ResponseEntity<MyErrorDetails> handleException(DepartmentAlreadyExistException e) {
        System.out.println("nst.springboot.restexample01.controller.DepartmentController.handleException()");
        System.out.println("-----------pozvana metoda za obradu izuzetka u kontroleru -------------");

        MyErrorDetails myErrorDetails = new MyErrorDetails(e.getMessage());

        return new ResponseEntity<>(myErrorDetails, HttpStatus.BAD_REQUEST);

    }
    @GetMapping("/{id}/managerHistory")
    public List<ManagerHistory> managerHistories (@PathVariable Long id) throws Exception{
        Department d = departmentService.findById(id);
       // Department department = departmentConverter.toEntity(d);
        return d.getManagerHistories();
    }
    @GetMapping("/{id}/secretaryHistory")
    public List<SecretaryHistory> secretaryHistories (@PathVariable Long id) throws Exception{
        Department d = departmentService.findById(id);
       // Department department = departmentConverter.toEntity(d);
        System.out.println("ono sto treba:"+d.getSecretaryHistories());
        return d.getSecretaryHistories();
    }
    
    @PutMapping("/{id}/add-secretary-history")
    public ResponseEntity<DepartmentDto> addSecretaryHistory (@PathVariable Long id,
            @RequestBody SecretaryHistory sh) throws Exception{
        if (sh.getEnd_date()==null || sh.getStart_date()==null){
            throw new Exception("Dates can not be null");
        }
        Department d = departmentService.findById(id);
        if (d.getSecretaryHistories()==null){
            d.setSecretaryHistories(new ArrayList<>());
        }
        sh.setDepartment_id(d);
        d.getSecretaryHistories().add(sh);
        DepartmentDto dupdated = departmentService.update(departmentConverter.toDto(d));
        return new ResponseEntity<>(dupdated, HttpStatus.OK);
    }
    
    @PutMapping("/{id}/add-manager-history")
    public ResponseEntity<DepartmentDto> addManagerHistory (@PathVariable Long id,
            @RequestBody ManagerHistory sh) throws Exception{
        if (sh.getEnd_date()==null || sh.getStart_date()==null){
            throw new Exception("Dates can not be null");
        }
        Department d = departmentService.findById(id);
        if (d.getManagerHistories()==null){
            d.setManagerHistories(new ArrayList<>());
        }
        sh.setDepartment_id(d);
        d.getManagerHistories().add(sh);
        DepartmentDto dupdated = departmentService.update(departmentConverter.toDto(d));
        return new ResponseEntity<>(dupdated, HttpStatus.OK);
    }
}
