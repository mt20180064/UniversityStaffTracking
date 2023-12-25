/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package nst.springboot.restexample01.controller.service;

import nst.springboot.restexample01.controller.domain.ManagerHistory;
import nst.springboot.restexample01.controller.repository.ManagerHistoryRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public interface ManagerHistoryService {
  ManagerHistory save (ManagerHistory managerHistory);
}
