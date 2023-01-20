package alessandroryo.designpatterns.programs;

/**
 * GameOverObserverImplementation is a concrete class that implements the GameOverObserver interface
 * and is responsible for handling game over events.
 */
class GameOverObserverImplementation implements GameOverObserver {
    /**
     * This method updates the game over status and displays the appropriate message.
     * @param gameOver The game over status (true if game is over, false otherwise)
     */
    @Override
    public void update(boolean gameOver) {
        if (gameOver) {
            System.out.println("Game Over! Your final score is: " + Main.getScore());
        }
    }
}
