/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ml.mutant.service.impl;

import com.ml.mutant.ExecutorConfig;
import com.ml.mutant.model.MutantResultModel;
import com.ml.mutant.model.Stat;
import com.ml.mutant.repository.MutantResultRepository;
import com.ml.mutant.service.MutantResultService;
import java.util.concurrent.Executor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lyepe
 */
@Service
public class MutantResultServiceImpl implements MutantResultService {

    @Autowired
    private MutantResultRepository repository;

    @Autowired
    Executor executor;

    @Override
    public void saveResult(String[] dna, boolean result) {

        executor.execute(() -> {
            MutantResultModel mutanResultModel = new MutantResultModel();
            mutanResultModel.setDna(dna);
            mutanResultModel.setMutant(result);
            repository.save(mutanResultModel);
        });
    }

    @Override
    public Stat getStats() {
        Long countMutantDNA = repository.countMutantDNA();

        countMutantDNA = countMutantDNA == null ? 0 : countMutantDNA;

        Long countHumanDNA = repository.countHumanDNA();
        countHumanDNA = countHumanDNA == null ? 0 : countHumanDNA;

        double ratio;
        if (countMutantDNA == 0 && countHumanDNA == 0) {
            ratio = 0;
        } else {
            ratio = countHumanDNA == 0 ? 1 : (double) countMutantDNA / countHumanDNA;
        }

        Stat stat = new Stat();
        stat.setCount_human_dna(countHumanDNA);
        stat.setCount_mutant_dna(countMutantDNA);

        stat.setRatio(ratio);
        return stat;
    }
}
