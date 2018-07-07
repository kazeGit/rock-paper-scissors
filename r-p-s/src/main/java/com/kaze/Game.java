package com.kaze;

import com.kaze.handlers.*;
import com.kaze.models.Command;
import com.kaze.models.Move;

import java.security.SecureRandom;
import java.util.*;


/**
 * Hello world!
 *
 */
public class Game
{
    public static void main( String[] args )
    {
        greetings();

        runCLI();
    }

    public static final List<Move> MOVES = Arrays.asList(Move.ROCK, Move.PAPER, Move.SCISSOR);
    public static final List<Command> COMMANDS = Arrays.asList(Command.START, Command.EXIT, Command.STATS);
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Map<Command, Handler> HANDLERS = new HashMap<Command, Handler>()
    {{
        put(Command.START, new StartHandler());
        put(Command.EXIT, new ExitHandler());
        put(Command.STATS, new StatisticsHandler());
        put(Command.ERROR, new ErrorHandler());
    }};

    public static void greetings() {
        tellToUser("Hello, this is simple rock-paper-scissor game. Here is all supported commands: " + COMMANDS + "\n");
    }

    public static void runCLI()
    {
        CommandParser parser = new CommandParser();
        while (true)
        {
            final String message = interact();
            final Command parse = parser.parse(message);
            HANDLERS.get(parse).perform();
        }
    }

    public static String interact() {

        final String command = SCANNER.next();
        tellToUser("You said:" + command + "\n" );
        return command;
    }

    public static Move getRandomMove() {

        return MOVES.get(new SecureRandom().nextInt(3));
    }

    public static void tellToUser(String message) {

        System.out.printf(message);
    }
}
