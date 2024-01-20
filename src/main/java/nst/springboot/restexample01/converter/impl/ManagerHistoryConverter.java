/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.converter.impl;

import java.time.LocalDate;
import nst.springboot.restexample01.controller.domain.ManagerHistory;
import nst.springboot.restexample01.controller.service.DepartmentService;
import nst.springboot.restexample01.controller.service.MemberService;
import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.ManagerHistoryDto;
import org.springframework.stereotype.Component;

/**
 *
 * @author user
 */
@Component
public class ManagerHistoryConverter implements DtoEntityConverter<ManagerHistoryDto, ManagerHistory>{

    public ManagerHistoryConverter(nst.springboot.restexample01.converter.impl.MemberConverter MemberConverter, nst.springboot.restexample01.controller.service.MemberService memberService, nst.springboot.restexample01.controller.service.DepartmentService departmentService) {
        
    }


    @Override
    public ManagerHistoryDto toDto(ManagerHistory e) {
       return new ManagerHistoryDto (e.getId(), e.getMember_id().getId(),  e.getStart_date(), e.getEnd_date());
    }

    @Override
    public ManagerHistory toEntity(ManagerHistoryDto t) {
      ManagerHistory m= new ManagerHistory();
      m.setId(t.getId());
      return m;
    }

  
    
}
