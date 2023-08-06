package be.zenoce.aoc.aoc2021;

import lombok.Value;

import java.util.List;

import static be.zenoce.aoc.aoc2021.Utils.parseLines;

public class Day2 {

    public static void main(String[] args) {
        puzzle1();
        puzzle2();
    }

    public static void puzzle1() {
        int x = 0;
        int y = 0;
        List<Move> moves = parseLines("day2.txt", Move::from);
        for (Move move : moves) {
            switch (move.getDirection()) {
                case "up":
                    y -= move.getDistance();
                    break;
                case "down":
                    y += move.getDistance();
                    break;
                case "forward":
                    x += move.getDistance();
                    break;
            }
        }
        System.out.println("x " + x + ", y " + y);
        System.out.println("Total: " + x * y);
    }

    public static void puzzle2() {
        int x = 0;
        int y = 0;
        int aim = 0;

        List<Move> moves = parseLines("day2.txt", Move::from);
        for (Move move : moves) {
            switch (move.getDirection()) {
                case "up":
                    aim -= move.getDistance();
                    break;
                case "down":
                    aim += move.getDistance();
                    break;
                case "forward":
                    x += move.getDistance();
                    y += move.getDistance() * aim;
                    break;
            }
        }
        System.out.println("x " + x + ", y " + y);
        System.out.println("Total: " + x * y);
    }

    @Value
    private static final class Move {
        private final String direction;
        private final int distance;

        public static Move from(String value) {
            int space = value.indexOf(' ');
            return new Move(value.substring(0, space).trim().toLowerCase(), Integer.parseInt(value.substring(space + 1)));
        }
    }

}
