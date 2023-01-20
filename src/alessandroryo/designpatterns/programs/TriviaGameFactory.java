package alessandroryo.designpatterns.programs;

/**
 * TriviaGameFactory is a concrete class that creates TriviaGame objects.
 * It has a static createTriviaGame method that takes in a gameType string parameter and returns a TriviaGame object.
 */
public class TriviaGameFactory {
    /**
     * This static method creates a TriviaGame object based on the gameType parameter.
     * @param gameType The type of trivia game to be created. Can be "easy", "medium", or "hard"
     * @return A TriviaGame object
     */
    public static TriviaGame createTriviaGame(String gameType) {
        TriviaGameFacade facade = new TriviaGameFacade();
        TriviaGame game = null;
        if (gameType.equals("1")) {
            game = facade.playEasyGame();
        } else if (gameType.equals("2")) {
            game = facade.playMediumGame();
        } else if (gameType.equals("3")) {
            game = facade.playHardGame();
        } else {
            game = facade.playEasyGame();
        }
        game = new TimerDecorator(game);
        return game;
    }
}
