package mainpackage.helpmenü;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.*;

public class helpmenü extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        if (event.getName().equals("help")) {

            EmbedBuilder b = new EmbedBuilder();
            b.setColor(Color.decode("#302c34"));
            b.setDescription("`💭`〡**HILFEMENÜ** \n" +
                    "\uD804\uDC49 Herzlich Willkommen im **Hilfsmenü** von Workio! Hier findest du **alle wichtigen Sachen** wie die **Dokumentation** oder den **Update-Katalog**. \n" +
                    "\n" +
                    "\uD804\uDC49 Um etwas davon **aufzurufen**, klicke auf den **entsprechenden Button**. Als kurze **Erinnerung**: Du kannst uns mit einer **freiwilligen** Mitgliedschaft auf [**Patreon**](https://patreon.com/user?u=122371152&utm_medium=unknown&utm_source=join_link&utm_campaign=creatorshare_creator&utm_content=copyLink) unterstützen!");

            Button dokumentation = Button.primary("dokumentation", "📝 \uD804\uDC49 DOKUMENTATION");
            Button credits = Button.primary("credits", "✨ \uD804\uDC49 CREDITS");
            Button updatekatalog = Button.primary("updatekatalog", "🔥 \uD804\uDC49 UPDATE-KATALOG");

            event.replyEmbeds(b.build()).setEphemeral(true).setActionRow(dokumentation, credits, updatekatalog).queue();

        }

    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {

        if (event.getButton().getId().equals("dokumentation")) {

            EmbedBuilder b = new EmbedBuilder();
            b.setColor(Color.decode("#302c34"));
            b.setDescription("`📝`〡**DOKUMENTATION** \n" +
                    "\uD804\uDC49 Herzlich Willkommen in der **Dokumentation** von Workio! Hier findest du **alle wichtigen Commands, Einheiten usw.**. \n" +
                    "\n" +
                    "`🛠️`〡**COMMANDS** \n" +
                    "\uD804\uDC49 Hier findest du **alle Commands**, die der **Bot besitzt**. Sie sind für **alle Nutzer** auf diesem Server verfügbar. \n" +
                    "\n" +
                    "\uD804\uDC49 </help:1218532814027358279> - Ruft das **Hilfemenü** mit der **Dokumentation**, **Credits** & dem **Updatekatalog** auf. \n" +
                    "\uD804\uDC49 </neue-erinnerung:1217451706585976882> - Erstellt eine **neue Erinnerung** mit einer **Dauer & Text**. \n" +
                    "\uD804\uDC49 </passwort-generieren:1217481456973119540> - Generiert eine **neues Passwort** mit einer **bestimmten Länge**. \n" +
                    "\uD804\uDC49 </stoppuhr-starten:1217489125989548104> - Startet eine **Stoppuhr**, die mit einem **Buttonklick** beendet werden kann. \n" +
                    "\n" +
                    "`📰`〡**EINFÜHRUNG** \n" +
                    "\uD804\uDC49 Der Bot **Workio** ist speziell erstellt worden, um **Arbeit** auf Discord zu erleichtern. Er bietet eine **breite Auswahlmöglichkeit** von **hilfreichen Commands** für deinen Discord Server. In neueren **Versionen** werden Bots außerdem **Privat** einsetzbar sein, in z.b **DM's**. Zudem ist unser [**Bot-Code**](https://github.com/AcariusTV/Workio) öffentlich - jeder kann auf ihn **zugreifen**. Dies fördert uns in dem Sinne, da wir **sehr transparent** sein wollen. \n" +
                    "\n" +
                    "`❌`〡**PROBLEME** \n" +
                    "\uD804\uDC49 Falls du **Probleme** mit dem Bot haben solltest, wende dich bitte an unsere **Business-Email** (`workio-business@web.de`) oder öffne ein **Ticket** auf unserem [**Support-Server**](https://discord.gg/ZcenXZaj). Das **Support-Team** wird dir umgehend antworten. \n" +
                    "\n" +
                    "`✨`〡**COMMUNITY & ERWEITERBARKEIT** \n" +
                    "\uD804\uDC49 Uns seit ihr **sehr wichtig**, weshalb ihr über den **Bot mitentscheiden** dürft. Auf unserem **Support-Server** könnt ihr **Ideen** für **Commands etc.** einreichen. Dadurch dass unser [**Code öffentlich ist**](https://github.com/AcariusTV/Workio), kannst du auch **eigene Erweiterungen** programmieren und mit diesen und **unserem Code** einen eigenen Discord-Bot erstellen oder **sie an uns weiterleiten**. \n" +
                    "\n" +
                    "`📋`〡**URHEBERRECHTE & LIZENZEN** \n" +
                    "\uD804\uDC49 Du kannst den [**Workio-Source-Code**](https://github.com/AcariusTV/Workio) unter der [**Creative Commons CC BY-SA**](https://de.wikipedia.org/wiki/Creative_Commons) Lizenz nutzen. Du kannst den **Code** für deine eigenen Projekte benutzen, bist jedoch **dazu verpflichtet**, immer **Änderungen vorzunehmen** und darfst nichts **1 zu 1** kopieren. Die **Texte im Bot-Code** sind jedoch **urheberrechtlich** geschützt, was heißt, dass du sie **weden kopieren & nutzen** noch **abändern & nutzen** darfst. Falls du eine **andere Lizenz** haben möchtest, solltest du dich **auf unserem Patreon** erkunden. \n" +
                    "\n" +
                    "`🔥`〡**VERSIONSHINWEISE** \n" +
                    "\uD804\uDC49 **Workio** befindet sich aktuell in der **Version** `v.0.2 Alpha`. Alle **Updates** wirst du in dem **Updatekatalog** im **Hilfemenü** sehen.");

            event.replyEmbeds(b.build()).setEphemeral(true).queue();

        }

    }
}
