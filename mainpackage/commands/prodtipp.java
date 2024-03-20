package mainpackage.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Random;

public class prodtipp extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

        if (event.getName().equals("produktivitäts-tipp")) {

            String allProdTipps = "Prioritäten setzen: Konzentriere dich auf die wichtigsten Aufgaben zuerst.\nZeitblöcke nutzen: Plane feste Zeiten für spezifische Aufgaben ein, um Ablenkungen zu minimieren.\nPausen einlegen: Regelmäßige kurze Pausen können die Produktivität steigern und die Konzentration verbessern.\nMultitasking vermeiden: Fokussiere dich auf eine Aufgabe gleichzeitig, um Effizienz zu steigern.\nTo-Do-Listen verwenden: Halte deine Aufgabenliste organisiert und priorisiert, um den Überblick zu behalten.\nAblenkungen minimieren: Schalte Benachrichtigungen aus und schaffe eine ruhige Arbeitsumgebung.\nDelegieren: Übertrage Aufgaben, die andere genauso gut erledigen können, um Zeit zu sparen.\nTechnologie nutzen: Entdecke Tools und Apps, die deine Produktivität unterstützen, z.B. Kalender-Apps oder Projektmanagement-Tools.\nRoutinen etablieren: Schaffe feste Arbeitsroutinen, um in einen produktiven Flow zu kommen.\nSelbstpflege nicht vergessen: Achte auf ausreichend Schlaf, Ernährung und Bewegung, um deine Energie und Produktivität zu erhalten.";

            // Trenne den String in Tipps anhand des Zeilenumbruchs
            String[] tippsArray = allProdTipps.split("\n");

            // Wähle einen zufälligen Index aus
            Random rand = new Random();
            int randomIndex = rand.nextInt(tippsArray.length);

            // Gib den zufälligen Tipp aus
            String randomTipp = tippsArray[randomIndex];
            EmbedBuilder b = new EmbedBuilder();
            b.setColor(Color.decode("#302c34"));
            b.setDescription("`📖`〡**PRODUKTIVITÄTSTIPP** \n" +
                    "\uD804\uDC49 Dein **Random-Produktivitätstipp** lautet: `" + randomTipp + "`");
            event.replyEmbeds(b.build()).setEphemeral(true).queue();

        }

    }
}
