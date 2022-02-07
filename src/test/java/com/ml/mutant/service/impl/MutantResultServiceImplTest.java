/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ml.mutant.service.impl;

import com.ml.mutant.model.Stat;
import com.ml.mutant.repository.MutantResultRepository;
import com.ml.mutant.service.MutantResultService;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;



/**
 *
 * @author lyepe
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MutantResultServiceImplTest {

    @MockBean
    private MutantResultRepository mutantResultRepository;

    @Autowired
    private MutantResultService resultService;

    @Test
    public void testGetStats() {

        Mockito.when(mutantResultRepository.countMutantDNA())
                .thenReturn(0L);
        Mockito.when(mutantResultRepository.countHumanDNA())
                .thenReturn(0L);

        Stat stats = resultService.getStats();

        assertThat(stats.getRatio())
                .isEqualTo(0);
    }
 
    @Test
    public void testGetStats04() {

        Mockito.when(mutantResultRepository.countMutantDNA())
                .thenReturn(40L);
        Mockito.when(mutantResultRepository.countHumanDNA())
                .thenReturn(100L);

        Stat stats = resultService.getStats();

        assertThat(stats.getRatio())
                .isEqualTo(0.4);
    }

}
