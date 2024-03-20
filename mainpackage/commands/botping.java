package mainpackage.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class botping extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("bot-ping")) {

            EmbedBuilder b = new EmbedBuilder();
            b.setColor(Color.decode("#302c34"));
            b.setDescription("`🔔`〡**DER BOT-PING** \n" +
                    "\uD804\uDC49 Pong! Der **aktuelle Bot-Ping** ist `"+  event.getJDA().getGatewayPing() + "ms`!");

            event.replyEmbeds(b.build()).setEphemeral(true).queue();

        }

    }
}
