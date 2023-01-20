package alessandroryo.designpatterns.programs;

/**
 * TriviaGameFacade is a facade class that provides a simplified interface to the TriviaGame classes.
 * This class creates new EasyTriviaGame, MediumTriviaGame, HardTriviaGame, and has methods playEasyGame,
 * playMediumGame, and playHardGame that allows clients to play the game without knowing the underlying
 * implementations of the TriviaGame classes.
 */
public class TriviaGameFacade {
    private final EasyTriviaGame easyGame;
    private final MediumTriviaGame mediumGame;
    private final HardTriviaGame hardGame;

    /**
     * Constructor for TriviaGameFacade.
     */
    public TriviaGameFacade() {
        easyGame = new EasyTriviaGame();
        mediumGame = new MediumTriviaGame();
        hardGame = new HardTriviaGame();
    }

    /**
     * This method plays the easy trivia game.
     */
    public TriviaGame playEasyGame() {
        return easyGame;
    }

    /**
     * This method plays the medium trivia game.
     */
    public TriviaGame playMediumGame() {
        return mediumGame;
    }

    /**
     * This method plays the hard trivia game.
     */
    public TriviaGame playHardGame() {
        return hardGame;
    }
}
