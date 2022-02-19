package bg.sofia.uni.fmi.mjt.boardgames.analyzer;

import bg.sofia.uni.fmi.mjt.boardgames.BoardGame;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BoardGamesStatisticsAnalyzer implements StatisticsAnalyzer {
    private final Collection<BoardGame> boardGameCollection;

    public BoardGamesStatisticsAnalyzer(Collection<BoardGame> games) {
        this.boardGameCollection = games;
    }

    private double getAveragePlayingTimeByCategoryWithDifferentName(String category) {
        return this.getAveragePlayingTimeByCategory(category);
    }

    @Override
    public List<String> getNMostPopularCategories(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("In getNMostPopularCategories the value " +
                    "of argument n cannot be a negative number!");
        }
        Map<String, Integer> wc = boardGameCollection.stream()
                .map(BoardGame::categories)
                .flatMap(Collection::stream)
                .filter(s -> s.length() >= 2)
                .map(s -> s.toLowerCase(Locale.ROOT))
                .collect(Collectors.groupingBy(w -> w, Collectors.summingInt(w -> 1)));

        return wc.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(n)
                .map(Map.Entry::getKey)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public double getAverageMinAge() {
        if (boardGameCollection.size() == 0) {
            return 0.0;
        }

        Integer sumOfAllMinAges = boardGameCollection
                .stream()
                .map(BoardGame::minAge)
                .reduce(0, Integer::sum);

        return sumOfAllMinAges.doubleValue() / boardGameCollection.size();
    }

    @Override
    public double getAveragePlayingTimeByCategory(String category) {
        if (category == null || category.equals("")) {
            throw new IllegalArgumentException("The value of the category argument in method" +
                    "getAveragePlayingTimeByCategory cannot be null or empty String");
        }

        if (boardGameCollection.size() == 0) {
            return 0.0;
        }

        List<Integer> listOfPlayingTimeForEachGameForThisCategory = boardGameCollection
                .stream()
                .filter(game -> game.categories()
                        .stream()
                        .filter(s -> s.length() >= 2)
                        .map(s -> s.toLowerCase(Locale.ROOT))
                        .collect(Collectors.toList())
                        .contains(category))
                .map(BoardGame::playingTimeMins)
                .collect(Collectors.toList());

        if (listOfPlayingTimeForEachGameForThisCategory.size() == 0) {
            return 0.0;
        }

        Integer sumOfPlayingTimeForEachGameForThisCategory = listOfPlayingTimeForEachGameForThisCategory
                .stream()
                .reduce(0, Integer::sum);

        return sumOfPlayingTimeForEachGameForThisCategory.doubleValue() /
                listOfPlayingTimeForEachGameForThisCategory.size();
    }

    @Override
    public Map<String, Double> getAveragePlayingTimeByCategory() {
        return boardGameCollection
                .stream()
                .map(BoardGame::categories)
                .flatMap(Collection::stream)
                .map(s -> s.toLowerCase(Locale.ROOT))
                .collect(Collectors.toMap(Function.identity(),
                        this::getAveragePlayingTimeByCategoryWithDifferentName, (a, b) -> b));
    }
}
