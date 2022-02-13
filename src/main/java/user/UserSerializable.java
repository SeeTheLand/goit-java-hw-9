package user;

import java.io.File;
import java.util.List;

public interface UserSerializable {
    void transfer(File from, File to);
    List<User> readFromFile(File file);
    void writeToFile(List<User> users, File file);
}
