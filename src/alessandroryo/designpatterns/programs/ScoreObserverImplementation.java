package alessandroryo.designpatterns.programs;

/**
 * ScoreObserverImplementation is a concrete class that implements the ScoreObserver interface
 * and is responsible for handling score updates.
 */
public class ScoreObserverImplementation implements ScoreObserver {
    /**
     * This method updates the score.
     * @param score The new score of the game
     */
    @Override
    public void update(int score) {
        System.out.println("Your current score is: " + score);
    }
}
