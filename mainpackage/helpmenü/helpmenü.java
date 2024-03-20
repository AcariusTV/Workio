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
                    "\uD804\uDC49 Um etwas davon **aufzurufen**, klicke auf den **entsprechenden Button**. Als kurze **Erinnerung**: Du kannst uns mit einer **freiwilligen** Mitgliedschaft auf [**Ko-fi**](https://ko-fi.com/workio) unterstützen!");

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
                    "\uD804\uDC49 </bot-ping:1218951121813508157> - Zeigt dir, was für ein **Ping** der Bot gerade hat. \n" +
                    "\uD804\uDC49 </start-pomodoro:1218965314520354907> - Startet einen **Pomodoro-Timer**. \n" +
                    "\uD804\uDC49 </tageszitat:1219333287554846793> - Zeigt dir das **aktuelle Tageszitat**. \n" +
                    "\uD804\uDC49 </produktivitäts-tipps:1219719145881469122> - Zeigt dir einen **zufälligen Produktivitätstipp**. \n" +
                    "\uD804\uDC49 </wordcounter:1219721022287249468> - Lässt dir die **Anzahl der Wörter** in einem **bestimmten Text** anzeigen. \n" +
                    "\uD804\uDC49 </hyperlink-generator:1219983651115372566> - Generiert einen **persönlichen Hyperlink**. \n" +
                    "\uD804\uDC49 </website-vorschau:1219986554693357661> - Zeigt dir eine **Vorschau** einer Website. \n" +
                    "\n" +
                    "`📰`〡**EINFÜHRUNG** \n" +
                    "\uD804\uDC49 Der Bot **Workio** ist speziell erstellt worden, um **Arbeit** auf Discord zu erleichtern. Er bietet eine **breite Auswahlmöglichkeit** von **hilfreichen Commands** für deinen Discord Server. In neueren **Versionen** werden Bots außerdem **Privat** einsetzbar sein, in z.b **DM's**. Zudem ist unser [**Bot-Code**](https://github.com/AcariusTV/Workio) öffentlich - jeder kann auf ihn **zugreifen**. Dies fördert uns in dem Sinne, da wir **sehr transparent** sein wollen. \n" +
                    "\n" +
                    "`❌`〡**PROBLEME** \n" +
                    "\uD804\uDC49 Falls du **Probleme** mit dem Bot haben solltest, wende dich bitte an unsere **Business-Email** (`workio-business@web.de`) oder öffne ein **Ticket** auf unserem [**Support-Server**](https://discord.gg/ahMgMq42NT). Das **Support-Team** wird dir umgehend antworten. \n" +
                    "\n" +
                    "`✨`〡**COMMUNITY & ERWEITERBARKEIT** \n" +
                    "\uD804\uDC49 Uns seit ihr **sehr wichtig**, weshalb ihr über den **Bot mitentscheiden** dürft. Auf unserem **Support-Server** könnt ihr **Ideen** für **Commands etc.** einreichen. Dadurch dass unser [**Code öffentlich ist**](https://github.com/AcariusTV/Workio), kannst du auch **eigene Erweiterungen** programmieren und mit diesen und **unserem Code** einen eigenen Discord-Bot erstellen oder **sie an uns weiterleiten**. \n" +
                    "\n" +
                    "`📋`〡**URHEBERRECHTE & LIZENZEN** \n" +
                    "\uD804\uDC49 Du kannst den [**Workio-Source-Code**](https://github.com/AcariusTV/Workio) unter der [**Creative Commons CC BY-SA**](https://de.wikipedia.org/wiki/Creative_Commons) Lizenz nutzen. Du kannst den **Code** für deine eigenen Projekte benutzen, bist jedoch **dazu verpflichtet**, immer **Änderungen vorzunehmen** und darfst nichts **1 zu 1** kopieren. Die **Texte im Bot-Code** sind jedoch **urheberrechtlich** geschützt, was heißt, dass du sie **weden kopieren & nutzen** noch **abändern & nutzen** darfst. Falls du eine **andere Lizenz** haben möchtest, solltest du dich **auf unserer** [**Ko-fi Seite**](https://ko-fi.com/workio) erkunden. \n" +
                    "\n" +
                    "`🔥`〡**VERSIONSHINWEISE** \n" +
                    "\uD804\uDC49 **Workio** befindet sich aktuell in der **Version** `v.0.2 Alpha`. Alle **Updates** wirst du in dem **Updatekatalog** im **Hilfemenü** sehen.");

            event.replyEmbeds(b.build()).setEphemeral(true).queue();

        }

        if (event.getButton().getId().equals("credits")) {

            EmbedBuilder b = new EmbedBuilder();
            b.setColor(Color.decode("#302c34"));
            b.setDescription("`✨`〡**CREDITS** \n" +
                    "\uD804\uDC49 Dies sind die **Credits** des Workio-Discord-Bots. Hier findest du **Anerkennungen** & **Danksagungen**. \n" +
                    "\n" +
                    "\uD804\uDC49 `💕`-lichen Dank an [**Ko-fi**](https://ko-fi.com/workio) für die **finanzielle Unterstützung** und an <@613426474736681012> & <@1180620386333884428> zum **Testen**!");

            event.replyEmbeds(b.build()).setEphemeral(true).queue();

        }

        if (event.getButton().getId().equals("updatekatalog")) {

            EmbedBuilder b  = new EmbedBuilder();
            b.setColor(Color.decode("#302c34"));
            b.setDescription("`🔥`〡**UPDATE-KATALOG** \n" +
                    "\uD804\uDC49 Dies ist der **Update-Katalog** von dem Workio-Discord-Bot. Dieser wird **aktualisiert**, wenn der Workio-Discord-Bot **neue Updates** bekommt. \n" +
                    "\n" +
                    "\uD804\uDC49 Aktuell gibt es **keine Updates**!");

            event.replyEmbeds(b.build()).setEphemeral(true).queue();

        }

    }

}