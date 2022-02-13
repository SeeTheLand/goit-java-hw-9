package phone;

import java.io.File;
import java.io.IOException;

public class PhoneNumberValidatorTest {
    public static void main(String[] args) throws IOException {
        File file = new File("files/phone/file.txt");
        PhoneNumberValidator validator = new PhoneNumberValidator(file);
        validator.validate();
    }
}
