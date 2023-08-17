package test;

import data.DataHelper;
import data.SQLHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static data.SQLHelper.cleanDatabase;

public class LoginTest {


    @AfterAll
    public static void down(){
        cleanDatabase();
    }

    @Test
    public void shouldValidLogin(){
        var login = open("http://localhost:9999", LoginPage.class);
        var verification = login.validLogin(DataHelper.getAuthInfo());
        var smsCode = SQLHelper.getVerificationCode();
        verification.validVerify(smsCode.getCode());
    }

    @Test
    public void shouldGetErrorWithRandomUser(){
        var login = open("http://localhost:9999", LoginPage.class);
        login.validLogin(DataHelper.getRandomUser());
        login.errorNotificationShouldVisible();
    }

    @Test
    public void shouldGetErrorWithRandomLogin(){
        var login = open("http://localhost:9999", LoginPage.class);
        login.validLogin(DataHelper.getUserWithRandomLogin());
        login.errorNotificationShouldVisible();
    }

    @Test
    public void shouldGetErrorWithRandomPassword(){
        var login = open("http://localhost:9999", LoginPage.class);
        login.validLogin(DataHelper.getUserWithRandomPassword());
        login.errorNotificationShouldVisible();
    }

    @Test
    public void shouldGetErrorWithRandomVerificationCode(){
        var login = open("http://localhost:9999", LoginPage.class);
        var verification = login.validLogin(DataHelper.getAuthInfo());
        verification.verify(DataHelper.getRandomVerificationCode().getCode());
        verification.verifyErrorNotificationsShouldVisible();


    }
}
