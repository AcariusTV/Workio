package mainpackage.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class stoppuhr extends ListenerAdapter {

    EmbedBuilder b = new EmbedBuilder();
    private final Map<Long, Instant> stopwatchStartTimes = new HashMap<>();

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        if (event.getButton().getId().equals("stoppuhrstoppen")) {
            Instant startTime = stopwatchStartTimes.get(event.getUser().getIdLong());
            if (startTime != null) {
                Duration elapsedTime = Duration.between(startTime, Instant.now());

                b.setColor(Color.decode("#302c34"));
                b.setDescription("`🛠️`〡**STOPPUHR GESTOPPT** \n" +
                        "\uD804\uDC49 Du hast die **Stoppuhr** gestoppt und es steht **darauf**: `" + formatDuration(elapsedTime) + "`");

                event.editMessageEmbeds(b.build()).setComponents().queue();
            }
        }
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("stoppuhr-starten")) {
            b.setColor(Color.decode("#302c34"));
            b.setDescription("`⏱️`〡**STOPPUHR** \n" +
                    "\uD804\uDC49 Du hast **eine Stoppuhr** gestartet!");

            Button stoppuhrstoppen = Button.danger("stoppuhrstoppen", "🛠️ \uD804\uDC49 STOPPEN");
            Instant startTime = Instant.now();
            event.replyEmbeds(b.build()).addActionRow(stoppuhrstoppen).setEphemeral(true).queue();

            // Speichern der Startzeit
            stopwatchStartTimes.put(event.getUser().getIdLong(), startTime);
        }
    }

    private String formatDuration(Duration duration) {
        long seconds = duration.getSeconds();
        long absSeconds = Math.abs(seconds);
        String positive = String.format(
                "%d Stunden, %d Minuten, %d Sekunden",
                absSeconds / 3600,
                (absSeconds % 3600) / 60,
                absSeconds % 60);
        return seconds < 0 ? "-" + positive : positive;
    }
}
