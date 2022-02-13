package count;

import java.io.File;

public class WordsCounterTest {
    public static void main(String[] args) {
        File file = new File("files/count/words.txt");
        WordsCounter counter = new WordsCounter(file);
        counter.display();
    }
}
