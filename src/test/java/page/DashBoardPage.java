package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashBoardPage {
    private final SelenideElement dashboard = $("[data-test-id=dashboard]");

    public DashBoardPage(){
        dashboard.should(visible);
    }
}
