package alessandroryo.designpatterns.programs;

/**
 * EasyTriviaGame is a concrete class that extends the TriviaGame class.
 * This class has a constructor that sets the questions and answers for the easy level of the trivia game.
 */
public class EasyTriviaGame extends TriviaGame {
    /**
     * Constructor for EasyTriviaGame.
     */
    public EasyTriviaGame(){
        super(new String[] {
                "The capital of France is Paris.",
                "The Great Wall of China is visible from space.",
                "The color of the sky is blue.",
                "The Earth has one moon.",
                "The Earth is the third planet from the sun.",
                "Water is made up of two hydrogen atoms and one oxygen atom.",
                "A cat has four legs.",
                "A dog is a mammal.",
                "Elephants are the largest land animals.",
                "Giraffes have the longest necks."
        }, new String[] {
                "T", "F", "T", "T", "T", "T", "T", "T", "T", "T"
        });
    }
}
