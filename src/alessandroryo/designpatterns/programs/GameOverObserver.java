package alessandroryo.designpatterns.programs;

/**
 * The GameOverObserver interface defines the update method that is used to notify of game over.
 * The interface is implemented by classes that want to be notified when the game is over.
 */
public interface GameOverObserver {
    /**
     * This method updates the game over status.
     * @param gameOver The game over status (true if game is over, false otherwise)
     */
    void update(boolean gameOver);
}
