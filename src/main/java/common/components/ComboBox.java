package common.components;

import common.CommonWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ComboBox extends Component {
    private List<WebElement> elementList;
    public ComboBox(WebDriver driver) {
        super(driver);
    }
    CommonWait wait = new CommonWait(driver);

    public void selectedComBoBox(String comboBoxLocator,String comboBoxList,  String value)
    {
        WebElement comboBox = getWebElement(comboBoxLocator);
        wait.waitUntilToBeClickAble(comboBox);
        comboBox.click();
        sleep(100);
        elementList = getWebElements(comboBoxList);
        for (WebElement elm : elementList) {
            if (elm.getText().equals(value)) {
                elm.click();
                break;
            }
        }
    }

}
