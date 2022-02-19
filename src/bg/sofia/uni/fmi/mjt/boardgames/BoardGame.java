package bg.sofia.uni.fmi.mjt.boardgames;

import java.util.Arrays;
import java.util.Collection;

public record BoardGame(int id, String name, String description, int maxPlayers, int minAge, int minPlayers,
                        int playingTimeMins, Collection<String> categories, Collection<String> mechanics) {

    private static final String GAME_ATTRIBUTE_DELIMITER = ";";

    private static final int ID_SEQUENCE_NUMBER = 0;
    private static final int MAX_PLAYER_SEQUENCE_NUMBER = 1;
    private static final int MIN_AGE_SEQUENCE_NUMBER = 2;
    private static final int MIN_PLAYER_SEQUENCE_NUMBER = 3;
    private static final int NAME_SEQUENCE_NUMBER = 4;
    private static final int PLAYING_TIME_MINS_SEQUENCE_NUMBER = 5;
    private static final int CATEGORIES_SEQUENCE_NUMBER = 6;
    private static final int MECHANICS_SEQUENCE_NUMBER = 7;
    private static final int DESCRIPTION_SEQUENCE_NUMBER = 8;

    private static Collection<String> convertStringToCollectionsOfStrings(String line) {
        String[] tokens = line.split(",");
        return Arrays.asList(tokens.clone());
    }

    public static BoardGame of(String line) {
        final String[] tokens = line.split(GAME_ATTRIBUTE_DELIMITER);
        return new BoardGame(Integer.parseInt(tokens[ID_SEQUENCE_NUMBER]), tokens[NAME_SEQUENCE_NUMBER],
                tokens[DESCRIPTION_SEQUENCE_NUMBER], Integer.parseInt(tokens[MAX_PLAYER_SEQUENCE_NUMBER]),
                Integer.parseInt(tokens[MIN_AGE_SEQUENCE_NUMBER]),
                Integer.parseInt(tokens[MIN_PLAYER_SEQUENCE_NUMBER]),
                Integer.parseInt(tokens[PLAYING_TIME_MINS_SEQUENCE_NUMBER]),
                convertStringToCollectionsOfStrings(tokens[CATEGORIES_SEQUENCE_NUMBER]),
                convertStringToCollectionsOfStrings(tokens[MECHANICS_SEQUENCE_NUMBER])
        );
    }
}