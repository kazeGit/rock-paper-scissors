package com.kaze;


import com.kaze.models.Command;

public class CommandParser
{
    public Command parse(String message)
    {
        try {
            return Command.valueOf(message.toUpperCase());
        } catch (IllegalArgumentException e)
        {
            return Command.ERROR;
        }
    }
}
