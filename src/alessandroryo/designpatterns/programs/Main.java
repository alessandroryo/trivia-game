package alessandroryo.designpatterns.programs;

import java.util.Scanner;

/**
 * Main is the starting point of the trivia game program.
 * It uses the singleton pattern to ensure that only one instance of the class is created.
 * It also uses the facade pattern to simplify the process of starting the game.
 */
public class Main {
    private static Main instance = null;
    private static int score = 0;
    private static ScoreObserver scoreObserver;
    private static GameOverObserver gameOverObserver;

    private Main() {};

    /**
     * This static method returns the instance of the Main class.
     * @return The instance of the Main class
     */
    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    /**
     * This method attaches a ScoreObserver to the Main class.
     * @param observer The ScoreObserver to be attached
     */
    public static void attachScoreObserver(ScoreObserver observer) {
        scoreObserver = observer;
    }

    /**
     * This method attaches a GameOverObserver to the Main class.
     * @param observer The GameOverObserver to be attached
     */
    public static void attachGameOverObserver(GameOverObserver observer) {
        gameOverObserver = observer;
    }

    /**
     * This method updates the score and notifies the score observer.
     * @param newScore The new score
     */
    public static void updateScore(int newScore) {
        score = newScore;
        scoreObserver.update(score);
    }

    /**
     * This method updates the game over status and notifies the game over observer.
     * @param newGameOver The game over status
     */
    public static void updateGameOver(boolean newGameOver) {
        gameOverObserver.update(newGameOver);
    }

    /**
     * This method starts the trivia game.
     */
    public static void startGame() {
        System.out.println("Welcome to the True or False Trivia Game!");
        System.out.println("You simply need to type T (True) or F (False) as your answer");
        System.out.println("Select the difficulty level:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.println();
        System.out.println("Write the number:");
        Scanner input = new Scanner(System.in);
        String level = input.nextLine();
        TriviaGame triviaGame = TriviaGameFactory.createTriviaGame(level);
        TriviaGameCommand startGameCommand = new StartGameCommand(triviaGame);
        startGameCommand.execute();
    }

    /**
     * The main method of the program.
     * It creates an instance of the Main class using the singleton pattern.
     * Then, it creates the game object using the TriviaGameFactory,
     * attaches the ScoreObserver and GameOverObserver, and plays the game.
     */
    public static void main(String[] args) {
        Main game = Main.getInstance();
        game.attachScoreObserver(new ScoreObserverImplementation());
        game.attachGameOverObserver(new GameOverObserverImplementation());
        game.startGame();
    }

    /**
     * This method returns the current score.
     * @return The current score
     */
    public static int getScore() {
        return score;
    }
}
