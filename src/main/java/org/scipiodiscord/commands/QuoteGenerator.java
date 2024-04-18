package org.scipiodiscord.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.scipiodiscord.ICommand;
import org.scipiodiscord.Listener;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuoteGenerator implements ICommand {

    static class Quote{
        public String name;
        public String quote;
        Quote(String name, String quote){
            this.name = name;
            this.quote = quote;
        }
    }

    static List<Quote> quotes;
    public QuoteGenerator(){
        quotes = new ArrayList<Quote>();

        if (quotes.isEmpty()){
            quotes.add(new Quote(
                    "Karl Marx",
                    "Greek philosophy seems to have met with something with which a" +
                            " good tragedy is not supposed to meet, namely, a dull ending."));
            quotes.add(new Quote(
                    "Karl Marx",
                    "The bureaucrat has the world as a mere object of his action."
            ));
            quotes.add(new Quote(
                    "Dom Helder Camera",
                    "When I give food to the poor, they call me a saint." +
                            " When I ask why the poor have no food, they call me a communist."
            ));
            quotes.add(new Quote(
                    "Malcolm X",
                    "You show me a capitalist, and I'll show you a bloodsucker"
            ));
            quotes.add(new Quote(
                    "Albert Einstein",
                    "The Revolution introduced me to art, and in turn, art introduced me to the Revolution!"
            ));
            quotes.add(new Quote(
                    "Vladimir Lenin",
                    "Without Revolutionary theory, there can be no Revolutionary Movement."
            ));
            quotes.add(new Quote(
                    "Vladimir Lenin",
                    "Everybody talks about imperialism. But imperialism is merely monopoly capitalism."
            ));
        }


    }
    @Override
    public String getName() {
        return "quote";
    }

    @Override
    public String getDescription() {
        return "Returns a random quote";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        Random num = new Random();
        int result = num.nextInt(quotes.size());
        Quote quote = quotes.get(result);

        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("Quote");
        builder.addField(new MessageEmbed.Field(quote.name, quote.quote, false));
        builder.setColor(Color.RED);

        event.replyEmbeds(builder.build()).queue();
    }
}
