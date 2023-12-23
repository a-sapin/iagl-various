import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TxtFileParser {
    public static List<Word> parseFile(String filePath) {
        List<Word> wordsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {

                if (line.trim().startsWith("//") || line.trim().startsWith(" ")) {
                    continue;
                }

                // Split the line into attributes based on the ';' separator
                String[] attributes = line.split(";");

                // Parse attributes and create Word object
                int attributeA = Integer.parseInt(attributes[0]);
                String attributeB = attributes[1];

                attributeB = attributeB.replace("\"", "");

                Word word = new Word(attributeA, attributeB);
                wordsList.add(word);
            }
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace(); // Handle exceptions according to your needs
        }

        return wordsList;
    }
}

