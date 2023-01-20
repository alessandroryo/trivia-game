package alessandroryo.designpatterns.programs;

/**
 * HardTriviaGame is a concrete class that extends the TriviaGame class.
 * This class has a constructor that sets the questions and answers for the hard level of the trivia game.
 */
public class HardTriviaGame extends TriviaGame {
    /**
     * Constructor for HardTriviaGame.
     */
    public HardTriviaGame(){
        super(new String[] {
                "The capital of the United Arab Emirates is Abu Dhabi.",
                "The largest glacier in the world is the Lambert Glacier.",
                "The tallest waterfall in the world is the Angel Falls.",
                "The deepest point in the ocean is the Challenger Deep.",
                "The highest volcano in the world is the Ojos del Salado.",
                "The longest cave system in the world is the Mammoth Cave System.",
                "The largest coral reef in the world is the Great Barrier Reef.",
                "The oldest known tree in the world is the Methuselah Tree.",
                "The driest place on Earth is the Atacama Desert.",
                "The largest lake in the world is the Caspian Sea."
        }, new String[] {
                "T", "T", "T", "T", "T", "T", "F", "T", "T", "F"
        });
    }
}
