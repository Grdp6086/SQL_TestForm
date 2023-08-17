package data;

import com.beust.ah.A;
import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {

    private static final Faker faker =new Faker(new Locale("en"));

    public static AuthInfo getAuthInfo(){
        return new AuthInfo("vasya", "qwerty123");
    }

    private static String generateRandomLogin(){
        return faker.name().username();
    }

    private static String generateRandomPassword(){
        return faker.internet().password();
    }

    public static AuthInfo getRandomUser(){
        return new AuthInfo(generateRandomLogin(), generateRandomPassword());
    }

    public static AuthInfo getUserWithRandomLogin(){
        return new AuthInfo(generateRandomLogin(), "qwerty123");
    }

    public static AuthInfo getUserWithRandomPassword(){
        return new AuthInfo("vasya", generateRandomPassword());
    }



    public static VerificationCode getRandomVerificationCode(){
        return new VerificationCode(faker.numerify("######"));
    }


    @Value
    public static class AuthInfo{
        String login;
        String password;
    }
    @Value
    public static class VerificationCode{
        String code;
    }
}
