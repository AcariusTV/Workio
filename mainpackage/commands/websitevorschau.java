package mainpackage.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.awt.*;
import java.io.IOException;

public class websitevorschau extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        if (event.getName().equals("website-vorschau")) {

            String url = event.getOption("url").getAsString();

            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "http://" + url;
            }

            try {
                Document doc = Jsoup.connect(url).get();
                String title = doc.title();
                String imageUrl = doc.select("meta[property=og:image]").attr("content");
                String description = doc.select("meta[property=og:description]").attr("content");

                EmbedBuilder b = new EmbedBuilder();
                b.setColor(Color.decode("#302c34"));
                b.setImage(imageUrl);
                b.setDescription("`🚀`〡**" + title + "** \n" +
                        "\uD804\uDC49 " + description);

                event.replyEmbeds(b.build()).setEphemeral(true).queue();

            } catch (IOException e) {
                EmbedBuilder b = new EmbedBuilder();
                b.setColor(Color.decode("#302c34"));
                b.setDescription("`❌`〡**FEHLER** \n" +
                        "\uD804\uDC49 Fehler beim **Laden der Website**. Bitte öffne ein **Support-Ticket** oder versuche es **erneut**.");

                event.replyEmbeds(b.build()).setEphemeral(true).queue();
                e.printStackTrace();
            }

        }

    }
}
