package api_learning;

import context.Contexts;
import context.WaitMoreThanOneContext;
import driver.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HybridContext {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);

        try {
            By webviewNavBtnSel = MobileBy.AccessibilityId("Webview");
            MobileElement webviewNavBtnEl = appiumDriver.findElement(webviewNavBtnSel);
            webviewNavBtnEl.click();

            // Wait until we have one more than context
            WebDriverWait wait = new WebDriverWait(appiumDriver, 30L);
            wait.until(new WaitMoreThanOneContext(appiumDriver));

            // Print all contexts
            for (String contextHandle : appiumDriver.getContextHandles()) {
                System.out.println(contextHandle);
            }

            // Switch to Webview
            appiumDriver.context(Contexts.WEB_VIEW);
            //Interact with WebView elements
            WebElement navToggleBtnEl = appiumDriver.findElementByCssSelector(".navbar__toggle");
            navToggleBtnEl.click();
            List<MobileElement> menuItemsEl = appiumDriver.findElementsByCssSelector(".menu__list li a");
            // List<MobileElement> menuItemsEl = appiumDriver.findElementsByXPath("//ul[contains(@class,'menu__list')]//li/a");
            Map<String, String> menuItemDataMap = new HashMap<>();
            // Thay thế Map bằng một list
            List<MenuItemData> menuItemDataList = new ArrayList<>();


            if (menuItemsEl.isEmpty()) {
                throw new RuntimeException("[ERR] There is no list items!");
            }
            //False Negative
            for (MobileElement menuItemEl : menuItemsEl) {
                String itemText = menuItemEl.getText();
                String itemHref = menuItemEl.getAttribute("href");
                if (itemText.isEmpty()) {
                    menuItemDataMap.put("GitHub", itemHref);
                } else {
                    menuItemDataMap.put(itemText, itemHref);
                    menuItemDataList.add(new MenuItemData(itemText, itemHref));
                }
            }

//            // Verification
//            for (String itemText : menuItemDataMap.keySet()) {
//                System.out.println("itemText: " + itemText);
//                System.out.println("itemHref: " + menuItemDataMap.get(itemText));
//            }
            for (MenuItemData menuItemData : menuItemDataList) {
                System.out.println(menuItemData);
            }

            //False positive | Flakiness


            // Switch to Native context
            appiumDriver.context(Contexts.NATIVE);

            // DEBUG PURPOSE ONLY
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        appiumDriver.quit();
    }

    public static class MenuItemData {
        private String name;
        private String href;

        // Chỉ read only chứ ko có change
        public MenuItemData(String name, String href) {
            this.name = name;
            this.href = href;
        }

        @Override
        public String toString() {
            return "MenuItemData{" +
                    "name='" + name + '\'' +
                    ", href='" + href + '\'' +
                    '}';
        }
    }
}
