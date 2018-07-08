package com.kaze;

import com.kaze.ai.AiStrategy;
import com.kaze.ai.impl.EasyAiStrategy;
import com.kaze.ai.impl.HardAiStrategy;
import com.kaze.ai.impl.NormalAiStrategy;
import com.kaze.handlers.*;
import com.kaze.handlers.impl.*;
import com.kaze.models.Command;
import com.kaze.models.Difficulty;
import com.kaze.models.Gesture;

import java.util.*;

public class Game {

    public static final Scanner SCANNER = new Scanner(System.in);

    // will store some settings here too
    public static final List<Gesture> GESTURES = Arrays.asList(Gesture.ROCK, Gesture.PAPER, Gesture.SCISSOR);
    public static final List<Command> SUPPORTED_COMMANDS = Arrays.asList(Command.START, Command.EXIT, Command.DIFFICULTY);
    public static final List<Difficulty> DIFFUCULTIES = Arrays.asList(Difficulty.values());
    public static final Map<Command, Handler> HANDLERS = new HashMap<Command, Handler>()
    {{
        put(Command.START, new RoundHandler());
        put(Command.EXIT, new ExitHandler());
        put(Command.STATS, new StatisticsHandler());
        put(Command.DIFFICULTY, new DifficultyHandler());
        put(Command.ERROR, new ErrorHandler());
    }};

    public static final Map<Difficulty, AiStrategy> DIFFICULTY_STRATEGIES = new HashMap<Difficulty, AiStrategy>()
    {{
        put(Difficulty.EASY, new EasyAiStrategy());
        put(Difficulty.NORMAL, new NormalAiStrategy());
        put(Difficulty.HARD, new HardAiStrategy());
    }};

    private static Difficulty gameDifficulty = Difficulty.NORMAL;

    public static AiStrategy getCurrentAiStrategy() {
        return DIFFICULTY_STRATEGIES.get(getGameDifficulty());
    }

    public static void greetings() {
        tellToUser("Hello, this is simple rock-paper-scissor game. Here is all supported commands: " + SUPPORTED_COMMANDS);
        tellToUser("Use r p s shortcuts for rock, paper, scissor");
    }

    public void runCLI() {
        while (true) {
            tellToUser("Main menu.");
            final String message = interact();
            final Command command = CommandParser.parse(message);
            HANDLERS.get(command).perform();
        }
    }

    public static String interact() {
        final String message = SCANNER.next();
        tellToUser("You said:" + message);
        return message;
    }

    public static void tellToUser(String message) {
        System.out.println(message);
    }

    public static Difficulty getGameDifficulty() {
        return gameDifficulty;
    }

    public static void setGameDifficulty(Difficulty gameDifficulty) {
        tellToUser("Game difficulty was changed to: " + gameDifficulty);
        Game.gameDifficulty = gameDifficulty;
    }
}
