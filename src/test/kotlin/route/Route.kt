package route

import base.Page
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

abstract class Route(driver: WebDriver): Page(driver) {
    abstract val mode: Mode
    abstract val modeButton: WebElement
    abstract val title: WebElement
    abstract val titlePattern: String
    protected abstract val duration: WebElement

    @FindBy(css = ".route-error-view__text")
    lateinit var routeError: WebElement

    fun duration() = duration
        .text
        .split(" ")
        .first()
        .toInt()
}

enum class Mode {
    AUTO, BICYCLE, MASS_TRANSIT, PEDESTRIAN, SCOOTER, TAXI
}
