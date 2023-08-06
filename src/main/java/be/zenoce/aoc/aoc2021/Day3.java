package be.zenoce.aoc.aoc2021;

import java.util.BitSet;
import java.util.List;

import static be.zenoce.aoc.aoc2021.Utils.parseLines;

public class Day3 {

    public static void main(String[] args) {
        puzzle1();
        puzzle2();
    }

    public static void puzzle1() {

        int[] gammaRateCount = new int[12];

        parseLines("day3.txt", line -> {
            String[] code = line.split("");
            for (int i = 0; i < code.length; i++) {
                String bit = code[i];
                if (bit.equals("1")) {
                    gammaRateCount[i]++;
                } else if (bit.equals("0")) {
                    gammaRateCount[i]--;
                }
            }
            return code;
        });

        BitSet gammaBits = new BitSet(12);
        for (int i = 0; i < gammaRateCount.length; i++) {
            if (gammaRateCount[i] > 0) {
                gammaBits.set(i);
            }
        }
        long gammaRate = gammaBits.toLongArray()[0];
        gammaBits.flip(0, 12);
        long epsilonRate = gammaBits.toLongArray()[0];
        System.out.println(gammaRate);
        System.out.println(epsilonRate);
        System.out.println(epsilonRate * gammaRate);
    }

    public static void puzzle2() {

    }
}
