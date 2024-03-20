package mainpackage.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.util.Random;

public class tageszitat extends ListenerAdapter {

    private final String allQuotes = "Der einzige Weg zum Erfolg führt durch harte Arbeit.\nJeder Tag ist eine neue Chance, deinen Träumen ein Stück näher zu kommen.\nErfolg ist die Summe kleiner Anstrengungen, die jeden Tag wiederholt werden.\nDie größten Erfolge kommen oft aus den größten Enttäuschungen.\nDas Geheimnis des Erfolgs liegt darin, anzufangen.\nGib niemals auf. Große Dinge brauchen Zeit.\nTräume groß, arbeite hart, bleibe demütig.\nDas größte Hindernis auf dem Weg zum Erfolg ist die Angst vor dem Versagen.\nErfolg kommt zu denen, die hart arbeiten und niemals aufgeben.\nDenke groß, arbeite hart, bleibe fokussiert und bleibe demütig.\nDie einzige Grenze für unseren Erfolg liegt in unserer Vorstellungskraft.\nEs gibt keine Abkürzung zum Erfolg. Es erfordert harte Arbeit und Hingabe.\nJeder Rückschlag ist eine Gelegenheit, stärker zurückzukommen.\nErfolg ist eine Reise, kein Ziel. Genieße den Weg.\nDu bist stärker, als du denkst. Glaube an dich selbst und deine Fähigkeiten.";

    private String currentQuote;
    private LocalDate lastQuoteDate;

    private final String quoteFilePath = "C:\\Bots\\Workio\\quote.txt";

    public tageszitat() {
        // Beim Erstellen der Instanz das Zitat aus der Datei laden
        loadQuoteFromFile();
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("tageszitat")) {
            String quote = getCurrentQuote();
            EmbedBuilder b = new EmbedBuilder();
            b.setColor(Color.decode("#302c34"));
            b.setDescription("`🔔`〡**ZITAT DES TAGES** \n" +
                    "\uD804\uDC49 Das **Zitat des Tages** lautet: `" + quote + "`");
            event.replyEmbeds(b.build()).setEphemeral(true).queue();
        }
    }

    private String getCurrentQuote() {
        LocalDate today = LocalDate.now();
        // Prüfen, ob ein neues Zitat für heute ausgewählt werden muss
        if (lastQuoteDate == null || !lastQuoteDate.equals(today)) {
            lastQuoteDate = today;
            currentQuote = getRandomQuote();
            // Zitat in die Datei schreiben
            saveQuoteToFile();
        }
        return currentQuote;
    }

    private String getRandomQuote() {
        String[] quotesArray = allQuotes.split("\n");
        Random random = new Random();
        int randomIndex = random.nextInt(quotesArray.length);
        return quotesArray[randomIndex];
    }

    private void saveQuoteToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(quoteFilePath))) {
            writer.println(currentQuote);
            writer.println(lastQuoteDate.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadQuoteFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(quoteFilePath))) {
            String quote = reader.readLine();
            String lastDateStr = reader.readLine();
            if (quote != null && lastDateStr != null) {
                currentQuote = quote;
                lastQuoteDate = LocalDate.parse(lastDateStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
