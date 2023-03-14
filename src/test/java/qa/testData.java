package qa;

import com.github.javafaker.Faker;


public class testData {

    static Faker faker = new Faker();

    // здесь задаем значения переменных
    static String firstName = faker.name().firstName();
    static String lastName = faker.name().lastName();
    static String userEmail = faker.internet().emailAddress();
    static String userNumber = faker.phoneNumber().subscriberNumber(10);
    static String[] subjects = {"Maths", "English", "Arts"};
    static String subject = subjects[faker.random().nextInt(subjects.length)];
    static String[] genders = {"Male", "Female", "Other"};
    static String gender = genders[faker.random().nextInt(genders.length)];
    static String[] hobbies = {"Sports", "Reading", "Music"};
    static String hobby = hobbies[faker.random().nextInt(hobbies.length)];
    static String picturePath = "Screenshot_1.png";
    static String currentAddress = faker.address().fullAddress();
    static String month = faker.options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    static String dayOfBirth = String.valueOf(faker.number().numberBetween(10, 28));
    static String yearOfBirth = String.valueOf(faker.number().numberBetween(1950, 2022));
    static String[] states = {"NCR", "Uttar Pradesh", "Haryana"};
    static String state = states[faker.random().nextInt(states.length)];
    static String city;

    static {
        switch (state) {
            case "NCR" -> {
                String[] citiesNCR = {"Delhi", "Gurgaon"};
                city = citiesNCR[faker.random().nextInt(citiesNCR.length)];
            }
            case "Uttar Pradesh" -> {
                String[] citiesUttarPradesh = {"Agra", "Merrut"};
                city = citiesUttarPradesh[faker.random().nextInt(citiesUttarPradesh.length)];
            }
            case "Haryana" -> {
                String[] citiesHaryana = {"Panipat", "Karnal"};
                city = citiesHaryana[faker.random().nextInt(citiesHaryana.length)];
            }
            default -> throw new IllegalArgumentException("Invalid state: " + state);
        }
    }
}
