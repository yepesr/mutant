/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ml.mutant.Controller;

import com.ml.mutant.model.MutantResquest;
import com.ml.mutant.model.Stat;
import com.ml.mutant.service.MutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lyepe
 */
@RestController
public class MutantController {
    
    @Autowired
    MutantService mutantService;

    @PostMapping(value = "/mutant/" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> IsAMutant(@RequestBody MutantResquest mutantResquest) {
       
        if(mutantService.isMutant(mutantResquest.getDna())){
            return new ResponseEntity<>("",HttpStatus.OK);
        }
        return new ResponseEntity<>("", HttpStatus.FORBIDDEN);
    }
    
    @GetMapping(value = "/stats/" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Stat> stats() {
       
        return new ResponseEntity<>(mutantService.getStats(),HttpStatus.OK);
    }
}
