package mainpackage;

import mainpackage.commands.*;
import mainpackage.helpmenü.helpmenü;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class main {

    public static void main(String[] args) {

        //SETUP
        String TOKEN = "MTIxNzM4NjM2OTcyMzI3MzIyNg.Gik4hO.F42iVbYvXtW7iX3J8qrRNg1WiTfnOzfKclIfaE";
        JDABuilder builder = JDABuilder.createDefault(TOKEN, GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.DIRECT_MESSAGE_TYPING, GatewayIntent.DIRECT_MESSAGE_REACTIONS)
                .disableCache(CacheFlag.VOICE_STATE, CacheFlag.EMOJI, CacheFlag.CLIENT_STATUS);

        //ACTIVITY
        builder.setActivity(Activity.customStatus("/help für Hilfe :)"));

        //EVENT-LISTENERS
        builder.addEventListeners(new serverjoin());
        builder.addEventListeners(new erinnerung());
        builder.addEventListeners(new passwortgenerator());
        builder.addEventListeners(new stoppuhr());
        builder.addEventListeners(new helpmenü());
        builder.addEventListeners(new botping());
        builder.addEventListeners(new pomodorotimer());
        builder.addEventListeners(new tageszitat());
        builder.addEventListeners(new prodtipp());
        builder.addEventListeners(new wordcounter());
        builder.addEventListeners(new hyperlinkgenerator());
        builder.addEventListeners(new websitevorschau());

        JDA jda = builder.build();

        //COMMANDS
        jda.updateCommands().addCommands(
                Commands.slash("help", "\uD804\uDC49 Rufe das Hilfsmenü auf."),
                Commands.slash("neue-erinnerung", "\uD804\uDC49 Setze eine Erinnerung.")
                        .addOption(OptionType.INTEGER, "dauer", "\uD804\uDC49 Dauer, wann du erinnert werden möchtest (In Minuten).", true)
                        .addOption(OptionType.STRING, "erinnerung", "\uD804\uDC49 An was möchtest du erinnert werden?", true),
                Commands.slash("passwort-generieren", "\uD804\uDC49 Generiere ein Passwort.")
                        .addOption(OptionType.INTEGER, "länge", "\uD804\uDC49 Die Länge des Passworts.", true),
                Commands.slash("stoppuhr-starten", "\uD804\uDC49 Starte eine Stoppuhr."),
                Commands.slash("bot-ping", "\uD804\uDC49 Erhalte den Bot-Ping."),
                Commands.slash("start-pomodoro", "\uD804\uDC49 Starte einen Pomodoro-Timer.")
                        .addOption(OptionType.INTEGER, "arbeitszeit", "\uD804\uDC49 Deine Arbeitszeit (In Minuten).", true)
                        .addOption(OptionType.STRING, "pausenzeit", "\uD804\uDC49 Deine Pausenzeit (In Minuten)", true),
                Commands.slash("tageszitat", "\uD804\uDC49 Schaue dir das motivierende Tagszitat an."),
                Commands.slash("produktivitäts-tipp", "\uD804\uDC49 Schaue dir einen zufälligen Produktivitätstipp an."),
                Commands.slash("wordcounter", "\uD804\uDC49 Lass die Wörteranzahl in einem Text herausfinden.")
                        .addOption(OptionType.STRING, "text", "\uD804\uDC49 Dein Text, von dem du die Wörteranzahl herausfinden willst.", true),
                Commands.slash("hyperlink-generator", "\uD804\uDC49 Generiere einen Discord-Hyperlink.")
                        .addOption(OptionType.STRING, "text", "\uD804\uDC49 Der Text für deinen Discord-Hyperlink.", true)
                        .addOption(OptionType.STRING, "url", "\uD804\uDC49 Die URL für den Link für deinen Discord-Hyperlink.", true),
                Commands.slash("website-vorschau", "\uD804\uDC49 Generiere eine Website-Vorschau.")
                        .addOption(OptionType.STRING, "url", "\uD804\uDC49 Die Website-URL für die Website-Vorschau.", true)

        ).queue();

    }

}
