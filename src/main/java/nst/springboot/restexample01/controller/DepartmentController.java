/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.controller;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import nst.springboot.restexample01.controller.domain.Department;
import nst.springboot.restexample01.controller.domain.ManagerHistory;
import nst.springboot.restexample01.controller.domain.Member;
import nst.springboot.restexample01.controller.domain.SecretaryHistory;
import nst.springboot.restexample01.controller.domain.Subject;
import nst.springboot.restexample01.controller.service.DepartmentService;
import nst.springboot.restexample01.controller.service.ManagerHistoryService;
import nst.springboot.restexample01.controller.service.MemberService;
import nst.springboot.restexample01.controller.service.SecretaryHistoryService;
import nst.springboot.restexample01.controller.service.SubjectService;
import nst.springboot.restexample01.converter.impl.DepartmentConverter;
import nst.springboot.restexample01.converter.impl.MemberConverter;
import nst.springboot.restexample01.dto.DepartmentDto;
import nst.springboot.restexample01.dto.ManagerHistoryDto;
import nst.springboot.restexample01.dto.MemberDto;
import nst.springboot.restexample01.exception.DepartmentAlreadyExistException;
import nst.springboot.restexample01.exception.MyErrorDetails;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
    private final ManagerHistoryService managerHistoryService;
    private final SecretaryHistoryService secretaryHistoryService;

    public DepartmentController(DepartmentService departmentService, nst.springboot.restexample01.controller.service.MemberService memberService, MemberConverter memberConverter, DepartmentConverter departmentConverter, ManagerHistoryService managerHistoryService, nst.springboot.restexample01.controller.service.SecretaryHistoryService secretaryHistoryService) {
        this.departmentService = departmentService;

        System.out.println("nst.springboot.restexample01.controller.DepartmentController.<init>()");
        System.out.println("kreiran je konroller!");
        this.memberService = memberService;
        this.memberConverter=memberConverter;
        this.departmentConverter=departmentConverter;
        this.managerHistoryService= managerHistoryService;
        this.secretaryHistoryService = secretaryHistoryService;
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
    public DepartmentDto findById(@PathVariable("id") Long id) throws Exception {
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

    //azuriraj
    //obrisi
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws Exception {
        /*
        try {
            departmentService.delete(id);
            return new ResponseEntity<>("Department removed!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(">>" + e.getMessage(), HttpStatus.NOT_FOUND);
        }*/
       
        
        
        
        
        departmentService.delete(id);
        return new ResponseEntity<>("Department removed!", HttpStatus.OK);

    }

    @PutMapping("/updateManager{id}")
    public ResponseEntity<DepartmentDto> updateManager(@PathVariable Long id, @RequestParam Long idman) throws Exception{
       DepartmentDto m = departmentService.findById(id);
       Member old = m.getManager_id();
     MemberDto ne= memberService.findById(idman);
     if (!m.getMembers().contains(memberConverter.toEntity(ne))){
         throw new Exception ("this member does not belong to the wanted department!");
     }
        System.out.println(ne.getFirstname());
     m.setManager_id(memberConverter.toEntity(ne));
        System.out.println(m.getManager_id().getFirstname());
        LocalDate ld;
        int duzinaliste = m.getManagerHistories().size();
        if (duzinaliste>0){
            ld = m.getManagerHistories().get(duzinaliste-1).getEnd_date();
        } else{
            ld = LocalDate.now();
        }
     DepartmentDto med = departmentService.update(m);
     ManagerHistory mhd = new ManagerHistory(200l, old, departmentConverter.toEntity(m), ld, LocalDate.now());
     if (mhd.getMember_id()!=null){
     ManagerHistory mh = managerHistoryService.save(mhd);}
        System.out.println("sacuvano i u istoriju");
     return new ResponseEntity<>(med, HttpStatus.OK);
    }
    @PutMapping("/updateSecretary{id}")
    public ResponseEntity<DepartmentDto> updateSecretary(@PathVariable Long id, @RequestParam Long idsec) throws Exception{
        DepartmentDto dep = departmentService.findById(id);
       Member old = dep.getSecretary_id();
        MemberDto sec= memberService.findById(idsec);
     if (!dep.getMembers().contains(memberConverter.toEntity(sec))){
       throw new Exception("Requested member does not belong to that department");
     }
         dep.setSecretary_id(memberConverter.toEntity(sec));
         DepartmentDto newdep = departmentService.update(dep);
          LocalDate ld;
        int duzinaliste = dep.getSecretaryHistories().size();
        if (duzinaliste>0){
            ld = dep.getSecretaryHistories().get(duzinaliste-1).getEnd_date();
        } else{
            ld = LocalDate.now();
        }
         SecretaryHistory sh = new SecretaryHistory(300l, old,departmentConverter.toEntity(dep), ld, LocalDate.now());
         if (sh.getMember_id()!=null){
         SecretaryHistory s = secretaryHistoryService.save(sh);}
         return new ResponseEntity<>(newdep, HttpStatus.OK);
     }
    
    @GetMapping("/members")
    public List<Member> getDepartmentMembers(@RequestParam Long depid) throws Exception{
        DepartmentDto dep= departmentService.findById(depid);
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
}
