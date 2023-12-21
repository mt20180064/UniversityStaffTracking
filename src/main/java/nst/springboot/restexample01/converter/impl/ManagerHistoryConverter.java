/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.converter.impl;

import java.time.LocalDate;
import nst.springboot.restexample01.controller.domain.ManagerHistory;
import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.ManagerHistoryDto;
import org.springframework.stereotype.Component;

/**
 *
 * @author user
 */
@Component
public class ManagerHistoryConverter implements DtoEntityConverter<ManagerHistoryDto, ManagerHistory>{

    @Override
    public ManagerHistoryDto toDto(ManagerHistory e) {
       return new ManagerHistoryDto (e.getId(), e.getMember_id(), e.getDepartment_id(), e.getStart_date(), e.getEnd_date());
    }

    @Override
    public ManagerHistory toEntity(ManagerHistoryDto t) {
        return new ManagerHistory(t.getId(), t.getMembed_id(), t.getDepartment_id(), t.getStart_date(), t.getEnd_date());
    }
    
}
