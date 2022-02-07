/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ml.mutant.service;

import com.ml.mutant.model.Stat;

/**
 *
 * @author lyepe
 */
public interface MutantResultService {

    public void saveResult(String[] dna, boolean result);
    
    public Stat getStats();

}
