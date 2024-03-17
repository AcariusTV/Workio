package mainpackage.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class passwortgenerator extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("passwort-generieren")) {

            int length = event.getOption("länge").getAsInt();

            String password = generatePassword(length);
            event.reply("\uD804\uDC49 Dein **generiertes, sicheres** Passwort lautet: ||" + password + "||. Bewahre es **sicher auf** und teile es mit **niemand anderem**.").setEphemeral(true).queue();

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
