package bg.sofia.uni.fmi.mjt.boardgames.recommender;

import bg.sofia.uni.fmi.mjt.boardgames.BoardGame;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardGamesRecommenderTest {

    private static final String line = "1;5;14;3;Die Macher;240;Economic,Negotiation,Political;Area Control / Area Influence,Auction/Bidding,Dice Rolling,Hand Management,Simultaneous Action Selection;Die Macher is a game about seven sequential political races in different regions of Germany. Players are in charge of national political parties, and must manage limited resources to help their party to victory. The winning party will have the most victory points after all the regional elections. There are four different ways of scoring victory points. First, each regional election can supply one to eighty victory points, depending on the size of the region and how well your party does in it. Second, if a party wins a regional election and has some media influence in the region, then the party will receive some media-control victory points. Third, each party has a national party membership which will grow as the game progresses and this will supply a fair number of victory points. Lastly, parties score some victory points if their party platform matches the national opinions at the end of the game...The 1986 edition featured 4 parties from the old West Germany and supported 3-4 players. The 1997 edition supports up to 5 players in the re-united Germany and updated several features of the rules as well.  The 2006 edition also supports up to 5 players and adds a shorter 5 round variant and additional rules updates by the original designer...Die Macher1 is #1 in the Valley Games Classic Line..";
    private static final String line1 = "2;4;12;3;Dragonmaster;30;Card Game,Fantasy;Trick-taking;Dragonmaster is a trick-taking card game based on an older game called Coup detat. Each player is given a supply of plastic gems, which represent points. Each player will get to be the dealer for five different hands, with slightly different goals for each hand. After all cards have been dealt out, the dealer decides which hand best suits his or her current cards, and the other players are penalized points (in the form of crystals) for taking certain tricks or cards. For instance, if &quot first&quot  or &quot last&quot  is called, then a player is penalized for taking the first or last tricks. All players will get a chance to be dealer for five hands, but other players can steal this opportunity by taking all of the tricks during certain hands. At the end, the biggest pile of gems wins the game...Jewel contents:..11 clear (3 extra).13 green (1 extra).22 red (2 extra).22 blue (2 extra).. ";
    private static final String line2 = "3;4;10;2;Samurai;60;Abstract Strategy,Medieval;Area Control / Area Influence,Hand Management,Set Collection,Tile Placement;Part of the Knizia tile-laying trilogy, Samurai is set in medieval Japan. Players compete to gain the favor of three factions: samurai, peasants, and priests, which are represented by helmet, rice paddy, and Buddha tokens scattered about the board, which features the islands of Japan. The competition is waged through the use of hexagonal tiles, each of which help curry favor of one of the three factions &mdash  or all three at once! Players can make lightning-quick strikes with horseback ronin and ships or approach their conquests more methodically. As each token (helmets, rice paddies, and Buddhas) is surrounded, it is awarded to the player who has gained the most favor with the corresponding group...Gameplay continues until all the symbols of one type have been removed from the board or four tokens have been removed from play due to a tie for influence...At the end of the game, players compare captured symbols of each type, competing for majorities in each of the three types. Ties are not uncommon and are broken based on the number of other, &quot non-majority&quot  symbols each player has collected...";
    private static final String line3 = "4;4;12;2;Tal der Könige;60;Ancient;Action Point Allowance System,Area Control / Area Influence,Auction/Bidding,Set Collection;When you see the triangular box and the luxurious, large blocks, you can tell this game was designed to be beautiful as well as functional.  The object of the game is to build pyramids out of the different colored blocks.  A pyramid scores more points when it's made from a few colors, but it's much harder to consistently outbid the other players for the necessary blocks.  The game is over when the Pharoah's Pyramid in the center is completed, which is built using all the blocks that the players don't use during the course of the game...Final round 1990 Hippodice Spieleautorenwettbewerb...";
    private static final String line4 = "5;2;8;2;Cathedral;20;Abstract Strategy;Area Enclosure,Pattern Building,Pattern Recognition,Tile Placement;In the game Cathedral, each player has a set of pieces of a different color. The pieces are in the shapes of buildings, covering from one to five square units. The first player takes the single neutral Cathedral piece and places it onto the board. Players then alternate placing one of their buildings onto the board until neither player can place another building. Players capture territory by surrounding areas that are occupied by at most one opponent or neutral building. A captured piece is removed and captured territory becomes off-limits to the opponent. The player with the fewest 'square units' of buildings that can't be placed wins...";
    private static final String line5 = "6;4;10;3;Catan;120;Negotiation;Dice Rolling,Hand Management,Modular Board,Route/Network Building,Trading;In Catan (formerly The Settlers of Catan), players try to be the dominant force on the island of Catan by building settlements, cities, and roads. On each turn dice are rolled to determine what resources the island produces. Players collect these resources (cards)&mdash wood, grain, brick, sheep, or stone&mdash to build up their civilizations to get to 10 victory points and win the game...Setup includes randomly placing large hexagonal tiles (each showing a resource or the desert) in a honeycomb shape and surrounding them with water tiles, some of which contain ports of exchange. Number disks, which will correspond to die rolls (two 6-sided dice are used), are placed on each resource tile. Each player is given two settlements (think: houses) and roads (sticks) which are, in turn, placed on intersections and borders of the resource tiles. Players collect a hand of resource cards based on which hex tiles their last-placed house is adjacent to. A robber pawn is placed on the desert tile...A turn consists of possibly playing a development card, rolling the dice, everyone (perhaps) collecting resource cards based on the roll and position of houses (or upgraded cities&mdash think: hotels) unless a 7 is rolled, turning in resource cards (if possible and desired) for improvements, trading cards at a port, and trading resource cards with other players. If a 7 is rolled, the active player moves the robber to a new hex tile and steals resource cards from other players who have built structures adjacent to that tile...Points are accumulated by building settlements and cities, having the longest road and the largest army (from some of the development cards), and gathering certain development cards that simply award victory points. When a player has gathered 10 points (some of which may be held in secret), he announces his total and claims the win...Catan has won multiple awards and is one of the most popular games in recent history due to its amazing ability to appeal to experienced gamers as well as those new to the hobby...Die Siedler von Catan was originally published by KOSMOS and has gone through multiple editions. It was licensed by Mayfair and has undergone four editions as The Settlers of Catan. In 2015, it was formally renamed Catan to better represent itself as the core and base game of the Catan series. It has been re-published in two travel editions, portable edition and compact edition, as a special gallery edition (replaced in 2009 with a family edition), as an anniversary wooden edition, as a deluxe 3D collector's edition, in the basic Simply Catan, as a beginner version, and with an entirely new theme in Japan and Asia as Settlers of Catan: Rockman Edition. Numerous spin-offs and expansions have also been made for the game ...";
    private static final String line6 = "7;4;10;3;Basari;30;Negotiation;Roll / Spin and Move,Set Collection,Simultaneous Action Selection;Basari is a game of gem merchants competing in a marketplace&quot : racing, collecting, trading, and predicting what the other merchants will do...To start the game, players receive 12 gemstones (3 each of 4 colors). .Each turn there will be a movement phase and an action phase:..For movement, everyone simultaneously rolls their die and moves their markers around a track...They then choose one of three different actions to perform. The actions are:.- to take a variety of gems from a market stall, .- to immediately score from between 4 and 7 points, or .- to roll and move again and also collect points...The action cards are revealed simultaneously. If only 1 player chose a particular action, they simply perform that action. If 2 players chose the same action, they barter back and forth with gemstones. One player will eventually accept the other's offer of gems, and the other will take the action. If 3 or 4 players all chose the same action card, that action is cancelled. Note that in 4-player games, there will always be a conflict in choice of 3 actions, so much more negotiating goes on...A new turn begins with everyone rolling their die, moving, then choosing and revealing their action cards. When any merchant piece completes a lap around the board, the round ends and bonus points are awarded based on who has the majority in each gem color and who has completed a lap. After three rounds, the game is over and the highest score wins...Re-implemented by:...     Edel, Stein & Reich...";
    private static final String dummyStopWords = "a\n" +
            "about\n" +
            "above\n" +
            "after\n" +
            "again\n" +
            "against\n" +
            "all\n" +
            "am\n" +
            "an\n" +
            "and\n" +
            "any\n" +
            "are\n" +
            "aren't\n" +
            "as\n" +
            "at\n" +
            "be\n" +
            "because\n" +
            "been\n" +
            "before\n" +
            "being\n" +
            "below\n" +
            "between\n" +
            "both\n" +
            "but\n" +
            "by\n" +
            "can't\n" +
            "cannot\n" +
            "could\n" +
            "couldn't\n" +
            "did\n" +
            "didn't\n" +
            "do\n" +
            "does\n" +
            "doesn't\n" +
            "doing\n" +
            "don't\n" +
            "down\n" +
            "during\n" +
            "each\n" +
            "few\n" +
            "for\n" +
            "from\n" +
            "further\n" +
            "had\n" +
            "hadn't\n" +
            "has\n" +
            "hasn't\n" +
            "have\n" +
            "haven't\n" +
            "having\n" +
            "he\n" +
            "he'd\n" +
            "he'll\n" +
            "he's\n" +
            "her\n" +
            "here\n" +
            "here's\n" +
            "hers\n" +
            "herself\n" +
            "him\n" +
            "himself\n" +
            "his\n" +
            "how\n" +
            "how's\n" +
            "i\n" +
            "i'd\n" +
            "i'll\n" +
            "i'm\n" +
            "i've\n" +
            "if\n" +
            "in\n" +
            "into\n" +
            "is\n" +
            "isn't\n" +
            "it\n" +
            "it's\n" +
            "its\n" +
            "itself\n" +
            "let's\n" +
            "me\n" +
            "more\n" +
            "most\n" +
            "mustn't\n" +
            "my\n" +
            "myself\n" +
            "no\n" +
            "nor\n" +
            "not\n" +
            "of\n" +
            "off\n" +
            "on\n" +
            "once\n" +
            "only\n" +
            "or\n" +
            "other\n" +
            "ought\n" +
            "our\n" +
            "ours\n" +
            "ourselves\n" +
            "out\n" +
            "over\n" +
            "own\n" +
            "same\n" +
            "shan't\n" +
            "she\n" +
            "she'd\n" +
            "she'll\n" +
            "she's\n" +
            "should\n" +
            "shouldn't\n" +
            "so\n" +
            "some\n" +
            "such\n" +
            "than\n" +
            "that\n" +
            "that's\n" +
            "the\n" +
            "their\n" +
            "theirs\n" +
            "them\n" +
            "themselves\n" +
            "then\n" +
            "there\n" +
            "there's\n" +
            "these\n" +
            "they\n" +
            "they'd\n" +
            "they'll\n" +
            "they're\n" +
            "they've\n" +
            "this\n" +
            "those\n" +
            "through\n" +
            "to\n" +
            "too\n" +
            "under\n" +
            "until\n" +
            "up\n" +
            "very\n" +
            "was\n" +
            "wasn't\n" +
            "we\n" +
            "we'd\n" +
            "we'll\n" +
            "we're\n" +
            "we've\n" +
            "were\n" +
            "weren't\n" +
            "what\n" +
            "what's\n" +
            "when\n" +
            "when's\n" +
            "where\n" +
            "where's\n" +
            "which\n" +
            "while\n" +
            "who\n" +
            "who's\n" +
            "whom\n" +
            "why\n" +
            "why's\n" +
            "with\n" +
            "won't\n" +
            "would\n" +
            "wouldn't\n" +
            "you\n" +
            "you'd\n" +
            "you'll\n" +
            "you're\n" +
            "you've\n" +
            "your\n" +
            "yours\n" +
            "yourself\n" +
            "yourselves";

    private static String dummyDataSet;

    private static Recommender recommender;


    @BeforeAll
    public static void init() {
        dummyDataSet = line + System.lineSeparator() + line1 + System.lineSeparator() +
                line2 + System.lineSeparator() + line3 + System.lineSeparator() + line4 + System.lineSeparator() +
                line5 + System.lineSeparator() + line6 + System.lineSeparator();

        Reader dataSetReader = new StringReader(dummyDataSet);
        Reader stopWordsReader = new StringReader(dummyStopWords);

        recommender = new BoardGamesRecommender(dataSetReader, stopWordsReader);
    }

    @Test
    void testBoardGameConstructorWithNullReaders() {
        assertThrows(IllegalArgumentException.class, () -> new BoardGamesRecommender(null, null));
    }


    @Test
    void testBoardGameConstructorWithFileNames() {

        Recommender secondRecommender = new BoardGamesRecommender(
                Path.of("data.zip"), "data.csv",
                Path.of("stopwords.txt"));

        assertEquals(recommender.getGames().size(), secondRecommender.getGames().size());
        assertTrue(recommender.getGames().containsAll(secondRecommender.getGames()));
    }

    @Test
    void testBoardGameConstructorWithFileNamesWithNonExistingPath() {
        assertThrows(IllegalStateException.class,
                () -> new BoardGamesRecommender(
                        Path.of("temporaryZipPath12", "dataSet.zip"), "file1.txt",
                        Path.of(String.valueOf("temporaryZipPath"), "stopWords.txt")));

    }

    @Test
    void testGetGamesWithEmptyDataSet() {
        Reader dataSetReader1 = new StringReader("");
        Reader stopWordsReader2 = new StringReader("");
        Recommender recommender1 = new BoardGamesRecommender(dataSetReader1, stopWordsReader2);

        List<BoardGame> boardGameList = new LinkedList<>();
        assertTrue(boardGameList.containsAll(recommender1.getGames()), "The value of getGames for an empty " +
                "data set should be an empty collection");
    }

    @Test
    void testGetGamesWithEightGamesInDataSet() {
        List<BoardGame> boardGameList = new LinkedList<>();
        boardGameList.add(BoardGame.of(line));
        boardGameList.add(BoardGame.of(line1));
        boardGameList.add(BoardGame.of(line2));
        boardGameList.add(BoardGame.of(line3));
        boardGameList.add(BoardGame.of(line4));
        boardGameList.add(BoardGame.of(line5));
        boardGameList.add(BoardGame.of(line6));

        assertEquals(boardGameList.size(), recommender.getGames().size(),
                "The size of the boardGameList and the size of the getGames value should" +
                        "be the same");
        assertTrue(boardGameList.containsAll(recommender.getGames()),
                "The elements in the boardGameList and the recommender.getGames() should be " +
                        "the same");
    }

    @Test
    void testGetGamesForBeingUnmodifiableView() {
        List<BoardGame> boardGameList = new LinkedList<>();
        boardGameList.add(BoardGame.of(line));
        boardGameList.add(BoardGame.of(line1));
        boardGameList.add(BoardGame.of(line2));
        boardGameList.add(BoardGame.of(line3));
        boardGameList.add(BoardGame.of(line4));
        boardGameList.add(BoardGame.of(line5));
        boardGameList.add(BoardGame.of(line6));

        assertThrows(UnsupportedOperationException.class,
                () -> recommender.getGames().add(BoardGame.of(line)),
                "The return value og method getGames() is an Unmodifiable view");
    }

    @Test
    void testGetSimilarToWithNullGame() {
        assertThrows(IllegalArgumentException.class, () -> recommender.getSimilarTo(null, 12),
                "The value of argument game in method detSimilarTo cannot be null");
    }

    @Test
    void testGetSimilarToWithNegativeGame() {
        assertThrows(IllegalArgumentException.class, () -> recommender.getSimilarTo(BoardGame.of(line), -1),
                "The value of argument n cannot be a negative number");
    }

    @Test
    void testGetSimilarToWithEmptyDataSet() {
        Reader dataSetReader1 = new StringReader("");
        Reader stopWordsReader2 = new StringReader("");
        Recommender recommender1 = new BoardGamesRecommender(dataSetReader1, stopWordsReader2);

        List<BoardGame> boardGameList = new LinkedList<>();
        assertTrue(boardGameList.containsAll(recommender1.getSimilarTo(BoardGame.of(line), 12)), "The value of getGames for an empty " +
                "data set should be an empty collection");
    }

    @Test
    void testGetSimilarToWithEightGameDataSet() {
        List<BoardGame> boardGameList = new LinkedList<>();

        boardGameList.add(BoardGame.of(line5));
        boardGameList.add(BoardGame.of(line6));

        assertEquals(recommender.getSimilarTo(BoardGame.of(line), 10).size(), boardGameList.size());
        assertTrue(recommender.getSimilarTo(BoardGame.of(line), 10).containsAll(boardGameList));
    }

    @Test
    void testGetByDescriptionWithNullKeywords() {
        assertThrows(IllegalArgumentException.class, () -> recommender.getByDescription((String[]) null),
                "The value of keywords varargs in method getByDescription connot be null");
    }

    @Test
    void testGetByDescriptionWithOneGameHavingKeyword() {
        String[] keywords = {"Macher"};
        List<BoardGame> boardGameList1 = new LinkedList<>();
        boardGameList1.add(BoardGame.of(line));

        assertEquals(boardGameList1.size(), recommender.getByDescription(keywords).size(),
                "Тhe size of the boardGameList1 and recommender.getByDescription(keywords)" +
                        "should be the same");
        assertTrue(boardGameList1.containsAll(recommender.getByDescription(keywords)),
                "Тhe elements in the boardGameList1 and recommender.getByDescription(keywords)" +
                        "should be the same");
    }

    @Test
    void testGetByDescriptionWithTwoGamesHavingKeyword() {
        String[] keywords = {"Die", "Macher"};
        List<BoardGame> boardGameList1 = new LinkedList<>();
        boardGameList1.add(BoardGame.of(line));
        boardGameList1.add(BoardGame.of(line5));

        assertEquals(boardGameList1.size(), recommender.getByDescription(keywords).size(),
                "Тhe size of the boardGameList1 and recommender.getByDescription(keywords)" +
                        "should be the same");
        assertEquals(boardGameList1.get(0), recommender.getByDescription(keywords).get(0));
        assertEquals(boardGameList1.get(1), recommender.getByDescription(keywords).get(1));
    }

    @Test
    void testGetByDescriptionWithKeywordsBeingOnlyStopWords() {
        List<BoardGame> boardGameList1 = new LinkedList<>();
        assertTrue(boardGameList1.containsAll(recommender.getByDescription(dummyStopWords)),
                "The value of getByDescription all keywords being stopWords" +
                        "and the boardGameList should be an empty collection");
    }

    @Test
    void testGetByDescriptionWithAllGamesHavingAtLeastOneKeyword() {

        String[] keywords = {"detat", "game", "Die", "Macher", "seven", "represent",
                "Japan", "blocks", "buildings", "Catan"};
        List<BoardGame> boardGameList1 = new LinkedList<>();
        boardGameList1.add(BoardGame.of(line5));
        boardGameList1.add(BoardGame.of(line));
        boardGameList1.add(BoardGame.of(line1));
        boardGameList1.add(BoardGame.of(line2));
        boardGameList1.add(BoardGame.of(line4));
        boardGameList1.add(BoardGame.of(line3));
        boardGameList1.add(BoardGame.of(line6));

        List<BoardGame> recommenderGetByDescriptionReturnValue = recommender.getByDescription(keywords);
        assertEquals(boardGameList1.size(), recommenderGetByDescriptionReturnValue.size(),
                "The size of the boardGameList and the size of the return value of" +
                        "method getByDescription should be equal");

        assertTrue(boardGameList1.containsAll(recommenderGetByDescriptionReturnValue));

        assertEquals(boardGameList1.get(0), recommenderGetByDescriptionReturnValue.get(0),
                "The most matching keywords should be in the game with id 6");

        assertEquals(boardGameList1.get(1), recommenderGetByDescriptionReturnValue.get(1),
                "The second most matching keywords should be in the game with id 1");

        assertEquals(boardGameList1.get(2), recommenderGetByDescriptionReturnValue.get(2),
                "The third most matching keywords should be in the game with id 2");

        assertEquals(boardGameList1.get(6), recommenderGetByDescriptionReturnValue.get(6),
                "The seventh most matching keywords should be in the game with id 7");
    }

    @Test
    void testStoreIndexWithNullWriter() {
        assertThrows(IllegalArgumentException.class, () -> recommender.storeGamesIndex(null),
                "The value of argument writer in method storeGamesIndex() cannot be null");
    }

    @Test
    void testStoreIndexInValidWriter() throws IOException {
        Writer writer = new StringWriter();
        recommender.storeGamesIndex(writer);
        String[] taggedText = writer.toString().split(System.lineSeparator());

        assertEquals(taggedText[0], "settlements: 6");
        assertEquals(taggedText[1], "hands: 2");
        assertEquals(taggedText[10], "wins: 1, 2, 5, 7");
    }
}