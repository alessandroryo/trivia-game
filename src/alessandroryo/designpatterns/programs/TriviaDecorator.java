package alessandroryo.designpatterns.programs;

abstract class TriviaDecorator extends TriviaGame {
    /**
     * The TriviaGame object that is being decorated
     */
    protected TriviaGame triviaGame;

    /**
     * Constructor for TriviaDecorator.
     * @param triviaGame The TriviaGame object that is being decorated
     */
    public TriviaDecorator(TriviaGame triviaGame) {
        super(new String[] {}, new String[] {});
        this.triviaGame = triviaGame;
    }
}