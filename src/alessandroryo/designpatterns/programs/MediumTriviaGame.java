package alessandroryo.designpatterns.programs;

/**
 * MediumTriviaGame is a concrete class that extends the TriviaGame class.
 * This class has a constructor that sets the questions and answers for the medium level of the trivia game.
 */
public class MediumTriviaGame extends TriviaGame {
    /**
     * Constructor for MediumTriviaGame.
     */
    public MediumTriviaGame(){
        super(new String[] {
                "The capital of Italy is Rome.",
                "The Great Barrier Reef is located in Australia.",
                "The largest desert in the world is the Antarctic Desert.",
                "The tallest mountain in the world is Mount Everest.",
                "The longest river in the world is the Nile.",
                "The largest ocean in the world is the Pacific Ocean.",
                "The most populated country in the world is China.",
                "The smallest country in the world is Vatican City.",
                "The oldest known civilization is the Sumerian civilization.",
                "The first human-made object to reach space was the V-2 rocket."
        }, new String[] {
                "T", "T", "F", "T", "T", "T", "T", "T", "T", "T"
        });
    }
}
