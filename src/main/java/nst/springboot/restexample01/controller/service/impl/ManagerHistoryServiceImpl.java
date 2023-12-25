/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.controller.service.impl;

import nst.springboot.restexample01.controller.domain.ManagerHistory;
import nst.springboot.restexample01.controller.repository.ManagerHistoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Service
public class ManagerHistoryServiceImpl implements nst.springboot.restexample01.controller.service.ManagerHistoryService{

    public ManagerHistoryServiceImpl(ManagerHistoryRepository managerHistoryRepository) {
        this.managerHistoryRepository = managerHistoryRepository;
    }
     private final ManagerHistoryRepository managerHistoryRepository;

    @Override
    @Transactional
    public ManagerHistory save(ManagerHistory managerHistory) {
        return managerHistoryRepository.save(managerHistory);
    }
}
