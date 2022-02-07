package com.ml.mutant;

import com.ml.mutant.model.MutantResquest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class MutantApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void horizontalSequenceOK() throws Exception {
        String[] entry = {
            "TCCTCTT",
            "TCTACAA",
            "ACCTTTA",
            "CAACTCA",
            "CACCCCC",
            "ACACAAC",
            "TAAAATC"};
        request(entry, status().isOk());
    }

    @Test
    public void verticalSequenceOK() throws Exception {
        String[] entry = {
            "TCCTCTT",
            "TCTACAA",
            "ACCTTTA",
            "CAACTCA",
            "CACCTCC",
            "ACACTAC",
            "TAACATC"};
        request(entry, status().isOk());
    }

    @Test
    public void diagonalSequenceOK() throws Exception {
        String[] entry = {
            "TCCTCTT",
            "TCTACAA",
            "ACCTTTA",
            "CAACCCA",
            "CCTCCTC",
            "ACCATCC",
            "TAACATC"};
        request(entry, status().isOk());
    }

    @Test
    public void horizontalAndVerticalSequenceOK() throws Exception {
        String[] entry = {
            "TCCTCTT",
            "TCTATAA",
            "ACCTTTA",
            "CAACTCA",
            "CACCTCC",
            "ACACAAC",
            "TAAAATC"};
        request(entry, status().isOk());
    }

    @Test
    public void verticalAndDiagonalSequenceOK() throws Exception {
        String[] entry = {
            "TCCTCTT",
            "TCTACAA",
            "ACCTTTA",
            "CATATCA",
            "CACTTCC",
            "ACACTAC",
            "TAACATC"};
        request(entry, status().isOk());
    }
 
    @Test
    public void oblicuaSequenceOK() throws Exception {
        String[] entry = {
            "TACTCTT",
            "TCTCCTA",
            "ACCTTTA",
            "CCTTTCA",
            "CACTTCC",
            "ACACAAC",
            "TAACACC"};
        request(entry, status().isOk());
    }
   
    @Test
    public void HumanSequence() throws Exception {
        String[] entry = {
            "ACCTCTT",
            "TCTACAA",
            "ACCTTTA",
            "CAAATCA",
            "CACTACC",
            "ACACTAC",
            "TAACATC"};
        request(entry, status().is4xxClientError());
    }

    @Test
    public void test() throws Exception {

        String[] entry0 = {"YZZYX", "YYXYZ", "XXZYX", "ZXYYZ", "ZXYYX"};
        request(entry0, status().is4xxClientError());

        String[] entry = {"YXYZYYYXYZZ", "YYZYZYZXZXY", "YYZYXZXXZXX", "YYZXZYYZZZY", "ZXZYXXZZYZX", "XYXYZXYZZYX", "XYYZYXXXZZY", "XYXYXYZYXXY", "ZXXZZXXXXXZ", "ZZYYYZYYZXX", "YXYZYYXYYZZ"};
        request(entry, status().is4xxClientError());
        request(entry, status().is4xxClientError());
        request(entry, status().is4xxClientError());
        request(entry, status().is4xxClientError());

        String[] entry2 = {"YXZXYYYXZZZYXZY", "ZZYZZXYXZZXXZYY", "XXZXZZYXZYXYXZY", "ZXYZYZZZZYYYYXY", "XYYZZYZYXXXZYXY", "ZZXXZXXXZXXZXXZ", "YZZXZYXXZYXZXZY", "XYZXXZYZZXZXZYZ", "ZYZZXYXXZYXYZZX", "ZXZXZXXYZYZZYYX", "XYZXXXYYZZZZXYX", "ZZXYXXXZZZXYXXX", "YXZXYZXYXXZYYZZ", "ZYYYXXZYXYXXXYX", "YZXZYXXYZYZYZXY"};
        request(entry2, status().is4xxClientError());
        request(entry2, status().is4xxClientError());
        request(entry2, status().is4xxClientError());
        request(entry2, status().is4xxClientError());

        String[] entry3 = {"ZYXZXZYZZYYYZZXXZXXZYX", "XZZYXXXZYZYXXZZYZZXZYY", "XXYYZXZXXZZZZXXZZZZXXZ", "YXZXZZXZZYXYXZXYXXYYYX", "XYXYYZZYZZXXZYXYYXYXZX", "YXXYZZXYZYZZYZYZXYYYZY", "ZZYYYYYXYXYYYYYXZZXYYZ", "XZXXZZZZYYXXZZZYYXXYXX", "YYXYZXZYYZYYYXYYYYYXXY", "YXZZYZZZZZYZYYZYXYYYZY", "ZYYYZXYZXXXXZZYZXYXZXZ", "ZYXYZYXYZXYYZXZYZYXXYZ", "YXZXZZYYZXYXXYYYYYZYZY", "YXYZYYXYXZXXYYXXXYZYYY", "ZXYZYZXZZZYYXXYXZYXXZY", "ZYZYXXYYYXYXZYYYYZYYYX", "YYXZXYYZZZYYYXZXXZZXXY", "XXYZZXXXXZZZZYYZXYYXYX", "ZYYZYZYZXZZZXYYYXZZXXX", "ZXYZYXXYYZZXXZYXYZYZYX", "YYYXYZXYZXXYYXXXYZXYYX", "XZYZYYYZZZXZZYYYZXZXYX"};
        request(entry3, status().is4xxClientError());
        request(entry3, status().is4xxClientError());
        request(entry3, status().is4xxClientError());
        request(entry3, status().is4xxClientError());
    }

    @Test
    public void test2() throws Exception {

        String[] entry = {"TCCTCTT", "TCTACAA", "ACCTTTA", "CAACTCA", "CACCTCA", "ACACTAC", "TAAAATC"};
        request(entry, status().isOk());

        request(entry, status().isOk());
        request(entry, status().isOk());
        request(entry, status().isOk());
        request(entry, status().isOk());
    }

    private void request(String[] entry, ResultMatcher expect) throws Exception {

        mvc.perform(
                MockMvcRequestBuilders.post("/mutant/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new MutantResquest(entry))))
                .andExpect(expect);

    }

}
