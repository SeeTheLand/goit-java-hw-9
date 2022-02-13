package phone;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class PhoneNumberValidator implements PhoneNumberValidated {
    private final File file;

    public PhoneNumberValidator(File file) {
        this.file = file;
    }

    @Override
    public void validate() {
        try(FileInputStream fis = new FileInputStream(file)) {
            Scanner scanner = new Scanner(fis);
            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                String pattern = "\\(\\d\\d\\d\\) \\d\\d\\d-\\d\\d\\d\\d|\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d";
                if(line.matches(pattern)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
