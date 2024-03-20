package mainpackage.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class hyperlinkgenerator extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        if (event.getName().equals("hyperlink-generator")) {

            String text = event.getOption("text").getAsString();
            String url = event.getOption("url").getAsString();

            if (url.startsWith("http://") && url.startsWith("https://")) {

                EmbedBuilder b = new EmbedBuilder();
                b.setColor(Color.decode("#302c34"));
                b.setDescription("`🚀`〡**DEIN GENERIERTER HYPERLINK** \n" +
                        "\uD804\uDC49 Dein **generierter Hyperlink** lautet: `[" + text + "](" + url + ")`");

                event.replyEmbeds(b.build()).setEphemeral(true).queue();

            } else {

                EmbedBuilder b = new EmbedBuilder();
                b.setColor(Color.decode("#302c34"));
                b.setDescription("`❌`〡**FEHLER** \n" +
                        "\uD804\uDC49 Du hast keine **gültige URL** eingegeben! Versuche es **bitte erneut**.");

                event.replyEmbeds(b.build()).setEphemeral(true).queue();

            }

        }

    }
}
