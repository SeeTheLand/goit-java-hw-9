package user;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.*;

public class UserSetializer implements UserSerializable {

    public UserSetializer(File from, File to) {
        transfer(from, to);
    }

    //transfer from input file to the output one
    @Override
    public void transfer(File from, File to) {
        List<User> users = readFromFile(from);
        writeToFile(users, to);
    }

    //read from file
    @Override
    public List<User> readFromFile(File file) {
        List<User> users = null;
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            String name;
            int age;
            users = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] userInfo = scanner.nextLine().split(" ");
                if (!userInfo[0].equals("name") && !userInfo[1].equals("age")) {
                    String userName = userInfo[0];
                    int userAge = Integer.parseInt(userInfo[1]);
                    users.add(new User(userName, userAge));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    //write to the prescribed file
    @Override
    public void writeToFile(List<User> users, File file) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonForExport = gson.toJson(users);
        try(FileWriter writer = new FileWriter(file)) {
            writer.write(jsonForExport);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
