package be.zenoce.aoc.aoc2021;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Utils {

    @SneakyThrows
    public static List<String> readLines(String file) {
        return Files.readAllLines(Path.of("src/main/resources/" + file));
        }

    public static <T> List<T> parseLines(String file, Function<String, ? extends T> mapper) {
        return readLines(file)
                .stream()
                .map(mapper)
                .collect(Collectors.toList());

    }

}
