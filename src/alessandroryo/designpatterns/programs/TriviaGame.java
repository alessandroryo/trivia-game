package alessandroryo.designpatterns.programs;

import java.util.Scanner;

/**
 * TriviaGame is a concrete class that represents a trivia game.
 * This class has 2 array string properties for questions and answers, a constructor, and a play method.
 */
public class TriviaGame {
    protected String[] questions;
    protected String[] answers;

    /**
     * Constructor for TriviaGame.
     * @param questions An array of questions for the trivia game
     * @param answers An array of answers for the trivia game, corresponding to the questions
     */
    public TriviaGame(String[] questions, String[] answers) {
        this.questions = questions;
        this.answers = answers;
    }

    /**
     * This method plays the trivia game.
     * @return The trivia game object
     */
    public TriviaGame play() {
        Scanner input = new Scanner(System.in);
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase(answers[i])) {
                System.out.println("Correct!");
                score++;
                Main.updateScore(score);
            } else {
                System.out.println("Incorrect.");
            }
        }
        Main.updateGameOver(true);
        input.close();
        return null;
    }
}
