import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //original GPT value//
        String filePath = "path/to/your/file.txt";

        filePath = "20231207-LEXICALNET-JEUXDEMOTS-ENTRIES-MWE.txt";
        TxtFileParser newParser = new TxtFileParser();
        List<Word> wordsList = newParser.parseFile(filePath);

        // Print the parsed words
        for (Word word : wordsList) {
            System.out.println(word);
        }

        System.out.println("\t > Ok, finished building the word list!");
        String ss = "chat de gouttière";
        String ss2 = "miroir au plafond";
        String ss3 = "Rayon de la Terre";
        System.out.println("Recherche d'ID pour mot \'"+ss+"\' :"+returnIDforWord(ss, wordsList));
        System.out.println("Recherche d'ID pour mot \'"+ss2+"\' :"+returnIDforWord(ss2, wordsList));
        System.out.println("Recherche d'ID pour mot \'"+ss3+"\' :"+returnIDforWord(ss3, wordsList));


        System.err.println("=== DEUXIEME METHODE ===");
        Map<String, Word> hashWords = new HashMap<String, Word>();
        System.out.println("Building [...]");
        for (Word ww : wordsList)
        {
            hashWords.put(ww.getWordString(), ww);
        }

        System.out.println("HashMap finished!");
        System.out.println("Recherche d'ID pour mot \'"+ss+"\' :"+returnIDforHash(ss, hashWords));
        System.out.println("Recherche d'ID pour mot \'"+ss2+"\' :"+returnIDforHash(ss2, hashWords));
        System.out.println("Recherche d'ID pour mot \'"+ss3+"\' :"+returnIDforHash(ss3, hashWords));


    }


    static int returnIDforWord(String word, List<Word> wws)
    {
        long startTime = System.nanoTime();
        Boolean found = false;
        int ind = 0;
        while (found == false && ind < wws.size())
        {
            if (wws.get(ind).getWordString().equals(word))
            {
                long endTime = System.nanoTime() - startTime;
                System.out.println("> returnIDforWord exec time  for "+word+": "+endTime+" ns");
                return wws.get(ind).getID();
            }
            ind++;
        }
        System.err.println("WORD "+word+" NOT FOUND.");
        long endTime = System.nanoTime() - startTime;
        System.out.println("> returnIDforWord for "+word+" exec time : "+endTime+" ns");
        return -1;
    }

    static int returnIDforHash(String word, Map<String, Word> wordMap) {
        long startTime = System.nanoTime();

        if (wordMap.containsKey(word)) {
            int id = wordMap.get(word).getID();
            long endTime = System.nanoTime() - startTime;
            System.out.println("> returnIDforWord exec time for " + word + ": " + endTime + " ns");
            return id;
        } else {
            System.err.println("WORD " + word + " NOT FOUND.");
            long endTime = System.nanoTime() - startTime;
            System.out.println("> returnIDforWord for " + word + " exec time: " + endTime + " ns");
            return -1;
        }
    }
}