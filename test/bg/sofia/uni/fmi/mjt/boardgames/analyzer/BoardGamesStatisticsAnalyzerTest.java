package bg.sofia.uni.fmi.mjt.boardgames.analyzer;


import bg.sofia.uni.fmi.mjt.boardgames.BoardGame;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


class BoardGamesStatisticsAnalyzerTest {

    private static final String line = "1;5;14;3;Die Macher;240;Economic,Negotiation,Political;Area Control / Area Influence,Auction/Bidding,Dice Rolling,Hand Management,Simultaneous Action Selection;Die Macher is a game about seven sequential political races in different regions of Germany. Players are in charge of national political parties, and must manage limited resources to help their party to victory. The winning party will have the most victory points after all the regional elections. There are four different ways of scoring victory points. First, each regional election can supply one to eighty victory points, depending on the size of the region and how well your party does in it. Second, if a party wins a regional election and has some media influence in the region, then the party will receive some media-control victory points. Third, each party has a national party membership which will grow as the game progresses and this will supply a fair number of victory points. Lastly, parties score some victory points if their party platform matches the national opinions at the end of the game...The 1986 edition featured 4 parties from the old West Germany and supported 3-4 players. The 1997 edition supports up to 5 players in the re-united Germany and updated several features of the rules as well.  The 2006 edition also supports up to 5 players and adds a shorter 5 round variant and additional rules updates by the original designer...Die Macher is #1 in the Valley Games Classic Line..";
    private static final String line1 = "2;4;12;3;Dragonmaster;30;Card Game,Fantasy;Trick-taking;Dragonmaster is a trick-taking card game based on an older game called Coup d'etat. Each player is given a supply of plastic gems, which represent points. Each player will get to be the dealer for five different hands, with slightly different goals for each hand. After all cards have been dealt out, the dealer decides which hand best suits his or her current cards, and the other players are penalized points (in the form of crystals) for taking certain tricks or cards. For instance, if &quot first&quot  or &quot last&quot  is called, then a player is penalized for taking the first or last tricks. All players will get a chance to be dealer for five hands, but other players can steal this opportunity by taking all of the tricks during certain hands. At the end, the biggest pile of gems wins the game...Jewel contents:..11 clear (3 extra).13 green (1 extra).22 red (2 extra).22 blue (2 extra).. ";
    private static final String line2 = "3;4;10;2;Samurai;60;Abstract Strategy,Medieval;Area Control / Area Influence,Hand Management,Set Collection,Tile Placement;Part of the Knizia tile-laying trilogy, Samurai is set in medieval Japan. Players compete to gain the favor of three factions: samurai, peasants, and priests, which are represented by helmet, rice paddy, and Buddha tokens scattered about the board, which features the islands of Japan. The competition is waged through the use of hexagonal tiles, each of which help curry favor of one of the three factions &mdash  or all three at once! Players can make lightning-quick strikes with horseback ronin and ships or approach their conquests more methodically. As each token (helmets, rice paddies, and Buddhas) is surrounded, it is awarded to the player who has gained the most favor with the corresponding group...Gameplay continues until all the symbols of one type have been removed from the board or four tokens have been removed from play due to a tie for influence...At the end of the game, players compare captured symbols of each type, competing for majorities in each of the three types. Ties are not uncommon and are broken based on the number of other, &quot non-majority&quot  symbols each player has collected...";
    private static final String line3 = "4;4;12;2;Tal der Könige;60;Ancient;Action Point Allowance System,Area Control / Area Influence,Auction/Bidding,Set Collection;When you see the triangular box and the luxurious, large blocks, you can tell this game was designed to be beautiful as well as functional.  The object of the game is to build pyramids out of the different colored blocks.  A pyramid scores more points when it's made from a few colors, but it's much harder to consistently outbid the other players for the necessary blocks.  The game is over when the Pharoah's Pyramid in the center is completed, which is built using all the blocks that the players don't use during the course of the game...Final round 1990 Hippodice Spieleautorenwettbewerb...";
    private static final String line4 = "5;2;8;2;Cathedral;20;Abstract Strategy;Area Enclosure,Pattern Building,Pattern Recognition,Tile Placement;In Cathedral, each player has a set of pieces of a different color. The pieces are in the shapes of buildings, covering from one to five square units. The first player takes the single neutral Cathedral piece and places it onto the board. Players then alternate placing one of their buildings onto the board until neither player can place another building. Players capture territory by surrounding areas that are occupied by at most one opponent or neutral building. A captured piece is removed and captured territory becomes off-limits to the opponent. The player with the fewest 'square units' of buildings that can't be placed wins...";
    private static final String line5 = "6;4;10;3;Catan;120;Negotiation;Dice Rolling,Hand Management,Modular Board,Route/Network Building,Trading;In Catan (formerly The Settlers of Catan), players try to be the dominant force on the island of Catan by building settlements, cities, and roads. On each turn dice are rolled to determine what resources the island produces. Players collect these resources (cards)&mdash wood, grain, brick, sheep, or stone&mdash to build up their civilizations to get to 10 victory points and win the game...Setup includes randomly placing large hexagonal tiles (each showing a resource or the desert) in a honeycomb shape and surrounding them with water tiles, some of which contain ports of exchange. Number disks, which will correspond to die rolls (two 6-sided dice are used), are placed on each resource tile. Each player is given two settlements (think: houses) and roads (sticks) which are, in turn, placed on intersections and borders of the resource tiles. Players collect a hand of resource cards based on which hex tiles their last-placed house is adjacent to. A robber pawn is placed on the desert tile...A turn consists of possibly playing a development card, rolling the dice, everyone (perhaps) collecting resource cards based on the roll and position of houses (or upgraded cities&mdash think: hotels) unless a 7 is rolled, turning in resource cards (if possible and desired) for improvements, trading cards at a port, and trading resource cards with other players. If a 7 is rolled, the active player moves the robber to a new hex tile and steals resource cards from other players who have built structures adjacent to that tile...Points are accumulated by building settlements and cities, having the longest road and the largest army (from some of the development cards), and gathering certain development cards that simply award victory points. When a player has gathered 10 points (some of which may be held in secret), he announces his total and claims the win...Catan has won multiple awards and is one of the most popular games in recent history due to its amazing ability to appeal to experienced gamers as well as those new to the hobby...Die Siedler von Catan was originally published by KOSMOS and has gone through multiple editions. It was licensed by Mayfair and has undergone four editions as The Settlers of Catan. In 2015, it was formally renamed Catan to better represent itself as the core and base game of the Catan series. It has been re-published in two travel editions, portable edition and compact edition, as a special gallery edition (replaced in 2009 with a family edition), as an anniversary wooden edition, as a deluxe 3D collector's edition, in the basic Simply Catan, as a beginner version, and with an entirely new theme in Japan and Asia as Settlers of Catan: Rockman Edition. Numerous spin-offs and expansions have also been made for the game...";
    private static final String line6 = "7;4;10;3;Basari;30;Negotiation;Roll / Spin and Move,Set Collection,Simultaneous Action Selection;Basari is a game of gem merchants competing in a marketplace&quot : racing, collecting, trading, and predicting what the other merchants will do...To start the game, players receive 12 gemstones (3 each of 4 colors). .Each turn there will be a movement phase and an action phase:..For movement, everyone simultaneously rolls their die and moves their markers around a track...They then choose one of three different actions to perform. The actions are:.- to take a variety of gems from a market stall, .- to immediately score from between 4 and 7 points, or .- to roll and move again and also collect points...The action cards are revealed simultaneously. If only 1 player chose a particular action, they simply perform that action. If 2 players chose the same action, they barter back and forth with gemstones. One player will eventually accept the other's offer of gems, and the other will take the action. If 3 or 4 players all chose the same action card, that action is cancelled. Note that in 4-player games, there will always be a conflict in choice of 3 actions, so much more negotiating goes on...A new turn begins with everyone rolling their die, moving, then choosing and revealing their action cards. When any merchant piece completes a lap around the board, the round ends and bonus points are awarded based on who has the majority in each gem color and who has completed a lap. After three rounds, the game is over and the highest score wins...Re-implemented by:...     Edel, Stein & Reich...";

    private static StatisticsAnalyzer statisticsAnalyzer;

    @BeforeAll
    public static void init() {
        Collection<BoardGame> games = new LinkedList<>();
        games.add(BoardGame.of(line));
        games.add(BoardGame.of(line1));
        games.add(BoardGame.of(line2));
        games.add(BoardGame.of(line3));
        games.add(BoardGame.of(line4));
        games.add(BoardGame.of(line5));
        games.add(BoardGame.of(line6));
        statisticsAnalyzer = new BoardGamesStatisticsAnalyzer(games);
    }

    @AfterAll
    public static void tearDown() {
        ///do nothing
    }

    @Test
    void testGetNMostPopularCategoriesWithNegativeN() {
        assertThrows(IllegalArgumentException.class, () -> statisticsAnalyzer.getNMostPopularCategories(-1),
                "The value of N cannot be a negative number!");
    }

    @Test
    void testGetNMostPopularCategoriesWithEmptyGamesCollection() {
        Collection<BoardGame> games1 = new LinkedList<>();
        StatisticsAnalyzer statisticsAnalyzer1 = new BoardGamesStatisticsAnalyzer(games1);

        List<String> categoriesList = new LinkedList<>();
        assertTrue(categoriesList.containsAll(statisticsAnalyzer1.getNMostPopularCategories(10)),
                "Both lists should be empty!");
    }

    @Test
    void testGetNMostPopularCategoriesWithNMoreThanGamesSize() {
        List<String> categoriesList = new LinkedList<>();
        categoriesList.add("negotiation");
        categoriesList.add("abstract strategy");
        categoriesList.add("fantasy");
        categoriesList.add("card game");
        categoriesList.add("medieval");
        categoriesList.add("political");
        categoriesList.add("ancient");
        categoriesList.add("economic");

        assertEquals(categoriesList.size(), statisticsAnalyzer.getNMostPopularCategories(20).size(),
                "All the games in the data set are 8");
        assertTrue(categoriesList.containsAll(statisticsAnalyzer.getNMostPopularCategories(20)),
                "The elements in the categoriesList in testGetNMostPopularCategoriesWithNMoreThanGamesSize and " +
                        "the all categories in the data set should be the same");
    }

    @Test
    void testGetNMostPopularCategoriesWithNLessThanGamesSize() {
        List<String> categoriesList = new LinkedList<>();
        categoriesList.add("negotiation");
        categoriesList.add("abstract strategy");
        categoriesList.add("fantasy");

        assertEquals(categoriesList.size(), statisticsAnalyzer.getNMostPopularCategories(3).size(),
                "The games from the getNMostPopularCategories with n = 3 should be 3");
        assertTrue(categoriesList.containsAll(statisticsAnalyzer.getNMostPopularCategories(3)),
                "The elements in the categoriesList in testGetNMostPopularCategoriesWithNMoreThanGamesSize and " +
                        "the all categories in the data set should be the same");
    }

    @Test
    void testGetAverageMinAgeWithEmptyDataSet() {
        List<BoardGame> games1 = new LinkedList<>();
        StatisticsAnalyzer statisticsAnalyzer1 = new BoardGamesStatisticsAnalyzer(games1);

        assertEquals(0.0, statisticsAnalyzer1.getAverageMinAge(),
                "The getAverageMinAge with an empty data set should be 0.0");
    }

    @Test
    void testGetAverageMinAgeWithEightGameDataSet() {
        assertEquals(10.857142857142858, statisticsAnalyzer.getAverageMinAge(),
                "The getAverageMinAge with an empty data set should be 10.857142857142858");
    }

    @Test
    void testGetAveragePlayingTimeByCategoryWithNull() {
        assertThrows(IllegalArgumentException.class, () -> statisticsAnalyzer.getAveragePlayingTimeByCategory(null),
                "The value of the category name in method getAveragePlayingTimeByCategory connot be null");
    }

    @Test
    void testGetAveragePlayingTimeByCategoryWithEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> statisticsAnalyzer.getAveragePlayingTimeByCategory(""),
                "The value of the category name in method getAveragePlayingTimeByCategory connot be null");
    }

    @Test
    void testGetAveragePlayingTimeByCategoryWithEmptyDataSet() {
        List<BoardGame> games1 = new LinkedList<>();
        StatisticsAnalyzer statisticsAnalyzer1 = new BoardGamesStatisticsAnalyzer(games1);

        assertEquals(0.0, statisticsAnalyzer1.getAveragePlayingTimeByCategory("some string"),
                "The getAveragePlayingTimeByCategory with an empty data set should be 0.0");
    }

    @Test
    void testGetAveragePlayingTimeByCategoryWithNonGamesByThisCategory() {
        assertEquals(0.0, statisticsAnalyzer.getAveragePlayingTimeByCategory("impossibleToGuessCategory1234"),
                "The getAveragePlayingTimeByCategory value with this category should be 0.0");
    }

    @Test
    void testGetAveragePlayingTimeByCategoryWithOneGameByThisCategory() {
        assertEquals(240.0, statisticsAnalyzer.getAveragePlayingTimeByCategory("economic"),
                "The getAveragePlayingTimeByCategory value with this category should be 240.0");
    }

    @Test
    void testGetAveragePlayingTimeByCategoryWithThreeGameByThisCategory() {
        assertEquals(130.0, statisticsAnalyzer.getAveragePlayingTimeByCategory("negotiation"),
                "The getAveragePlayingTimeByCategory value with this category should be 130.0");
    }

    @Test
    void testGetAveragePlayingTimeByCategoriesWithEmptyDataSet() {
        List<BoardGame> games1 = new LinkedList<>();
        StatisticsAnalyzer statisticsAnalyzer1 = new BoardGamesStatisticsAnalyzer(games1);

        Map<String, Double> categoriesWithTheirAveragePlayTimeMap = new HashMap<>();

        assertTrue(categoriesWithTheirAveragePlayTimeMap.entrySet().containsAll(statisticsAnalyzer1.getAveragePlayingTimeByCategory().entrySet()),
                "Both the categoriesWithTheirAveragePlayTimeMap and the getAveragePlayingTimeByCategory value should be an " +
                        "empty collection");
    }

    @Test
    void testGetAveragePlayingTimeByCategoriesWithEightGamesDataSet() {
        Map<String, Double> categoriesWithTheirAveragePlayTimeMap = new HashMap<>();

        categoriesWithTheirAveragePlayTimeMap.put("negotiation", 130.0);
        categoriesWithTheirAveragePlayTimeMap.put("abstract strategy", 40.0);
        categoriesWithTheirAveragePlayTimeMap.put("fantasy", 30.0);
        categoriesWithTheirAveragePlayTimeMap.put("card game", 30.0);
        categoriesWithTheirAveragePlayTimeMap.put("medieval", 60.0);
        categoriesWithTheirAveragePlayTimeMap.put("political", 240.0);
        categoriesWithTheirAveragePlayTimeMap.put("ancient", 60.0);
        categoriesWithTheirAveragePlayTimeMap.put("economic", 240.0);

        assertEquals(categoriesWithTheirAveragePlayTimeMap.size(), statisticsAnalyzer.getAveragePlayingTimeByCategory().size());
        assertTrue(categoriesWithTheirAveragePlayTimeMap.entrySet().containsAll(statisticsAnalyzer.getAveragePlayingTimeByCategory().entrySet()),
                "The categoriesWithTheirAveragePlayTimeMap and the getAveragePlayingTimeByCategory value should have " +
                        "the same elements");
    }

}