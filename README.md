# True or False Trivia Game

> **Name**: Ryo Alessandro Javva Ananda Satriyo
> **Student Number**: 89018

I created a single-player true or false trivia game using Java Command Line Application. In this program, there are six different design patterns that the author is trying to implement. There are two creational patterns, namely Singleton and Factory. Next, there are two structural patterns, namely Decorator and Facade. Finally, there are two behavioral patterns, namely Command and Observer. The author combines these design patterns to make the code more efficient to manage, well-organized, and efficient. I decided to do this task myself because there is more flexibility to be creative and add something to the project without having to depend on other members.

> GitHub Repository: [alessandroryo/trivia-game](https://github.com/alessandroryo/trivia-game)

## Creational Design Patterns

### Singleton

According to the Singleton design pattern, a class is guaranteed to have only one instance, which also gives that instance a global access point. In this project, the *Main* class implements the Singleton design pattern to ensure that only one game instance is played simultaneously. This is achieved by making the constructor private and providing a static `getInstance()` method to access a single class instance. The `getInstance()` method is called in the main method, namely the `public static void main(String[] args)` method, and further proves that only one game will be played at a time.

**Main.java**

```java
public class Main {
    private static Main instance = null;
    // Other properties

    private Main() {}

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
     * The main method of the program.
     * It creates an instance of the Main class using the singleton pattern.
     * Then, it creates the game object using the TriviaGameFactory,
     * attaches the ScoreObserver and GameOverObserver, and plays the game.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        Main game = Main.getInstance();
        ...
        game.startGame();
    }

    // Other methods
}
```

### Factory

Without defining the precise class of the object to be constructed, the factory design pattern is used to create objects. In this project, the *TriviaGameFactory* class implements the Factory design pattern by providing a `createTriviaGame()` method that takes a gameType parameter and creates an instance of the appropriate TriviaGame subclass (*EasyTriviaGame*, *MediumTriviaGame*, or *HardTriviaGame*) based on the user's input. As a result, the program can generate objects of the suitable class without needing to declare its specific class beforehand.

**TriviaGameFactory.java**

```java
/**
 * TriviaGameFactory is a concrete class that creates TriviaGame objects.
 * It has a static createTriviaGame method that takes in a gameType string parameter and returns a TriviaGame object.
 */
public class TriviaGameFactory {
    /**
     * This static method creates a TriviaGame object based on the gameType parameter.
     * @param gameType The type of trivia game to be created. Can be "easy", "medium", or "hard"
     * @return A TriviaGame object
     */
    public static TriviaGame createTriviaGame(String gameType) {
        TriviaGameFacade facade = new TriviaGameFacade();
        TriviaGame game = null;
        if (gameType.equals("1")) {
            game = facade.playEasyGame();
        } else if (gameType.equals("2")) {
            game = facade.playMediumGame();
        } else if (gameType.equals("3")) {
            game = facade.playHardGame();
        } else {
            game = facade.playEasyGame();
        }
        game = new TimerDecorator(game);
        return game;
    }
}
```

## Structural Design Patterns

### Decorator

The Decorator design pattern dynamically adds other behaviors or responsibilities to an object at runtime. In this project, the *TimerDecorator* class implement the Decorator design pattern by adding new functionality to the *TriviaGame* class through *TriviaDecorator* class. The *TimerDecorator* class adds a timer to the game, while the *TriviaDecorator* class is to ensure that TriviaGame is decorated.

**TimerDecorator.java**

```java
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
```

### Facade

The Facade design pattern provides a simple, unified interface for a complex system. In this project, the *TriviaGameFacade* class is the facade that provides a simplified interface for playing the trivia game. The class has a constructor that creates instances of *EasyTriviaGame*, *MediumTriviaGame*, and *HardTriviaGame*. It also has three methods, `playEasyGame()`, `playMediumGame()`, and `playHardGame()`, that return the appropriate trivia game and hide the complexity of the underlying classes.

**TriviaGameFacade.java**

```java
/**
 * TriviaGameFacade is a facade class that provides a simplified interface to the TriviaGame classes.
 * This class creates new EasyTriviaGame, MediumTriviaGame, HardTriviaGame, and has methods playEasyGame,
 * playMediumGame, and playHardGame that allows clients to play the game without knowing the underlying
 * implementations of the TriviaGame classes.
 */
public class TriviaGameFacade {
    private final EasyTriviaGame easyGame;
    private final MediumTriviaGame mediumGame;
    private final HardTriviaGame hardGame;

    /**
     * Constructor for TriviaGameFacade.
     */
    public TriviaGameFacade() {
        easyGame = new EasyTriviaGame();
        mediumGame = new MediumTriviaGame();
        hardGame = new HardTriviaGame();
    }

    // Other methods
}
```

## Behavioral Design Patterns

### Command

A request or operation is packaged as an object and handed around as a single command using the Command design pattern. In this project, the *TriviaGameCommand* interface and *StartGameCommand* class implement the Command design pattern by encapsulating the request to start the trivia game as an object. The *StartGameCommand* class has a constructor that takes a TriviaGame object and an `execute()` method that plays the game. This `execute()` method will be called in *Main* class in `startGame()` method.

**TriviaGameCommand.java**

```java
public interface TriviaGameCommand {
    /**
     * This method executes the trivia game.
     */
    void execute();
}
```

**StartGameCommand.java**

```java
/**
 * StartGameCommand is a concrete class that implements the TriviaGameCommand interface.
 * This class has a constructor that takes in a TriviaGame object and a play method that
 * plays the trivia game.
 */
public class StartGameCommand implements TriviaGameCommand {
    protected TriviaGame triviaGame;

    /**
     * Constructor for StartGameCommand.
     * @param triviaGame The trivia game object to be played
     */
    public StartGameCommand(TriviaGame triviaGame) {
        this.triviaGame = triviaGame;
    }

    /**
     * This method plays the trivia game.
     */
    public void execute() {
        triviaGame.play();
    }
}
```

**Main.java**

```java
public class Main {
 ...
    /**
     * This method starts the trivia game.
     */
    public static void startGame() {
        ...
        Scanner input = new Scanner(System.in);
        String level = input.nextLine();
        TriviaGame triviaGame = TriviaGameFactory.createTriviaGame(level);
        TriviaGameCommand startGameCommand = new StartGameCommand(triviaGame);
        startGameCommand.execute();
    }
}
```

### Observer

The Observer design pattern is used to allow objects to be notified when the state of another object changes. In this project, the *ScoreObserverImplementation* and *GameOverObserverImplementation* classes, implement the Observer design pattern by allowing the *TriviaGame* class to notify other objects when the score or game over state changes. Both are used in the *Main* class when the player runs the program.

**ScoreObserver.java**

```java
/**
 * The ScoreObserver interface defines the update method that is used to update the score of the game.
 * The interface is implemented by classes that want to be notified of score updates.
 */
public interface ScoreObserver {
    /**
     * This method updates the score of the game.
     * @param score The new score of the game
     */
    void update(int score);
}
```

**ScoreObserverImplementation.java**

```java
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
```

**GameOverObserver.java**

```java
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
```

**GameOverObserverImplementation.java**

```java
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
```

**Main.java**

```java
public class Main {
    private static ScoreObserver scoreObserver;
    private static GameOverObserver gameOverObserver;
    
    ...

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
```

## How to Play

1. Open the Main class.
2. The program will give you an introduction and level options in the game.
3. The player can enter a number according to the level they want to play.
4. Shortly after that, the game will start. The program will give a statement, and players only need to write T (true) or F (false).
5. For each correct answer, the player's score will be added by 1. If the player's answer is wrong, the score will not change.
6. The game will stop when the player has answered all the questions in each level.
7. The program will display the final score and the time needed to complete all questions.

## Conclusion

This project demonstrates the implementation of several design patterns in a Java CLI program, such as Singleton, Factory, Decorator, Facade, Command, and Observer design patterns. These design patterns make the code more organized, efficient, and easier to maintain.