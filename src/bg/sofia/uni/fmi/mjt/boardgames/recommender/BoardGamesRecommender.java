package bg.sofia.uni.fmi.mjt.boardgames.recommender;

import bg.sofia.uni.fmi.mjt.boardgames.BoardGame;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


///Наистина не помня вече, къде съм взимай напредвид capitalisation-a и къде не
public class BoardGamesRecommender implements Recommender {

    private static final String BOARD_GAME_DESCRIPTION_DELIMITER = "[\\p{IsPunctuation}\\p{IsWhite_Space}]+";
    private Set<BoardGame> boardGameCollection;
    private Set<String> stopWordsCollection;
    private Map<String, Set<Integer>> index;

    /**
     * Constructs an instance using the provided file names.
     *
     * @param datasetZipFile  ZIP file containing the board games dataset file
     * @param datasetFileName the name of the dataset file (inside the ZIP archive)
     * @param stopwordsFile   the stopwords file
     */
    public BoardGamesRecommender(Path datasetZipFile, String datasetFileName, Path stopwordsFile) {
        ZipFile zipFile;
        InputStream stream;
        try {
            zipFile = new ZipFile(String.valueOf(datasetZipFile));
            ZipEntry entry = zipFile.getEntry(datasetFileName);
            stream = zipFile.getInputStream(entry);
        } catch (IOException e) {
            throw new IllegalStateException("A problem occurred while opening the zip file");
        }


        try (var reader = new BufferedReader(new InputStreamReader(stream));
             var stopWordsReader = Files.newBufferedReader(stopwordsFile)) {
            reader.readLine();
            this.boardGameCollection = reader.lines().map(BoardGame::of).collect(Collectors.toSet());
            this.stopWordsCollection = stopWordsReader.lines().collect(Collectors.toSet());
        } catch (IOException e) {
            throw new IllegalStateException("A problem occurred while reading from the file");
        }

        index = this.boardGameCollection
                .stream()
                .map(game -> Arrays.stream(game.description().split(BOARD_GAME_DESCRIPTION_DELIMITER))
                        .filter((word -> !stopWordsCollection.contains(word)))
                        .collect(Collectors.toMap(Function.identity(), a -> Set.of(game.id()),
                                BoardGamesRecommender::setUnion)))
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        BoardGamesRecommender::setUnion));
    }


    /**
     * Constructs an instance using the provided Reader streams.
     *
     * @param dataset   Reader from which the dataset can be read
     * @param stopwords Reader from which the stopwords list can be read
     */
    public BoardGamesRecommender(Reader dataset, Reader stopwords) {
        if (dataset == null || stopwords == null) {
            throw new IllegalArgumentException("The value of dataset or stopwords cannot be null");
        }

        this.boardGameCollection = new HashSet<>();
        this.stopWordsCollection = new HashSet<>();

        try (var reader = new BufferedReader(dataset);
             var stopWordsReader = new BufferedReader(stopwords)) {

            this.boardGameCollection = reader.lines().map(BoardGame::of).collect(Collectors.toSet());
            this.stopWordsCollection = stopWordsReader.lines().collect(Collectors.toSet());
            index = this.boardGameCollection
                    .stream()
                    .map(game -> Arrays.stream(game.description().split(BOARD_GAME_DESCRIPTION_DELIMITER))
                            .filter((word -> !stopWordsCollection.contains(word)))
                            .collect(Collectors.toMap(Function.identity(), a -> Set.of(game.id()),
                                    BoardGamesRecommender::setUnion)))
                    .flatMap(map -> map.entrySet().stream())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            BoardGamesRecommender::setUnion));

        } catch (IOException e) {
            throw new IllegalStateException("A problem occurred while reading from the file");
        }
    }

    private static Set<Integer> setUnion(Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> union = new HashSet<>();
        union.addAll(setA);
        union.addAll(setB);
        return union;
    }

    //да сменя името на тази функция:
    private Map<BoardGame, Integer> findGame(Set<Integer> ids) {
        return boardGameCollection
                .stream()
                .filter(game -> ids.contains(game.id()))
                .collect(Collectors.toMap(Function.identity(), a -> 1, (a, b) -> a));
    }

    private String writeIndexLine(Map.Entry<String, Set<Integer>> indexElement) {
        StringBuilder line = new StringBuilder(indexElement.getKey());
        line.append(": ");

        int counterSteps = indexElement.getValue().size();

        for (Integer ids : indexElement.getValue()) {
            line.append(ids);
            if (counterSteps > 1) {
                line.append(", ");
            }
            counterSteps--;
        }

        return String.valueOf(line);
    }

    private Double distanceBetweenGames(BoardGame game, BoardGame boardGame) {
        if (game.equals(boardGame)) {
            return 0.0;
        }

        double numericalDistance = Math.sqrt(
                Math.pow((game.playingTimeMins() - boardGame.playingTimeMins()), 2) +
                        Math.pow((game.maxPlayers() - boardGame.maxPlayers()), 2) +
                        Math.pow((game.minPlayers() - boardGame.minPlayers()), 2) +
                        Math.pow((game.minAge() - boardGame.minAge()), 2));

        long typedAttributesDistanceMechanicIntersection = game.mechanics()
                .stream()
                .filter(mechanic -> boardGame.mechanics().contains(mechanic))
                .count();
        long typedAttributesDistanceCategoriesIntersection = game.categories()
                .stream()
                .filter(categorie -> boardGame.categories().contains(categorie))
                .count();

        if (typedAttributesDistanceCategoriesIntersection == 0) {
            return 0.0;
        }

        long typedAttributesDistanceCategoriesUnion = game.categories().size() +
                boardGame.categories().size();
        long typedAttributesDistanceMechanicUnion = game.mechanics().size() +
                boardGame.mechanics().size();

        long typedAttributesDistanceMechanic = typedAttributesDistanceMechanicUnion -
                typedAttributesDistanceMechanicIntersection;

        long typedAttributesDistanceCategory = typedAttributesDistanceCategoriesUnion -
                typedAttributesDistanceCategoriesIntersection;

        return numericalDistance + typedAttributesDistanceMechanic + typedAttributesDistanceCategory;
    }

    @Override
    public Collection<BoardGame> getGames() {
        return Collections.unmodifiableSet(this.boardGameCollection);
    }

    @Override
    public List<BoardGame> getSimilarTo(BoardGame game, int n) {
        if (game == null || n < 0) {
            throw new IllegalArgumentException("In method getSimilarTo, in class BoardGameRecommender neither the " +
                    "value of game can be null, nor the value of n can be negative!");
        }

        return boardGameCollection
                .stream()
                .map(boardGame -> Map.of(boardGame,
                        distanceBetweenGames(game, boardGame)))
                .flatMap(map -> map.entrySet().stream())
                .filter(boardGame -> boardGame.getValue() > 0.0)
                .sorted((boardGame1, boardGame2) -> (int) (boardGame1.getValue() - boardGame2.getValue()))
                .map(Map.Entry::getKey)
                .limit(n)
                .collect(Collectors.toList());
    }

    @Override
    public List<BoardGame> getByDescription(String... keywords) {
        if (keywords == null) {
            throw new IllegalArgumentException("The value of the varargs keywords connot be null");
        }
        Map<BoardGame, Integer> boardGamesMatchMap;
        boardGamesMatchMap = index.entrySet()
                .stream()
                .filter(a -> List.of(keywords).contains(a.getKey()))
                .map(indexWord -> findGame(indexWord.getValue()))
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        Integer::sum));

        return boardGamesMatchMap.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public void storeGamesIndex(Writer writer) {
        if (writer == null) {
            throw new IllegalArgumentException("The value of argument writer in method" +
                    "storeGamesIndex cannot be null");
        }

        try {
            for (Map.Entry<String, Set<Integer>> indexElement : index.entrySet()) {
                writer.append(writeIndexLine(indexElement));
                writer.append(System.lineSeparator());
            }
            writer.flush();
        } catch (IOException e) {
            throw new IllegalStateException("Something went wrong while writing " +
                    "text to writer in method storeGamesIndex.", e);
        }
    }
}
