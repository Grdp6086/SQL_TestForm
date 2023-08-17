package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private final SelenideElement code = $("[data-test-id='code'] input");
    private final SelenideElement actionButton = $("[data-test-id='action-verify']");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification']");
    public void verifyErrorNotificationsShouldVisible(){
        errorNotification.should(visible);
    }

    public DashBoardPage validVerify(String verificationCode){
        verify(verificationCode);
        return new DashBoardPage();
    }
    public void verify(String verificationCode){
        code.setValue(verificationCode);
        actionButton.click();
    }
}
