/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ml.mutant.repository;

import com.ml.mutant.model.MutantResultModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author lyepe
 */
public interface MutantResultRepository extends MongoRepository<MutantResultModel, String> {

    @Query(value = "{mutant:true}", count = true)
    public Long countMutantDNA();

    @Query(value = "{mutant:false}", count = true)
    public Long countHumanDNA();
}
