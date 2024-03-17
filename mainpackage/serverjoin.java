package mainpackage;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class serverjoin extends ListenerAdapter {

    @Override
    public void onGuildJoin(GuildJoinEvent event) {

        Guild guild = event.getGuild();
        List<TextChannel> channels = guild.getTextChannels();

        TextChannel randomChannel = getRandomChannel(channels);
        EmbedBuilder b = new EmbedBuilder();
        b.setColor(Color.decode("#302c34"));
        b.setDescription("`👋`〡**HALLO, ICH BIN WORKIO!** \n" +
                "\uD804\uDC49 Danke, dass **du mich** eingeladen hast! Ich werde mein **bestes geben**, diesen Server zu verbessern. \n" +
                "\n" +
                "\uD804\uDC49 Bevor wir jedoch **anfangen können**, würde ich dich einmal bitten, mir die **höchst mögliche Rolle** von allen zu geben, damit jeder **Befehl** einwandfrei funktioniert! Bitte sei **vorsichtig** mit **Berechtigungen**, da bei **möglichen Hacks** Sicherheitslücken bestehen würden. \n" +
                "\n" +
                "\uD804\uDC49 Du kannst **jederzeit** mit dem Command </help:1218532814027358279> auch auf eine **Befehlsliste** zugreifen, falls du sie nicht **auswendig kennst**! Viel Spaß!");

        randomChannel.sendMessageEmbeds(b.build()).queue();

    }

    private static TextChannel getRandomChannel(List<TextChannel> channels) {
        if (channels.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return channels.get(random.nextInt(channels.size()));
    }

}
