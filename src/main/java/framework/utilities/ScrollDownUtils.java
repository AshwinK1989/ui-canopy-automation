package framework.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollDownUtils {

    private static final String JQUERY_URL = "http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js";
    private static final int EXPLICIT_WAIT_IN_SEC = 10000;
    private static final ExpectedCondition<Boolean> jQueryLoaded = new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver driver) {
            try {
                return (Boolean) executor(driver).executeScript("return jQuery()!=null");
            } catch (WebDriverException e) {
                return false;
            }
        }
    };

    private static JavascriptExecutor executor(WebDriver driver) {
        if (driver instanceof JavascriptExecutor) {
            return (JavascriptExecutor) driver;
        } else {
            throw new UnsupportedOperationException("This driver does not support javascript execution");
        }
    }

    public static boolean isJQueryLoaded(WebDriver driver) {
        return Boolean.valueOf(jQueryLoaded.apply(driver));
    }

    public static JavascriptExecutor injectJQuery(WebDriver driver, int seconds) {


        JavascriptExecutor jsexec = executor(driver);
        if (!isJQueryLoaded(driver)) {
            WebDriverWait wait = (new WebDriverWait(driver, seconds));
            jsexec.executeScript("var headID = document.getElementsByTagName('head')[0];"
                    + "var newScript = document.createElement('script');"
                    + "newScript.type = 'text/javascript';"
                    + "newScript.src = '" + JQUERY_URL + "';"
                    + "headID.appendChild(newScript);");
            wait.until(jQueryLoaded);
        }
        return jsexec;
    }


    public static String getAbsoluteXPath(WebElement element) {
        WebDriver driver = ((WrapsDriver) element).getWrappedDriver();
        return (String) executor(driver).executeScript("function absoluteXPath(element) {"
                + "var comp, comps = [];"
                + "var parent = null;"
                + "var xpath = '';"
                + "var getPos = function(element) {"
                + "var position = 1, curNode;"
                + "if (element.nodeType == Node.ATTRIBUTE_NODE) {"
                + "return null;"
                + "}"
                + "for (curNode = element.previousSibling; curNode; curNode = curNode.previousSibling) {"
                + "if (curNode.nodeName == element.nodeName) {"
                + "++position;"
                + "}"
                + "}"
                + "return position;"
                + "};"
                + "if (element instanceof Document) {"
                + "return '/';"
                + "}"
                + "for (; element && !(element instanceof Document); element = element.nodeType == Node.ATTRIBUTE_NODE ? element.ownerElement : element.parentNode) {"
                + "comp = comps[comps.length] = {};"
                + "switch (element.nodeType) {"
                + "case Node.TEXT_NODE:"
                + "comp.name = 'text()';"
                + "break;"
                + "case Node.ATTRIBUTE_NODE:"
                + "comp.name = '@' + element.nodeName;"
                + "break;"
                + "case Node.PROCESSING_INSTRUCTION_NODE:"
                + "comp.name = 'processing-instruction()';"
                + "break;"
                + "case Node.COMMENT_NODE:"
                + "comp.name = 'comment()';"
                + "break;"
                + "case Node.ELEMENT_NODE:"
                + "comp.name = element.nodeName;"
                + "break;"
                + "}"
                + "comp.position = getPos(element);"
                + "}"
                + "for (var i = comps.length - 1; i >= 0; i--) {"
                + "comp = comps[i];"
                + "xpath += '/' + comp.name.toLowerCase();"
                + "if (comp.position !== null) {"
                + "xpath += '[' + comp.position + ']';"
                + "}"
                + "}"
                + "return xpath;"
                + "} return absoluteXPath(arguments[0]);", element);
    }


    public static void bringIntoView(WebElement element, WebDriver driver) {

        LogUtil.info("The element is --- " + element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + element.getLocation().y + ")");


        JavascriptExecutor jsexec = injectJQuery(driver, EXPLICIT_WAIT_IN_SEC);


        Coordinates coordinate = ((Locatable) element).getCoordinates();
        Point point = coordinate.inViewPort();

        if (isClickObstructed(point, element, driver)) {


            jsexec.executeScript("function scrollIntoView(el) {"
                    + "var offsetTop = window. jQuery(el).offset().top;"
                    + "var adjustment = Math.max(0,( window. jQuery(window).height() - window. jQuery(el).outerHeight(true) ) / 2);"
                    + "var scrollTop = offsetTop - adjustment;"
                    + "window. jQuery('html,body').animate({"
                    + "scrollTop: scrollTop"
                    + "}, 0);"
                    + "} scrollIntoView(arguments[0]);", element);


        }
    }


    private static boolean isClickObstructed(Point point, WebElement element, WebDriver driver) {
        driver = ((WrapsDriver) element).getWrappedDriver();
        Dimension dim = element.getSize();
        int clickX = point.getX() + (dim.getWidth() / 2);
        int clickY = point.getY() + (dim.getHeight() / 2);


        WebElement elementAtClick = (WebElement) executor(driver).executeScript("return document.elementFromPoint(" + clickX + ", " + clickY + ");");
        String elementAtClickXPath = getAbsoluteXPath(elementAtClick);
        String elementXPath = getAbsoluteXPath(element);
        if (!elementXPath.equals(elementAtClickXPath)) {
            return true;
        }
        return false;
    }
}
