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

    public SecretaryHistoryConverter(nst.springboot.restexample01.converter.impl.MemberConverter MemberConverter) {
        this.MemberConverter = MemberConverter;
    }
private final MemberConverter MemberConverter;
    @Override
    public SecretaryHistoryDto toDto(SecretaryHistory e) {
        return new SecretaryHistoryDto (e.getId(), e.getMember_id().getId(), e.getStart_date(), e.getEnd_date());
    }

    @Override
    public SecretaryHistory toEntity(SecretaryHistoryDto t) {
       SecretaryHistory s = new SecretaryHistory();
       s.setId(t.getId());
       return s;
    }

   
}
