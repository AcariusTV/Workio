package mainpackage.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class wordcounter extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        if (event.getName().equals("wordcounter")) {

            String text = event.getOption("text").getAsString();
            int wordCount = countWords(text);
            EmbedBuilder b = new EmbedBuilder();
            b.setColor(Color.decode("#302c34"));
            b.setDescription("`📜`〡**ANZAHL DER WÖRTER** \n" +
                    "\uD804\uDC49 Die **Anzahl der Wörter** in deinem Text beträgt: `" + wordCount + "`");
            event.replyEmbeds(b.build()).setEphemeral(true).queue();

        }

    }

    private int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] words = text.split("\\s+");
        return words.length;
    }

}
