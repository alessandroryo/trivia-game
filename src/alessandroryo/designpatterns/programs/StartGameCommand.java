package alessandroryo.designpatterns.programs;

/**
 * StartGameCommand is a concrete class that implements the TriviaGameCommand interface.
 * This class has a constructor that takes in a TriviaGame object and a play method that
 * plays the trivia game.
 */
public class StartGameCommand implements TriviaGameCommand {
    protected TriviaGame triviaGame;

    /**
     * Constructor for StartGameCommand.
     * @param triviaGame The trivia game object to be played
     */
    public StartGameCommand(TriviaGame triviaGame) {
        this.triviaGame = triviaGame;
    }

    /**
     * This method plays the trivia game.
     */
    public void execute() {
        triviaGame.play();
    }
}
