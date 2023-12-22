/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nst.springboot.restexample01.controller.service.impl;


import java.util.Optional;
import nst.springboot.restexample01.controller.domain.AcademicTitle;
import nst.springboot.restexample01.controller.repository.AcademicTitleRepository;
import nst.springboot.restexample01.controller.service.AcademicTitleService;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class AcademicTitleServiceImpl implements AcademicTitleService {

    public AcademicTitleServiceImpl(nst.springboot.restexample01.controller.repository.AcademicTitleRepository academicTitleRepository) {
        this.academicTitleRepository = academicTitleRepository;
    }
private final AcademicTitleRepository academicTitleRepository;


    @Override
    public AcademicTitle findById(Long id) throws Exception {
        Optional<AcademicTitle> ac = academicTitleRepository.findById(id);
        if (ac.isPresent()){
            AcademicTitle academicTitle = ac.get();
            return academicTitle;
        } else throw new Exception ("That acaddemic title does not exist");
    }
    
}
