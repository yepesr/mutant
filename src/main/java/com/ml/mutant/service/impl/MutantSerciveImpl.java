/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ml.mutant.service.impl;

import com.ml.mutant.model.Stat;
import com.ml.mutant.service.MutantResultService;
import com.ml.mutant.service.MutantService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author lyepe
 */
@Service
public class MutantSerciveImpl implements MutantService {

    List<String> DNA_MUTANT_SEQUENCE = Arrays.asList("AAAA", "TTTT", "CCCC", "GGGG");

    @Autowired
    private MutantResultService resultService;

    @Override
    @Cacheable("mutant")
    public boolean isMutant(String[] dna) {

        SequencesVerifier sequencesVerifier = new SequencesVerifier(dna, 2, DNA_MUTANT_SEQUENCE);

        boolean result = sequencesVerifier.verify();
        resultService.saveResult(dna, result);
        return result;
    }

    @Override
    public Stat getStats() {
        return resultService.getStats();
    }

}
