/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.converter.impl;

import nst.springboot.restexample01.controller.domain.SecretaryHistory;
import nst.springboot.restexample01.converter.DtoEntityConverter;
import nst.springboot.restexample01.dto.SecretaryHistoryDto;
import org.springframework.stereotype.Component;

/**
 *
 * @author user
 */
@Component
public class SecretaryHistoryConverter implements DtoEntityConverter<SecretaryHistoryDto, SecretaryHistory>{

    @Override
    public SecretaryHistoryDto toDto(SecretaryHistory e) {
        return new SecretaryHistoryDto (e.getId(), e.getMember_id(), e.getDepartment_id(), e.getStart_date(), e.getEnd_date());
    }

    @Override
    public SecretaryHistory toEntity(SecretaryHistoryDto t) {
       return new SecretaryHistory(t.getId(), t.getMembed_id(), t.getDepartment_id(), t.getStart_date(), t.getEnd_date());
    }
    
}
