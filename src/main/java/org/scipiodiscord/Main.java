package org.scipiodiscord;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.scipiodiscord.commands.Buttons;
import org.scipiodiscord.commands.QuoteGenerator;
import org.scipiodiscord.commands.Sum;

public class Main {
    public static void main(String[] args) {
        //Creates bot using token
        JDA jda = JDABuilder.createDefault(new Token().getToken()).build();
        jda.addEventListener(new Listener());

        //Initialise the Command Manager
        CommandManager commandManager = new CommandManager();
        commandManager.add(new Sum());
        commandManager.add(new Buttons());
        commandManager.add(new QuoteGenerator());

        jda.addEventListener(commandManager);
    }
}