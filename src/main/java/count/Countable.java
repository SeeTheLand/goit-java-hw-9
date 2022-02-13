package count;

import java.io.File;
import java.util.Map;

public interface Countable {
    Map<String, Long> count(File input);
    void display();
}
