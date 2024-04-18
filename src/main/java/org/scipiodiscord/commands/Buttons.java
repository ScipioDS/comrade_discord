package org.scipiodiscord.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;
import net.dv8tion.jda.api.utils.messages.MessageCreateData;
import net.dv8tion.jda.api.utils.messages.MessageData;
import org.scipiodiscord.ICommand;

import java.util.List;

public class Buttons implements ICommand {

    @Override
    public String getName() {
        return "btn";
    }

    @Override
    public String getDescription() {
        return "buttons!";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("BTN - Question");
        eb.setDescription("Test class");

        Button yesButton = Button.danger("yes", "YES");
        Button noButton = Button.danger("no", "NO");

        MessageCreateData reply = new MessageCreateBuilder()
                .setEmbeds(eb.build())
                .setActionRow(yesButton, noButton)
                .build();

        event.reply(reply).queue();
    }
}
