/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.controller.service.impl;

import nst.springboot.restexample01.controller.domain.SecretaryHistory;
import nst.springboot.restexample01.controller.repository.SecretaryHistoryRepository;
import nst.springboot.restexample01.controller.service.SecretaryHistoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Service
public class SecretaryHistoryServiceImpl implements SecretaryHistoryService{

    public SecretaryHistoryServiceImpl(nst.springboot.restexample01.controller.repository.SecretaryHistoryRepository secretaryHistoryRepository) {
        this.secretaryHistoryRepository = secretaryHistoryRepository;
    }
    private final SecretaryHistoryRepository secretaryHistoryRepository;

    @Override
    @Transactional
    public SecretaryHistory save(SecretaryHistory secretaryHistory) {
       return secretaryHistoryRepository.save (secretaryHistory);
    }
}
