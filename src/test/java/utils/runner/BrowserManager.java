package utils.runner;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import utils.LoggerUtils;

import java.util.Map;

public final class BrowserManager {

    public static Browser createBrowser(Playwright playwright, Map<String, String> environment) {
        String browserName = environment.get("browser");
        boolean isHeadless = Boolean.parseBoolean(environment.get("isHeadless"));
        int slowMo = Integer.parseInt(environment.get("slowMo"));

        switch(browserName) {
            case "chromium" -> {
                LoggerUtils.logInfo("INFO: " + browserName + " launched.");

                return playwright.chromium()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(isHeadless)
                                .setSlowMo(slowMo));
            }
            case "firefox" -> {
                LoggerUtils.logInfo("INFO: " + browserName + " launched.");

                return playwright.firefox()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(isHeadless)
                                .setSlowMo(slowMo));
            }
            case "webkit" -> {
                LoggerUtils.logInfo("INFO: " + browserName + " launched.");

                return playwright.webkit()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(isHeadless)
                                .setSlowMo(slowMo));
            }
            default -> {
                LoggerUtils.logWarning("WARNING: " + browserName + " is NOT match any options. chromium() launched.");

                return playwright.chromium()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(true)
                                .setSlowMo(0));
            }
        }
    }
}
