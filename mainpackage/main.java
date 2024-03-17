package mainpackage;

import mainpackage.commands.erinnerung;
import mainpackage.commands.passwortgenerator;
import mainpackage.commands.stoppuhr;
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
        String TOKEN = "";
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

        JDA jda = builder.build();

        //COMMANDS
        jda.updateCommands().addCommands(
                Commands.slash("help", "\uD804\uDC49 Rufe das Hilfsmenü auf."),
                Commands.slash("neue-erinnerung", "\uD804\uDC49 Setze eine Erinnerung.")
                        .addOption(OptionType.INTEGER, "dauer", "\uD804\uDC49 Dauer, wann du erinnert werden möchtest (In Minuten).", true)
                        .addOption(OptionType.STRING, "erinnerung", "\uD804\uDC49 An was möchtest du erinnert werden?", true),
                Commands.slash("passwort-generieren", "\uD804\uDC49 Generiere ein Passwort.")
                        .addOption(OptionType.INTEGER, "länge", "\uD804\uDC49 Die Länge des Passworts.", true),
                Commands.slash("stoppuhr-starten", "\uD804\uDC49 Starte eine Stoppuhr.")

        ).queue();

    }

}
