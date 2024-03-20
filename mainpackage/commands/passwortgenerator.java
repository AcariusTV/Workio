package mainpackage.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Random;

public class passwortgenerator extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("passwort-generieren")) {

            int length = event.getOption("länge").getAsInt();

            String password = generatePassword(length);
            EmbedBuilder b = new EmbedBuilder();
            b.setColor(Color.decode("#302c34"));
            b.setDescription("`📜`〡**DEIN SICHERES, NEUES PASSWORT** \n" +
                    "\uD804\uDC49 Hier ist dein **sicheres, neues Passwort**: ||" +  password + "||. Bewahre es **sicher auf** und zeige es **niemand anderem**!");

            event.replyEmbeds(b.build()).setEphemeral(true).queue();

        }

    }

    public static String generatePassword(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }

        return sb.toString();
    }

}
