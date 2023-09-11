import base.wait
import base.waitClickableAndClick
import org.openqa.selenium.By.cssSelector
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.CacheLookup
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import page.Page
import place.Business
import route.RoutePanel
import route.Tooltip
import java.time.Duration

open class Sidebar(private val driver: WebDriver) : Page(driver) {
    // строка поиска
    @FindBy(css = ".input__control")
    private lateinit var searchInput: WebElement

    @FindBy(css = ".suggest__group")
    private lateinit var searchResultView: WebElement

    @FindBy(css = "._type_route")
    private lateinit var routeButton: WebElement

    @FindBy(css = "._type_close")
    lateinit var closeButton: WebElement

    @FindBy(css = "._id_food > .catalog-grid-view__icon")
    private lateinit var foodIcon: WebElement

    @FindBy(css = ".search-list-view__list")
    lateinit var searchResultList: WebElement

    fun inputQuery(login: String?) {
        Thread.sleep(Duration.ofSeconds(2).toMillis())
        searchInput.sendKeys(login, Keys.ENTER)
    }

    fun openBusinessByQuery(business: String): Business {
        Thread.sleep(Duration.ofSeconds(2).toMillis())
        searchInput.sendKeys(business, Keys.ENTER)
        return Business(driver)
    }

    fun openBusinessFromResult(i: Int = 1): Business {
        waitClickableAndClick(driver, cssSelector(".search-snippet-view:nth-child($i)"))
        return Business(driver)
    }

    fun openRoutePanel(): RoutePanel {
        Thread.sleep(Duration.ofSeconds(1).toMillis())
        routeButton.click()
        return RoutePanel(driver)
    }

    fun showFoodPlaces(): Tooltip {
        waitClickableAndClick(driver, foodIcon)
        return Tooltip(driver)
    }

    fun showBars() = waitClickableAndClick(driver, cssSelector("[aria-label=\"Бары\"]"))
}
