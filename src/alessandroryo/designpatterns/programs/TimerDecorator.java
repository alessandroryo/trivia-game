package alessandroryo.designpatterns.programs;

public class TimerDecorator extends TriviaDecorator {
    /**
     * Constructor for TimerDecorator.
     * @param triviaGame The TriviaGame object that is being decorated
     */
    public TimerDecorator(TriviaGame triviaGame) {
        super(triviaGame);
    }

    /**
     * This method calculates and returns the total time taken to complete the game.
     * @return The total time taken to complete the game in seconds
     */
    public double getTotalTime(long endTime, long startTime) {
        return (endTime - startTime) / 1000.0;
    }

    /**
     * This method starts the timer before playing the game
     */
    @Override
    public TriviaGame play() {
        long startTime = System.currentTimeMillis();
        triviaGame.play();
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: " + getTotalTime(endTime, startTime) + "s");
        return null;
    }
}