package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClientPage extends BasePage{
    private final String URL = "/clients/manage";
    private By expandSearchButtonSelector = By.id("searchbtn");
    private By companyNameFieldSelector = By.name("fnm");
    private By triggerSearchButtonSelector = By.name("s");
    private By emptyListMessageSelector = By.id("emptylist");
    private By resultTableSelector = By.id("fakturi_table");


    public ClientPage(WebDriver driver) {
        super(driver);
    }


    public ClientPage goTo(){
        navigateTo(URL);
        return this;
    }

    public ClientPage searchByCompanyName(String companyName){
        expandSearchForm()
                .enterCompanyName(companyName)
                .triggerSearch();
        return this;
    }

    private ClientPage expandSearchForm(){
        press(expandSearchButtonSelector, "expand search form button");
        return this;
    }

    private ClientPage enterCompanyName(String name){
        type(companyNameFieldSelector, name);
        return this;
    }

    private ClientPage triggerSearch(){
        press(triggerSearchButtonSelector, "search button");
        return this;
    }

    public String getEmptyListMessage(){
       return getText(emptyListMessageSelector);
    }

    public String getResultTableInfo(){
        return getText(resultTableSelector);
    }
}
