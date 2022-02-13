package count;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
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
        resultOfCount = Arrays.stream(contentBuilder.toString().split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
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
