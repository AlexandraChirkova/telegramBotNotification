package data;

import com.github.javafaker.Faker;


public class DataGenerator {

    Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String phone = faker.phoneNumber().subscriberNumber(10);
    public String day = faker.number().numberBetween(1, 28) + "";
    public String month = faker.options().option(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    );
    public String year = faker.number().numberBetween(1950, 2010) + "";
    public String subject = faker.options().option(
            "Maths", "Accounting", "Arts", "Biology", "Chemistry", "Civics",
            "Commerce", "Computer Science", "Economics", "English",
            "Hindi", "History", "Physics", "Social Studies"
    );
    public String hobby = faker.options().option("Sports", "Reading", "Music");
    public String address = faker.address().fullAddress();
    String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    public String state = faker.options().option(states);
    public String city = getRandomCity(state);
    public String image = "images/img1.jpeg";

    public String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }

}
