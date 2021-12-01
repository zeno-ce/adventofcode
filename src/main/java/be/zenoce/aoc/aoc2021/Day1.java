package be.zenoce.aoc.aoc2021;

import java.util.List;

import static be.zenoce.aoc.aoc2021.Utils.parseLines;

public final class Day1 {

    public static void main(String[] args) {
        List<Integer> depths = parseLines("day1.txt", Integer::parseInt);
        System.out.println("Puzzle 1 " + puzzle1(depths));
        System.out.println("Puzzle 2 " + puzzle2(depths));
    }

    public static int puzzle1(List<Integer> input) {
        int lastDepth = -1;
        int increased = 0;
        for (int depth : input) {
            if (lastDepth == -1) {
                lastDepth = depth;
            }
            if (depth > lastDepth) {
                increased++;
            }
            lastDepth = depth;
        }
        return increased;
    }

    public static int puzzle2(List<Integer> input) {
        int incremented = 0;
        for (int i = 0; i < input.size() - 3; i++) {
            if (input.get(i + 3) > input.get(i)) {
                incremented++;
            }
        }
        return incremented;
    }
}
