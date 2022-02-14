package count;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordsCounter implements Countable {
    File file;
    Map<String, Long> resultOfCount;

    @Override
    public Map<String, Long> count(File input) {
        StringBuilder contentBuilder = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(input))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                contentBuilder.append(currentLine).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Long> unsortedMap = Arrays.stream(contentBuilder.toString().split(" "))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        resultOfCount = unsortedMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));;
        return resultOfCount;
    }

    @Override
    public void display() {
        resultOfCount = count(file);
        System.out.println("result = " + resultOfCount);
    }

    WordsCounter(File file) {
        this.file = file;
    }
}
