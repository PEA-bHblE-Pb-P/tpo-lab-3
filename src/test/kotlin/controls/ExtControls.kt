package controls

import base.Page
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class ExtControls(driver: WebDriver): Page(driver) {
    @FindBy(css = ".list-item-view:nth-child(1) > .list-item-view__content")
    private lateinit var printButton: WebElement

    fun openPrintPage() {
        printButton.click()
    }
}
