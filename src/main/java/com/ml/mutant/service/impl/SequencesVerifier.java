/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ml.mutant.service.impl;

import java.util.List;

/**
 *
 * @author lyepe
 */
public class SequencesVerifier {

    private final String[] dna;
    private final int occurrences;
    private final List<String> sequences;
    private int found;

    public SequencesVerifier(String[] dna, int occurrences, List<String> sequences) {
        this.dna = dna;
        this.occurrences = occurrences;
        this.sequences = sequences;
    }

    public boolean verify() {

        findHorizontalSequence();
        if (isMutant()) {
            return true;
        }
        findVerticalSequence();
        if (isMutant()) {
            return true;
        }

        rightDiagonal();
        if (isMutant()) {
            return true;
        }
        leftDiagonal();

        return isMutant();
    }

    private boolean isMutant() {
        return found >= occurrences;
    }

    public void countOccurrence(String value, String toFind) {
        int lastIndex = 0;
        while (lastIndex != -1) {
            lastIndex = value.indexOf(toFind, lastIndex);
            if (lastIndex != -1) {
                found++;
                if (isMutant()) {
                    return;
                }
                lastIndex += toFind.length();
            }
        }
    }

    public void findHorizontalSequence() {
        for (String value : dna) {
            for (String cadena : sequences) {
                countOccurrence(value, cadena);
                if (isMutant()) {
                    return;
                }
            }
        }
    }

    public void findVerticalSequence() {
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < dna.length; j++) {
            for (String dna1 : dna) {
                sb.append(dna1.substring(j, j + 1));
            }
            String value = sb.toString();
            for (String cadena : sequences) {

                countOccurrence(value, cadena);
                if (isMutant()) {
                    return;
                }

            }

            sb = new StringBuilder();
        }
    }

    public String diagonal(int x, int y, int factor) {
        if (x + 1 > dna[0].length() || y + factor > dna[0].length() || x + 1 < -1 || y + factor < -1) {
            return "";
        } else {
            String substring = dna[y].substring(x, x + 1);
            x += 1;
            y += factor;
            return substring.concat(diagonal(x, y, factor));
        }

    }

    private void rightDiagonal() {
        String value;
        int limit = dna.length - 3;
        int limit2 = dna.length - 4;
        for (int i = 0; i < limit; i++) {
            value = diagonal(i, 0, 1);
            for (String cadena : sequences) {
                countOccurrence(value, cadena);
                if (isMutant()) {
                    return;
                }

            }
        }
        for (int i = 0; i < limit2; i++) {
            value = diagonal(0, i + 1, 1);
            for (String cadena : sequences) {
                countOccurrence(value, cadena);
                if (isMutant()) {
                    return;
                }
            }
        }
    }

    private void leftDiagonal() {
        String value;
        int limit = dna.length - 3;
        int limit2 = dna.length - 4;
        int factor = -1;
        int i = dna.length - 1;
        int count = 0;
        do {
            value = diagonal(0, i, factor);
            for (String cadena : sequences) {
                countOccurrence(value, cadena);
                if (isMutant()) {
                    return;
                }
            }
            i = i + factor;
            count++;
        } while (count < limit);
        count = 0;
        do {
            value = diagonal(count + 1, dna.length - 1, factor);
            for (String cadena : sequences) {
                countOccurrence(value, cadena);
                if (isMutant()) {
                    return;
                }
            }
            i = i + factor;
            count++;
        } while (count < limit2);
    }

}
