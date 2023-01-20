package alessandroryo.designpatterns.programs;

/**
 * The ScoreObserver interface defines the update method that is used to update the score of the game.
 * The interface is implemented by classes that want to be notified of score updates.
 */
public interface ScoreObserver {
    /**
     * This method updates the score of the game.
     * @param score The new score of the game
     */
    void update(int score);
}

