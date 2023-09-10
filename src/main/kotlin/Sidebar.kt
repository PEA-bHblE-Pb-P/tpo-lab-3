import base.wait
import base.waitClickableAndClick
import org.openqa.selenium.By.cssSelector
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf
import org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf
import page.Page
import place.Business
import route.RoutePanel

open class Sidebar(private val driver: WebDriver) : Page(driver) {
    // строка поиска
    @FindBy(xpath = "//input")
    private lateinit var searchInput: WebElement

    @FindBy(css = ".suggest__group")
    private lateinit var searchResultView: WebElement

    @FindBy(css = "._type_route")
    private lateinit var routeButton: WebElement

    @FindBy(css = "._type_close")
    private lateinit var closeButton: WebElement

    @FindBy(css = ".close-button path")
    private lateinit var closeAlertButton: WebElement

    @FindBy(css = "._id_food > .catalog-grid-view__icon")
    private lateinit var foodIcon: WebElement

    @FindBy(css = ".search-list-view__list")
    lateinit var searchResultList: WebElement

    fun inputQuery(login: String?) {
        ExpectedConditions.elementToBeClickable(searchInput).wait(driver)
        searchInput.sendKeys(login, Keys.ENTER)
        invisibilityOf(searchResultView).wait(driver, 1)
    }

    fun openBusinessFromResult(i: Int = 1): Business {
        waitClickableAndClick(driver, cssSelector(".search-snippet-view:nth-child($i)"))
        return Business(driver)
    }

    fun openRoutePanel(): RoutePanel {
        routeButton.click()
        return RoutePanel(driver)
    }

    fun showFoodPlaces() = waitClickableAndClick(driver, foodIcon)

    fun showBars() = waitClickableAndClick(driver, cssSelector("[aria-label=\"Бары\"]"))

    fun closeAlert() = closeAlertButton.click()
}
