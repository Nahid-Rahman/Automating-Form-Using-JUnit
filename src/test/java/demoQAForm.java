import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class demoQAForm
{
    //WebDriver driver = new FirefoxDriver();
    WebDriver driver;

    @Before
    public void setup()
    {
        WebDriverManager.firefoxdriver().setup();
        //       WebDriver driver = new FirefoxDriver();
      //         FirefoxOptions options = new FirefoxOptions();
        FirefoxOptions options = new FirefoxOptions();
//      options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//      options.addArguments("--headless");
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }


    /*
    Positive Test Case. Will try to fill up the form using valid Data
     */


    @Test
    public void _01_fillWithValidData() throws AWTException, InterruptedException {
        Actions actions = new Actions(driver);

        //Browsing to our target website
        driver.get("https://demoqa.com/automation-practice-form");

        /*
        As in my laptop, I had to zoom out 5 times to get the full view.
        So now I will zoom out 5 times to see the full form
         */
        Robot robot = new Robot();
        for (int i = 0; i<5; i++)
        {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Input First Name
        driver.findElement(By.id("firstName")).sendKeys("Mahmudur Rahman");

        //Input Last Name
        driver.findElement(By.id("lastName")).sendKeys("Nahid");

        //Input Email
        driver.findElement(By.id("userEmail")).sendKeys("smrahman.nahid@gmail.com");

        //Select gender from options
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        actions.click(radioButton).perform();

        //Input Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1627422552");

        //Input Date of Birth
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        dob.sendKeys(Keys.CONTROL + "a");
        //dob.sendKeys(Keys.BACK_SPACE);
        //If you try to press BackSpace, page gets blank
        dob.sendKeys("06 May 1996");
        dob.sendKeys(Keys.ENTER);

        //Input Subjects
        for(int i=0; i<3; i++)
        {
            if( i == 0)
            {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("math");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if( i == 1)
            {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("physics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if( i == 2)
            {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("civics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
        }
        //If you try to press BackSpace, page gets blank
        //If you try to cross a subject, page gets blank

        //Select hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        //actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();
        //You can select all 3 hobbies if you want

        //Uploading photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\BRAC\\W217.jpg");

        //Input Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Mirpur Gram");

        //Input State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("ncr");
        state.sendKeys(Keys.ENTER);

        //Input City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("delhi");
        city.sendKeys(Keys.ENTER);

        //Submitting the form
        actions.click(driver.findElement(By.id("submit"))).perform();

        Thread.sleep(2000);

        //Verifying
        String expectedMessage = "Thanks for submitting the form";
        String actualMessage = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage));


    }


    //Negative Test Case 01: Invalid First Name

    @Test
    public void _02_invalidFirstName() throws AWTException, InterruptedException
    {
        Actions actions = new Actions(driver);

        //Browsing to our target website
        driver.get("https://demoqa.com/automation-practice-form");

        /*
        As in my laptop, I had to zoom out 5 times to get the full view.
        So now I will zoom out 5 times to see the full form
         */
        Robot robot = new Robot();
        for (int i = 0; i < 5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Input First Name
        driver.findElement(By.id("firstName")).sendKeys("");

        //Input Last Name
        driver.findElement(By.id("lastName")).sendKeys("Nahid");

        //Input Email
        driver.findElement(By.id("userEmail")).sendKeys("smrahman.nahid@gmail.com");

        //Select gender from options
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        actions.click(radioButton).perform();

        //Input Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1627422552");

        //Input Date of Birth
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        dob.sendKeys(Keys.CONTROL + "a");
        //dob.sendKeys(Keys.BACK_SPACE);
        //If you try to press BackSpace, page gets blank
        dob.sendKeys("06 May 1996");
        dob.sendKeys(Keys.ENTER);

        //Input Subjects
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("math");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if (i == 1) {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("physics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if (i == 2) {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("civics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
        }
        //If you try to press BackSpace, page gets blank
        //If you try to cross a subject, page gets blank

        //Select hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        //actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();
        //You can select all 3 hobbies if you want

        //Uploading photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\BRAC\\W217.jpg");

        //Input Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Mirpur Gram");

        //Input State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("ncr");
        state.sendKeys(Keys.ENTER);

        //Input City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("delhi");
        city.sendKeys(Keys.ENTER);

        //Submitting the form
        actions.click(driver.findElement(By.id("submit"))).perform();

        Thread.sleep(2000);

        //Verifying
        String expectedMessage = "rgb(220, 53, 69)";
        String actualMessage = driver.findElement(By.id("firstName")).getCssValue("border-color");
        System.out.println(actualMessage);

        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }


    //Negative Test Case 02: Invalid Last Name

    @Test
    public void _03_invalidLastName() throws AWTException, InterruptedException
    {
        Actions actions = new Actions(driver);

        //Browsing to our target website
        driver.get("https://demoqa.com/automation-practice-form");

        /*
        As in my laptop, I had to zoom out 5 times to get the full view.
        So now I will zoom out 5 times to see the full form
         */
        Robot robot = new Robot();
        for (int i = 0; i < 5; i++)
        {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Input First Name
        driver.findElement(By.id("firstName")).sendKeys("Mahmudur Rahman");

        //Input Last Name
        driver.findElement(By.id("lastName")).sendKeys("");

        //Input Email
        driver.findElement(By.id("userEmail")).sendKeys("smrahman.nahid@gmail.com");

        //Select gender from options
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        actions.click(radioButton).perform();

        //Input Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1627422552");

        //Input Date of Birth
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        dob.sendKeys(Keys.CONTROL + "a");
        //dob.sendKeys(Keys.BACK_SPACE);
        //If you try to press BackSpace, page gets blank
        dob.sendKeys("06 May 1996");
        dob.sendKeys(Keys.ENTER);

        //Input Subjects
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("math");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if (i == 1) {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("physics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if (i == 2) {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("civics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
        }
        //If you try to press BackSpace, page gets blank
        //If you try to cross a subject, page gets blank

        //Select hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        //actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();
        //You can select all 3 hobbies if you want

        //Uploading photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\BRAC\\W217.jpg");

        //Input Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Mirpur Gram");

        //Input State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("ncr");
        state.sendKeys(Keys.ENTER);

        //Input City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("delhi");
        city.sendKeys(Keys.ENTER);

        //Submitting the form
        actions.click(driver.findElement(By.id("submit"))).perform();

        Thread.sleep(2000);

        //Verifying
        String expectedMessage = "rgb(220, 53, 69)";
        String actualMessage = driver.findElement(By.id("lastName")).getCssValue("border-color");

        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }


    //Negative Test Case 03: Invalid Email

    @Test
    public void _04_invalidEmail() throws AWTException, InterruptedException
    {
        Actions actions = new Actions(driver);

        //Browsing to our target website
        driver.get("https://demoqa.com/automation-practice-form");

        /*
        As in my laptop, I had to zoom out 5 times to get the full view.
        So now I will zoom out 5 times to see the full form
         */
        Robot robot = new Robot();
        for (int i = 0; i < 5; i++)
        {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Input First Name
        driver.findElement(By.id("firstName")).sendKeys("Mahmudur Rahman");

        //Input Last Name
        driver.findElement(By.id("lastName")).sendKeys("Nahid");

        //Input Email
        driver.findElement(By.id("userEmail")).sendKeys("anInvalidMail");

        //Select gender from options
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        actions.click(radioButton).perform();

        //Input Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1627422552");

        //Input Date of Birth
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        dob.sendKeys(Keys.CONTROL + "a");
        //dob.sendKeys(Keys.BACK_SPACE);
        //If you try to press BackSpace, page gets blank
        dob.sendKeys("06 May 1996");
        dob.sendKeys(Keys.ENTER);

        //Input Subjects
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("math");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if (i == 1) {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("physics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if (i == 2) {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("civics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
        }
        //If you try to press BackSpace, page gets blank
        //If you try to cross a subject, page gets blank

        //Select hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        //actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();
        //You can select all 3 hobbies if you want

        //Uploading photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\BRAC\\W217.jpg");

        //Input Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Mirpur Gram");

        //Input State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("ncr");
        state.sendKeys(Keys.ENTER);

        //Input City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("delhi");
        city.sendKeys(Keys.ENTER);

        //Submitting the form
        actions.click(driver.findElement(By.id("submit"))).perform();

        Thread.sleep(2000);

        //Verifying
        String expectedMessage = "rgb(220, 53, 69)";
        String actualMessage = driver.findElement(By.id("userEmail")).getCssValue("border-color");

        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    //Negative Test Case 04: Invalid Email

    @Test
    public void _05_emptyEmail() throws AWTException, InterruptedException
    {
        Actions actions = new Actions(driver);

        //Browsing to our target website
        driver.get("https://demoqa.com/automation-practice-form");

        /*
        As in my laptop, I had to zoom out 5 times to get the full view.
        So now I will zoom out 5 times to see the full form
         */
        Robot robot = new Robot();
        for (int i = 0; i < 5; i++)
        {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Input First Name
        driver.findElement(By.id("firstName")).sendKeys("Mahmudur Rahman");

        //Input Last Name
        driver.findElement(By.id("lastName")).sendKeys("Nahid");

        //Input Email
        driver.findElement(By.id("userEmail")).sendKeys("");

        //Select gender from options
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        actions.click(radioButton).perform();

        //Input Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1627422552");

        //Input Date of Birth
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        dob.sendKeys(Keys.CONTROL + "a");
        //dob.sendKeys(Keys.BACK_SPACE);
        //If you try to press BackSpace, page gets blank
        dob.sendKeys("06 May 1996");
        dob.sendKeys(Keys.ENTER);

        //Input Subjects
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("math");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if (i == 1) {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("physics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if (i == 2) {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("civics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
        }
        //If you try to press BackSpace, page gets blank
        //If you try to cross a subject, page gets blank

        //Select hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        //actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();
        //You can select all 3 hobbies if you want

        //Uploading photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\BRAC\\W217.jpg");

        //Input Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Mirpur Gram");

        //Input State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("ncr");
        state.sendKeys(Keys.ENTER);

        //Input City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("delhi");
        city.sendKeys(Keys.ENTER);

        //Submitting the form
        actions.click(driver.findElement(By.id("submit"))).perform();

        Thread.sleep(2000);

        //Verifying
        String expectedMessage = "rgb(220, 53, 69)";
        String actualMessage = driver.findElement(By.id("userEmail")).getCssValue("border-color");

        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }


    //Negative Test Case 05: Without Selecting Gender

    @Test
    public void _06_noGender() throws AWTException, InterruptedException
    {
        Actions actions = new Actions(driver);

        //Browsing to our target website
        driver.get("https://demoqa.com/automation-practice-form");

        /*
        As in my laptop, I had to zoom out 5 times to get the full view.
        So now I will zoom out 5 times to see the full form
         */
        Robot robot = new Robot();
        for (int i = 0; i < 5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Input First Name
        driver.findElement(By.id("firstName")).sendKeys("Mahmudur Rahman");

        //Input Last Name
        driver.findElement(By.id("lastName")).sendKeys("Nahid");

        //Input Email
        driver.findElement(By.id("userEmail")).sendKeys("smrahman.nahid@gmail.com");

        //Select gender from options
        //WebElement radioButton = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        //actions.click(radioButton).perform();

        //Input Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1627422552");

        //Input Date of Birth
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        dob.sendKeys(Keys.CONTROL + "a");
        //dob.sendKeys(Keys.BACK_SPACE);
        //If you try to press BackSpace, page gets blank
        dob.sendKeys("06 May 1996");
        dob.sendKeys(Keys.ENTER);

        //Input Subjects
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("math");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if (i == 1) {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("physics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if (i == 2) {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("civics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
        }
        //If you try to press BackSpace, page gets blank
        //If you try to cross a subject, page gets blank

        //Select hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        //actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();
        //You can select all 3 hobbies if you want

        //Uploading photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\BRAC\\W217.jpg");

        //Input Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Mirpur Gram");

        //Input State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("ncr");
        state.sendKeys(Keys.ENTER);

        //Input City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("delhi");
        city.sendKeys(Keys.ENTER);

        //Submitting the form
        actions.click(driver.findElement(By.id("submit"))).perform();

        Thread.sleep(2000);

        //Verifying
        String expectedMessage = "rgb(220, 53, 69)";
        String actualMessage = driver.findElement(By.xpath("//label[contains(text(),'Male')]")).getCssValue("color");

        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }


    //Negative Test Case 06: Invalid Phone Number

    @Test
    public void _07_invalidPhoneNumber() throws AWTException, InterruptedException
    {
        Actions actions = new Actions(driver);

        //Browsing to our target website
        driver.get("https://demoqa.com/automation-practice-form");

        /*
        As in my laptop, I had to zoom out 5 times to get the full view.
        So now I will zoom out 5 times to see the full form
         */
        Robot robot = new Robot();
        for (int i = 0; i < 5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Input First Name
        driver.findElement(By.id("firstName")).sendKeys("Mahmudur Rahman");

        //Input Last Name
        driver.findElement(By.id("lastName")).sendKeys("Nahid");

        //Input Email
        driver.findElement(By.id("userEmail")).sendKeys("smrahman.nahid@gmail.com");

        //Select gender from options
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        actions.click(radioButton).perform();

        //Input Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1616516416161658146161");

        //Input Date of Birth
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        dob.sendKeys(Keys.CONTROL + "a");
        //dob.sendKeys(Keys.BACK_SPACE);
        //If you try to press BackSpace, page gets blank
        dob.sendKeys("06 May 1996");
        dob.sendKeys(Keys.ENTER);

        //Input Subjects
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("math");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if (i == 1) {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("physics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if (i == 2) {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("civics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
        }
        //If you try to press BackSpace, page gets blank
        //If you try to cross a subject, page gets blank

        //Select hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        //actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();
        //You can select all 3 hobbies if you want

        //Uploading photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\BRAC\\W217.jpg");

        //Input Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Mirpur Gram");

        //Input State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("ncr");
        state.sendKeys(Keys.ENTER);

        //Input City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("delhi");
        city.sendKeys(Keys.ENTER);

        //Submitting the form
        actions.click(driver.findElement(By.id("submit"))).perform();

        Thread.sleep(2000);

        //Verifying
        String expectedMessage = "rgb(220, 53, 69)";
        String actualMessage = driver.findElement(By.id("userNumber")).getCssValue("border-color");

        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    //Negative Test Case 07: Invalid Phone Number

    @Test
    public void _08_emptyPhoneNumber() throws AWTException, InterruptedException
    {
        Actions actions = new Actions(driver);

        //Browsing to our target website
        driver.get("https://demoqa.com/automation-practice-form");

        /*
        As in my laptop, I had to zoom out 5 times to get the full view.
        So now I will zoom out 5 times to see the full form
         */
        Robot robot = new Robot();
        for (int i = 0; i < 5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Input First Name
        driver.findElement(By.id("firstName")).sendKeys("Mahmudur Rahman");

        //Input Last Name
        driver.findElement(By.id("lastName")).sendKeys("Nahid");

        //Input Email
        driver.findElement(By.id("userEmail")).sendKeys("smrahman.nahid@gmail.com");

        //Select gender from options
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        actions.click(radioButton).perform();

        //Input Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("");

        //Input Date of Birth
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        dob.sendKeys(Keys.CONTROL + "a");
        //dob.sendKeys(Keys.BACK_SPACE);
        //If you try to press BackSpace, page gets blank
        dob.sendKeys("06 May 1996");
        dob.sendKeys(Keys.ENTER);

        //Input Subjects
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("math");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if (i == 1) {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("physics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if (i == 2) {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("civics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
        }
        //If you try to press BackSpace, page gets blank
        //If you try to cross a subject, page gets blank

        //Select hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        //actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();
        //You can select all 3 hobbies if you want

        //Uploading photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\BRAC\\W217.jpg");

        //Input Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Mirpur Gram");

        //Input State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("ncr");
        state.sendKeys(Keys.ENTER);

        //Input City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("delhi");
        city.sendKeys(Keys.ENTER);

        //Submitting the form
        actions.click(driver.findElement(By.id("submit"))).perform();

        Thread.sleep(2000);

        //Verifying
        String expectedMessage = "rgb(220, 53, 69)";
        String actualMessage = driver.findElement(By.id("userNumber")).getCssValue("border-color");

        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }


    //Negative Test Case 08: Invalid DOB Format

    @Test
    public void _09_invalidDOB() throws AWTException, InterruptedException
    {
        Actions actions = new Actions(driver);

        //Browsing to our target website
        driver.get("https://demoqa.com/automation-practice-form");

        /*
        As in my laptop, I had to zoom out 5 times to get the full view.
        So now I will zoom out 5 times to see the full form
         */
        Robot robot = new Robot();
        for (int i = 0; i<5; i++)
        {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Input First Name
        driver.findElement(By.id("firstName")).sendKeys("Mahmudur Rahman");

        //Input Last Name
        driver.findElement(By.id("lastName")).sendKeys("Nahid");

        //Input Email
        driver.findElement(By.id("userEmail")).sendKeys("smrahman.nahid@gmail.com");

        //Select gender from options
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        actions.click(radioButton).perform();

        //Input Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1627422552");

        //Input Date of Birth
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        dob.sendKeys(Keys.CONTROL + "a");
        //dob.sendKeys(Keys.BACK_SPACE);
        //If you try to press BackSpace, page gets blank
        dob.sendKeys("9999999999999999999999999");
        dob.sendKeys(Keys.ENTER);

        //Input Subjects
        for(int i=0; i<3; i++)
        {
            if( i == 0)
            {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("math");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if( i == 1)
            {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("physics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if( i == 2)
            {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("civics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
        }
        //If you try to press BackSpace, page gets blank
        //If you try to cross a subject, page gets blank

        //Select hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        //actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();
        //You can select all 3 hobbies if you want

        //Uploading photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\BRAC\\W217.jpg");

        //Input Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Mirpur Gram");

        //Input State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("ncr");
        state.sendKeys(Keys.ENTER);

        //Input City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("delhi");
        city.sendKeys(Keys.ENTER);

        //Submitting the form
        actions.click(driver.findElement(By.id("submit"))).perform();

        Thread.sleep(2000);

        //Verifying
        String expectedMessage =  "rgb(220, 53, 69)";
        String actualMessage = driver.findElement(By.id("dateOfBirthInput")).getCssValue("border-color");

        Assert.assertTrue(actualMessage.contains(expectedMessage));


    }

    //Negative Test Case 09: Invalid or Empty Subject

    @Test
    public void _10_invalidOrEmptySubject() throws AWTException, InterruptedException
    {
        Actions actions = new Actions(driver);

        //Browsing to our target website
        driver.get("https://demoqa.com/automation-practice-form");

        /*
        As in my laptop, I had to zoom out 5 times to get the full view.
        So now I will zoom out 5 times to see the full form
         */
        Robot robot = new Robot();
        for (int i = 0; i<5; i++)
        {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Input First Name
        driver.findElement(By.id("firstName")).sendKeys("Mahmudur Rahman");

        //Input Last Name
        driver.findElement(By.id("lastName")).sendKeys("Nahid");

        //Input Email
        driver.findElement(By.id("userEmail")).sendKeys("smrahman.nahid@gmail.com");

        //Select gender from options
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        actions.click(radioButton).perform();

        //Input Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1627422552");

        //Input Date of Birth
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        dob.sendKeys(Keys.CONTROL + "a");
        //dob.sendKeys(Keys.BACK_SPACE);
        //If you try to press BackSpace, page gets blank
        dob.sendKeys("06 May 1996");
        dob.sendKeys(Keys.ENTER);

        //Input Subjects
        /*
        for(int i=0; i<3; i++)
        {
            if( i == 0)
            {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("math");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if( i == 1)
            {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("physics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if( i == 2)
            {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("civics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
        }
        */

        //If you try to press BackSpace, page gets blank
        //If you try to cross a subject, page gets blank

        //Select hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        //actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();
        //You can select all 3 hobbies if you want

        //Uploading photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\BRAC\\W217.jpg");

        //Input Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Mirpur Gram");

        //Input State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("ncr");
        state.sendKeys(Keys.ENTER);

        //Input City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("delhi");
        city.sendKeys(Keys.ENTER);

        //Submitting the form
        actions.click(driver.findElement(By.id("submit"))).perform();

        Thread.sleep(2000);

        //Verifying
        String expectedMessage =  "rgb(220, 53, 69)";
        String actualMessage = driver.findElement(By.id("subjectsInput")).getCssValue("border-color");

        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    //Negative Test Case 10: Invalid or Empty Hobby

    @Test
    public void _11_invalidOrEmptyHobby() throws AWTException, InterruptedException {
        Actions actions = new Actions(driver);

        //Browsing to our target website
        driver.get("https://demoqa.com/automation-practice-form");

        /*
        As in my laptop, I had to zoom out 5 times to get the full view.
        So now I will zoom out 5 times to see the full form
         */
        Robot robot = new Robot();
        for (int i = 0; i<5; i++)
        {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Input First Name
        driver.findElement(By.id("firstName")).sendKeys("Mahmudur Rahman");

        //Input Last Name
        driver.findElement(By.id("lastName")).sendKeys("Nahid");

        //Input Email
        driver.findElement(By.id("userEmail")).sendKeys("smrahman.nahid@gmail.com");

        //Select gender from options
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        actions.click(radioButton).perform();

        //Input Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1627422552");

        //Input Date of Birth
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        dob.sendKeys(Keys.CONTROL + "a");
        //dob.sendKeys(Keys.BACK_SPACE);
        //If you try to press BackSpace, page gets blank
        dob.sendKeys("06 May 1996");
        dob.sendKeys(Keys.ENTER);

        //Input Subjects
        for(int i=0; i<3; i++)
        {
            if( i == 0)
            {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("math");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if( i == 1)
            {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("physics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if( i == 2)
            {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("civics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
        }
        //If you try to press BackSpace, page gets blank
        //If you try to cross a subject, page gets blank

        //Select hobbies
        //actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        //actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        //actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();
        //You can select all 3 hobbies if you want

        //Uploading photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\BRAC\\W217.jpg");

        //Input Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Mirpur Gram");

        //Input State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("ncr");
        state.sendKeys(Keys.ENTER);

        //Input City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("delhi");
        city.sendKeys(Keys.ENTER);

        //Submitting the form
        actions.click(driver.findElement(By.id("submit"))).perform();

        Thread.sleep(2000);

        //Verifying
        String expectedMessage = "Thanks for submitting the form";
        String actualMessage = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }

    //Negative Test Case 11: Invalid or Empty Image

    @Test
    public void _12_invalidOrEmptyImage() throws AWTException, InterruptedException
    {
        Actions actions = new Actions(driver);

        //Browsing to our target website
        driver.get("https://demoqa.com/automation-practice-form");

        /*
        As in my laptop, I had to zoom out 5 times to get the full view.
        So now I will zoom out 5 times to see the full form
         */
        Robot robot = new Robot();
        for (int i = 0; i<5; i++)
        {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Input First Name
        driver.findElement(By.id("firstName")).sendKeys("Mahmudur Rahman");

        //Input Last Name
        driver.findElement(By.id("lastName")).sendKeys("Nahid");

        //Input Email
        driver.findElement(By.id("userEmail")).sendKeys("smrahman.nahid@gmail.com");

        //Select gender from options
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        actions.click(radioButton).perform();

        //Input Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1627422552");

        //Input Date of Birth
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        dob.sendKeys(Keys.CONTROL + "a");
        //dob.sendKeys(Keys.BACK_SPACE);
        //If you try to press BackSpace, page gets blank
        dob.sendKeys("06 May 1996");
        dob.sendKeys(Keys.ENTER);

        //Input Subjects
        for(int i=0; i<3; i++)
        {
            if( i == 0)
            {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("math");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if( i == 1)
            {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("physics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if( i == 2)
            {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("civics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
        }
        //If you try to press BackSpace, page gets blank
        //If you try to cross a subject, page gets blank

        //Select hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        //actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();
        //You can select all 3 hobbies if you want

        //Uploading photo
        //WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        //uploadElement.sendKeys("F:\\BRAC\\W217.jpg");

        //Input Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Mirpur Gram");

        //Input State
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("ncr");
        state.sendKeys(Keys.ENTER);

        //Input City
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("delhi");
        city.sendKeys(Keys.ENTER);

        //Submitting the form
        actions.click(driver.findElement(By.id("submit"))).perform();

        Thread.sleep(5000);

        //Verifying
        String expectedMessage = "Thanks for submitting the form";
        String actualMessage = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage));


    }


    //Negative Test Case 12: Empty State and City

    @Test
    public void _13_EmptyStateAndCity() throws AWTException, InterruptedException {
        Actions actions = new Actions(driver);

        //Browsing to our target website
        driver.get("https://demoqa.com/automation-practice-form");

        /*
        As in my laptop, I had to zoom out 5 times to get the full view.
        So now I will zoom out 5 times to see the full form
         */
        Robot robot = new Robot();
        for (int i = 0; i<5; i++)
        {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }

        //Input First Name
        driver.findElement(By.id("firstName")).sendKeys("Mahmudur Rahman");

        //Input Last Name
        driver.findElement(By.id("lastName")).sendKeys("Nahid");

        //Input Email
        driver.findElement(By.id("userEmail")).sendKeys("smrahman.nahid@gmail.com");

        //Select gender from options
        WebElement radioButton = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
        actions.click(radioButton).perform();

        //Input Phone Number
        driver.findElement(By.id("userNumber")).sendKeys("1627422552");

        //Input Date of Birth
        WebElement dob = driver.findElement(By.id("dateOfBirthInput"));
        dob.sendKeys(Keys.CONTROL + "a");
        //dob.sendKeys(Keys.BACK_SPACE);
        //If you try to press BackSpace, page gets blank
        dob.sendKeys("06 May 1996");
        dob.sendKeys(Keys.ENTER);

        //Input Subjects
        for(int i=0; i<3; i++)
        {
            if( i == 0)
            {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("math");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if( i == 1)
            {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("physics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
            if( i == 2)
            {
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys("civics");
                Thread.sleep(1000);
                driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
            }
        }
        //If you try to press BackSpace, page gets blank
        //If you try to cross a subject, page gets blank

        //Select hobbies
        actions.click(driver.findElement(By.id("hobbies-checkbox-1"))).perform();
        //actions.click(driver.findElement(By.id("hobbies-checkbox-2"))).perform();
        actions.click(driver.findElement(By.id("hobbies-checkbox-3"))).perform();
        //You can select all 3 hobbies if you want

        //Uploading photo
        WebElement uploadElement = driver.findElement(By.id("uploadPicture"));
        uploadElement.sendKeys("F:\\BRAC\\W217.jpg");

        //Input Current Address
        driver.findElement(By.id("currentAddress")).sendKeys("Mirpur Gram");

        //Input State
        //WebElement state = driver.findElement(By.id("react-select-3-input"));
        //state.sendKeys("ncr");
        //state.sendKeys(Keys.ENTER);

        //Input City
        //WebElement city = driver.findElement(By.id("react-select-4-input"));
        //city.sendKeys("delhi");
        //city.sendKeys(Keys.ENTER);

        //Submitting the form
        actions.click(driver.findElement(By.id("submit"))).perform();

        Thread.sleep(2000);

        //Verifying
        String expectedMessage = "Thanks for submitting the form";
        String actualMessage = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();

        Assert.assertTrue(actualMessage.contains(expectedMessage));


    }

    @After
    public void quit() throws InterruptedException
    {
        driver.quit();
        Thread.sleep(5000);
    }

}