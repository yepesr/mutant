/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ml.mutant.model;

/**
 *
 * @author lyepe
 */
public class MutantResquest {

    private String[] dna;

    public MutantResquest() {
    }

    public MutantResquest(String[] dna) {
        this.dna = dna;
    }
    
    

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

}
