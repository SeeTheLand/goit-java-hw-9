package user;

import java.io.File;

public class UserSetializerTest {
    public static void main(String[] args) {
        File from = new File("files/user/file.txt");
        File to = new File("files/user/user.json");
        UserSetializer us = new UserSetializer(from, to);
    }
}
