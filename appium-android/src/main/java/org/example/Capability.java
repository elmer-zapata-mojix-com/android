package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

public class Capability {
    protected static String appPackage;
    protected static String appActivity;
    protected static String deviceName;
    protected static String chromedriverExecutable;
    public AppiumDriverLocalService service;
    // creating this method to start my appium through nodejs // this is given by appium server
    public AppiumDriverLocalService startServer()
    {
        boolean flag = checkifserverisRunning(4723);
        if(!flag)
        {
            //service = AppiumDriverLocalService.buildDefaultService();
            service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                    .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
                    .withAppiumJS(new File("C:\\Users\\ShashankCN\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                    .withIPAddress("127.0.0.1").usingPort(4723));
            service.start();
        }
        return service;
    }

    public static boolean checkifserverisRunning(int port)
    {
        boolean isserverRunning = false;
        ServerSocket serverSocket;
        try
        {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        }
        catch (Exception e) {
            isserverRunning= true;
        }
        finally {
            serverSocket=null;
        }
        return isserverRunning;
    }

    public static void startEmulator() throws IOException, InterruptedException
    {
        Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\Emulator.bat");
        Thread.sleep(8000);
    }

    public static AndroidDriver Capability(String appPackage, String appActivity, String deviceName, String chromedriverExecutable) throws IOException, InterruptedException {
        FileReader fis = new FileReader(System.getProperty("user.dir")+"//src//main//java//global.properties");
        Properties Pro = new Properties();
        Pro.load(fis);
        appPackage = Pro.getProperty("appPakcage");
        appActivity = Pro.getProperty("appActivity");
        deviceName = Pro.getProperty("deviceName");
        if(deviceName.contains("Shashank"))
        {
            startEmulator();
        }

        chromedriverExecutable = Pro.getProperty("chromedriverExecutable");

        //DesiredCapabilities cap = new DesiredCapabilities();
        //cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Shashank");
        //cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        //cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "Training\\SDET\\Appium\\chromedriver_win32\\chromedriver.exe");
        //cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        //cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");
        //cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.SplashActivity");
        //AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        //return driver;

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Shashank");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\SVN\\mobile\\WebApp\\driver.chromedriver.exe");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.khanacademy.android.ui.library.MainActivity");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        return driver;

    }}
