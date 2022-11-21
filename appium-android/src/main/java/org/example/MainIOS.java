package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofMillis;
import static java.util.Collections.singletonList;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class MainIOS {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("automationName", "XCUItest");

        capabilities.setCapability("platformName", "IOS");

        capabilities.setCapability("platformVersion", "16.1");

        capabilities.setCapability("deviceName", "iPhone 14 Pro");

        capabilities.setCapability("appium:app", "/Users/elmerzapata/Downloads/MyRNDemoApp.app");


//        capabilities.setCapability("noReset", true);

        IOSDriver driver = new IOSDriver(new URL("http://localhost:4723/"), capabilities);

        driver.manage().timeouts().implicitlyWait( Duration.of(5, TimeUnit.SECONDS.toChronoUnit()));


        driver.findElement(By.id("Sauce Labs Bike Light")).click();
//        Dimension dimension = driver.manage().window().getSize();
//
//        PointerInput FINGER = new PointerInput(TOUCH, "finger");
//        Point start = new Point((int)(dimension.width*0.5), (int)(dimension.height*0.9));
//        Point end = new Point((int)(dimension.width*0.2), (int)(dimension.height*0.1));
//        Sequence swipe = new Sequence(FINGER, 1)
//                .addAction(FINGER.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()))
//                .addAction(FINGER.createPointerDown(LEFT.asArg()))
//                .addAction(FINGER.createPointerMove(ofMillis(2000), viewport(), end.getX(), end.getY()))
//                .addAction(FINGER.createPointerUp(LEFT.asArg()));
//        driver.perform(singletonList(swipe));
//        Sequence swipe2 = new Sequence(FINGER, 1)
//                .addAction(FINGER.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()))
//                .addAction(FINGER.createPointerDown(LEFT.asArg()))
//                .addAction(FINGER.createPointerMove(ofMillis(2000), viewport(), end.getX(), end.getY()))
//                .addAction(FINGER.createPointerUp(LEFT.asArg()));
//        driver.perform(singletonList(swipe2));

    }


}