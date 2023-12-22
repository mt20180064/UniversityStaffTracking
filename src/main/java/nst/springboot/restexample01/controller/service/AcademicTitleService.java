/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package nst.springboot.restexample01.controller.service;

import nst.springboot.restexample01.controller.domain.AcademicTitle;

/**
 *
 * @author user
 */
public interface AcademicTitleService {
  AcademicTitle findById(Long id) throws Exception;  
}
