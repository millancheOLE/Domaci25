/*
Testirati rad kalkulatora https://testsheepnz.github.io/BasicCalculator.html. Testirati rad svih operacija posebno.

Za njega napisati edge case-eve na koje naletite, ili ispunite neka matematicka pravila (deljenje sa nulom, jedinicom,
veliki/mali brojevi itd). Napisati minimum 4 edge case-a po testnoj metodi, 16 ukupno (minimum), zanemarujuci Concatenate.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CalculatorOperations {

    private WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\milla\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public void enterDataAdd(String firstNum, String secondNum, String expectedResult) {
        WebElement firstNumber = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        firstNumber.sendKeys(firstNum);
        WebElement secondNumber = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        secondNumber.sendKeys(secondNum);
        WebElement calculate = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculate.click();
        WebElement actualResult = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        Assert.assertEquals(actualResult.getAttribute("value"), expectedResult);
        driver.navigate().refresh();
    }

    public void enterDataSubtract(String firstNum, String secondNum, String expectedResult) {
        WebElement firstNumber = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        firstNumber.sendKeys(firstNum);
        WebElement secondNumber = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        secondNumber.sendKeys(secondNum);
        WebElement selectSubtract = driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
        Select select = new Select(selectSubtract);
        select.selectByVisibleText("Subtract");
        WebElement calculate = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculate.click();
        WebElement actualResult = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        Assert.assertEquals(actualResult.getAttribute("value"), expectedResult);
        driver.navigate().refresh();
    }

    public void enterDataMultiply(String firstNum, String secondNum, String expectedResult) {
        WebElement firstNumber = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        firstNumber.sendKeys(firstNum);
        WebElement secondNumber = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        secondNumber.sendKeys(secondNum);
        WebElement selectSubtract = driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
        Select select = new Select(selectSubtract);
        select.selectByVisibleText("Multiply");
        WebElement calculate = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculate.click();
        WebElement actualResult = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        Assert.assertEquals(actualResult.getAttribute("value"), expectedResult);
        driver.navigate().refresh();
    }

    public void enterDataDivide(String firstNum, String secondNum, String expectedResult) {
        WebElement firstNumber = driver.findElement(By.xpath("//*[@id=\"number1Field\"]"));
        firstNumber.sendKeys(firstNum);
        WebElement secondNumber = driver.findElement(By.xpath("//*[@id=\"number2Field\"]"));
        secondNumber.sendKeys(secondNum);
        WebElement selectSubtract = driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]"));
        Select select = new Select(selectSubtract);
        select.selectByVisibleText("Divide");
        WebElement calculate = driver.findElement(By.xpath("//*[@id=\"calculateButton\"]"));
        calculate.click();
        WebElement actualResult1 = driver.findElement(By.xpath("//*[@id=\"errorMsgField\"]"));
        WebElement actualResult2 = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
        if(secondNum.equals("0")) {
            Assert.assertTrue(actualResult1.isDisplayed());
        } else {
            Assert.assertEquals(actualResult2.getAttribute("value"), expectedResult);
        }
        driver.navigate().refresh();
    }

    @Test
    public void test1Add(){
        //1
        enterDataAdd("0", "0", "0");
        //2
        enterDataAdd("0", "1", "1");
        //3
        enterDataAdd("1", "0", "1");
        //4
        enterDataAdd("1", "1", "2");
        //5
        enterDataAdd("-1", "0", "-1");
        //6
        enterDataAdd("0", "-1", "-1");
        //7
        enterDataAdd("-1", "-1", "-2");
        //8
        enterDataAdd("9", "1", "10");
        //9
        enterDataAdd("10", "1", "11");
        //10
        enterDataAdd("-9", "-1", "-10");
        //11
        enterDataAdd("-10", "-1", "-11");
        //12
        enterDataAdd("999999", "2", "1000001");
        //13
        enterDataAdd("1000000", "-1000000", "0");
    }

    @Test

    public void test2Subtract(){
        //1
        enterDataSubtract("0", "0", "0");
        //2
        enterDataSubtract("0", "-1", "1");
        //3
        enterDataSubtract("1", "0", "1");
        //4
        enterDataSubtract("1", "1", "0");
        //5
        enterDataSubtract("-1", "0", "-1");
        //6
        enterDataSubtract("0", "-1", "1");
        //7
        enterDataSubtract("-1", "-1", "0");
        //8
        enterDataSubtract("10", "1", "9");
        //9
        enterDataSubtract("-9", "-1", "-8");
        //10
        enterDataSubtract("-10", "-1", "-9");
        //11
        enterDataSubtract("1000000", "2", "999998");
        //12
        enterDataSubtract("1000000", "-1000000", "2000000");
    }

    @Test
    public void test3Multiply(){
        //1
        enterDataMultiply("0", "0", "0");
        //2
        enterDataMultiply("0", "1", "0");
        //3
        enterDataMultiply("1", "0", "0");
        //4
        enterDataMultiply("1", "1", "1");
        //5
        enterDataMultiply("-1", "0", "0");
        //6
        enterDataMultiply("0", "-1", "0");
        //7
        enterDataMultiply("-1", "1", "-1");
        //8
        enterDataMultiply("1", "-1", "-1");
        //9
        enterDataMultiply("9", "1", "9");
        //10
        enterDataMultiply("10", "1", "10");
        //11
        enterDataMultiply("-9", "1", "-9");
        //12
        enterDataMultiply("-9", "-1", "9");
        //13
        enterDataMultiply("-10", "-1", "10");
        //14
        enterDataMultiply("1000", "1000", "1000000");
        //15
        enterDataMultiply("1000", "-1000", "-1000000");
    }

    @Test
    public void test3Divide(){
        //1
        //enterDataDivide("0", "0", "0");
        //2
        enterDataDivide("1", "0", "0");
        //3
        enterDataDivide("0", "1", "0");
        //4
        enterDataDivide("1", "1", "1");
        //5
        enterDataDivide("-1", "0", "0");
        //6
        enterDataDivide("0", "-1", "0");
        //7
        enterDataDivide("-1", "-1", "1");
        //8
        enterDataDivide("1", "-1", "-1");
        //9
        enterDataDivide("1", "-1", "-1");
        //10
        enterDataDivide("9", "1", "9");
        //11
        enterDataDivide("-9", "-1", "9");
        //12
        enterDataDivide("1000", "1000", "1");
        //13
        enterDataDivide("1000", "-1000", "-1");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
