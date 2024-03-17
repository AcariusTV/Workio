package mainpackage.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.PrivateChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class erinnerung extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("neue-erinnerung")) {

            int timeInMinutes = event.getOption("dauer").getAsInt();
            String erinnerung = event.getOption("erinnerung").getAsString();
            int timeInSeconds = timeInMinutes * 60;

            // Prüfen, ob die Dauer die maximal erlaubte Zeit überschreitet
            if (timeInMinutes > 1440) { // 120 Minuten entsprechen 2 Stunden
                EmbedBuilder errorEmbed = new EmbedBuilder();
                errorEmbed.setColor(Color.decode("#302c34"));
                errorEmbed.setDescription("`❌`〡**FEHLER!** \n" +
                        "\uD804\uDC49 Die maximale Dauer für eine Erinnerung beträgt 2 Stunden.");

                event.replyEmbeds(errorEmbed.build()).setEphemeral(true).queue();
                return;
            }

            EmbedBuilder successEmbed = new EmbedBuilder();
            successEmbed.setColor(Color.decode("#302c34"));
            successEmbed.setDescription("`🔔`〡**DU HAST EINE ERINNERUNG GESETZT!** \n" +
                    "\uD804\uDC49 Du hast **erfolgreich** eine **Erinnerung** gesetzt! \n" +
                    "\uD804\uDC49 **Erinnerung**: `" + erinnerung + "` \n" +
                    "\uD804\uDC49 **Du wirst erinnert in**: `" + timeInMinutes + " Minute/n`");

            event.replyEmbeds(successEmbed.build()).setEphemeral(true).queue();

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    EmbedBuilder reminderEmbed = new EmbedBuilder();
                    reminderEmbed.setColor(Color.decode("#302c34"));
                    reminderEmbed.setDescription("`🔔`〡**DEINE ERINNERUNG!** \n" +
                            "\uD804\uDC49 **Achtung**! Deine Erinnerung! \n" +
                            "\uD804\uDC49 **Erinnerung**: `" + erinnerung + "`");

                    PrivateChannel privateChannel = event.getMember().getUser().openPrivateChannel().complete();
                    privateChannel.sendMessageEmbeds(reminderEmbed.build()).queue();
                }
            }, timeInSeconds * 1000);

        }

    }
}

