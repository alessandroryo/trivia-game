package alessandroryo.designpatterns.programs;

/**
 * The TriviaGameCommand interface defines the execute method that is used to execute the trivia game.
 * The interface is implemented by classes that want to execute the trivia game.
 */
public interface TriviaGameCommand {
    /**
     * This method executes the trivia game.
     */
    void execute();
}
