package org.scipiodiscord.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;
import org.scipiodiscord.ICommand;

import java.util.ArrayList;
import java.util.List;

public class Sum implements ICommand {

    @Override
    public String getName() {
        return "sum";
    }

    @Override
    public String getDescription() {
        return "Sum of two numbers";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> list = new ArrayList<>();
        list.add(new OptionData(OptionType.INTEGER, "number1", "The first number"));
        list.add(new OptionData(OptionType.INTEGER, "number2", "The second number"));
        return list;
    }

    @Override
    public void execute(@NotNull SlashCommandInteractionEvent event) {
        OptionMapping number1 = event.getOption("number1");
        OptionMapping number2 = event.getOption("number2");

        assert number1 != null;
        int num1 = number1.getAsInt();
        assert number2 != null;
        int num2 = number2.getAsInt();
        int result = num1 + num2;

        event.reply("Answer: " + result).queue();
    }
}
