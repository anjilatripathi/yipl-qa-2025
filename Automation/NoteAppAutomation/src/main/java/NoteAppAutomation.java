import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NoteAppAutomation
{
    public static void main(String[] args)
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/notes/app");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement register = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Create an account")));
        register.click();
        WebElement eMail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid=register-email]")));
        eMail.sendKeys("demouser21@gmail.com");
        WebElement passWord = wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid=register-password]"))));
        passWord.sendKeys("123456789");
        WebElement name = wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid=register-name]"))));
        name.sendKeys("Demo User");
        WebElement confirmPass = wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid=register-confirm-password]"))));
        confirmPass.sendKeys("123456789");
        WebElement userRegister = wait.until((ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-testid=register-submit]"))));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", userRegister);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement logIn = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Click here to Log In")));
        logIn.click();
        WebElement logMail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid=login-email]")));
        logMail.sendKeys("demouser21@gmail.com");
        WebElement logPassword = wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[data-testid=login-password]"))));
        logPassword.sendKeys("123456789");
        WebElement appLog = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-testid='login-submit']")));
        appLog.click();

        WebElement createNote = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-testid='add-new-note']")));
        createNote.click();


        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("category")));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue("Home");
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("completed")));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        WebElement title = wait.until(ExpectedConditions.elementToBeClickable(By.id("title")));
        title.sendKeys("Buy groceries");
        WebElement desc = wait.until(ExpectedConditions.elementToBeClickable(By.id("description")));
        desc.sendKeys("Purchase vegetables, fruits, and milk for the week.");
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("description")));
        submitBtn.click();


        driver.quit();

    }

}
