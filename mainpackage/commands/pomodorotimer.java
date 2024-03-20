package mainpackage.commands;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class pomodorotimer extends ListenerAdapter {

    int workTime;
    int breakTime;
    Timer timer;
    EmbedBuilder currentEmbed;

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("start-pomodoro")) {
            workTime = event.getOption("arbeitszeit").getAsInt();
            breakTime = event.getOption("pausenzeit").getAsInt();

            EmbedBuilder b = new EmbedBuilder();
            b.setColor(Color.decode("#302c34"));
            b.setDescription("`🔔`〡**POMODORO-TIMER WURDE GESTARTET!** \n" +
                    "\uD804\uDC49 **Arbeitszeit**: `" + workTime + "` **Minute/n** \n" +
                    "\uD804\uDC49 **Pausenzeit**: `" + breakTime + "` **Minute/n**");
            currentEmbed = b;
            event.replyEmbeds(b.build()).setEphemeral(true).queue();

            startWorkTimer(event, workTime);
        }
    }

    private void startWorkTimer(SlashCommandInteractionEvent event, int workTime) {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                EmbedBuilder workEmbed = new EmbedBuilder();
                workEmbed.setColor(Color.decode("#302c34"));
                workEmbed.setDescription("`🔔`〡**ARBEITSZEIT VORBEI** \n" +
                        "\uD804\uDC49 Deine **Arbeitszeit** ist nun **vorbei**! Zeit für eine Pause.");
                currentEmbed = workEmbed;
                event.getHook().editOriginalEmbeds(workEmbed.build()).queue();
                startBreakTimer(event, breakTime);
            }
        }, workTime * 60000); // Convert minutes to milliseconds
    }

    private void startBreakTimer(SlashCommandInteractionEvent event, int breakTime) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                EmbedBuilder breakEmbed = new EmbedBuilder();
                breakEmbed.setColor(Color.decode("#302c34"));
                breakEmbed.setDescription("`🔔`〡**PAUSE VORBEI** \n" +
                        "\uD804\uDC49 Deine **Pause** ist nun **vorbei** und du hast wieder `" + workTime + "` **Minuten** Arbeitszeit!");
                currentEmbed = breakEmbed;
                event.getHook().editOriginalEmbeds(breakEmbed.build()).queue();
                startWorkTimer(event, workTime);
            }
        }, breakTime * 60000); // Convert minutes to milliseconds
    }
}
