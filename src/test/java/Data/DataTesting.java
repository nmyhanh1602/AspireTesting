package Data;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DataTesting {
    public static String getRandomUnique() {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMMhhmmss");
        String strDate = formatter.format(new Date());
        return strDate.concat(getRandomNumber());
    }

    /**
     * Generate Random number with 8 digits length.
     */
    public static String getRandomNumber() {
        Random random = new Random();
        return String.valueOf(10000000 + random.nextInt(90000000));
    }

    public static String getRandomFullName() {
        Faker faker = new Faker();
        return faker.name().fullName();
    }

    public static String getRandomEmail() {
        return "auto" + DataTesting.getRandomUnique() + "@hotmail.com";
    }

}
