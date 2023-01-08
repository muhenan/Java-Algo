package Company.Cambly;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ProgrammingExercise {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Company/Cambly/text.txt");
        Scanner input = new Scanner(file);

        StringBuffer sb = new StringBuffer();
        while (input.hasNext()) {
            String text = input.nextLine();
            sb.append(text);
            sb.append(' ');
        }

        // The \\W+ will match all non-alphabetic characters occurring one or more times.
        String[] words = sb.toString().split("\\W+");

        HashMap<String, Integer> records = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                word = word.toLowerCase();
                records.put(word, records.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(records.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue() - o1.getValue() != 0) return o2.getValue() - o1.getValue();
                String word1 = o1.getKey();
                String word2 = o2.getKey();
                int lengOfWord1 = word1.length();
                int lengOfWord2 = word2.length();
                int maxLength = Math.max(lengOfWord1, lengOfWord2);
                for (int i = 0; i < maxLength; i++) {
                    if (i >= lengOfWord1) return -1;
                    if (i >= lengOfWord2) return 1;
                    if (word1.charAt(i) < word2.charAt(i)) return -1;
                    if (word1.charAt(i) > word2.charAt(i)) return 1;
                }
                return -1;
            }
        });

        input.close();
    }
}
