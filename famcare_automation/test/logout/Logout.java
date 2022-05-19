/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logout;

import driver.ClientDriver;
import driver.Watcher;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

/**
 *
 * @author HP
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Logout {

    @Rule
    public Watcher watcher = new Watcher(ClientDriver.driver);

    @BeforeClass
    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Logout.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Logout Delay 1 second applied ");
    }

    @Test
    public void test1_logout() {
        String MoreButtonXpath = "//android.widget.ImageView[@content-desc=\"المزيد علامة التبويب4من 4 \"]";
        ClientDriver.base.waitForElementToBeVisibleBy(By.xpath(MoreButtonXpath));
        ClientDriver.base.getElementByXpath(MoreButtonXpath).click();
//        String SettingacountButtonXpath = "//android.view.View[@content-desc=\"اعدادات الحساب\"]";
//        ClientDriver.base.waitForElementToBeVisibleBy(By.xpath(SettingacountButtonXpath));
//        ClientDriver.base.getElementByXpath(SettingacountButtonXpath).click();
//        String logoutButtonXpath = "//android.widget.ImageView[@content-desc=\"تسجيل الخروج\"]";
//        ClientDriver.base.getElementByXpath(logoutButtonXpath).click();
//        String LogoutfromdeviceXpath = "//android.widget.Button[@content-desc=\"تسجيل الخروج من هذا الجهاز فقط\"]";
//        ClientDriver.base.getElementByXpath(LogoutfromdeviceXpath).click();
//        String welcometext1xpath = "//android.view.View[@content-desc=\" مرحبا بك في متنفسك ومساحتك الآمنة\"]]";
//        ClientDriver.base.waitForElementToBeVisibleBy(By.xpath(welcometext1xpath));
//        String welcometext2xpath = "//android.view.View[@content-desc=\" ابدأ خطوتك الأولى مع نخبة من الأخصائيين\"]]";
//        ClientDriver.base.waitForElementToBeVisibleBy(By.xpath(welcometext2xpath));

    }

}
