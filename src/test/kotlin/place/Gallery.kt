package place

import base.Page
import base.waitClickableAndClick
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class Gallery(private val driver: WebDriver): Page(driver) {
    @FindBy(css = ".carousel__item:nth-child(2) .button__text")
    private lateinit var videosTab: WebElement

    @FindBy(css = ".carousel__item:nth-child(3) .button__text")
    private lateinit var photosInsideTab: WebElement

    fun openVideos() = waitClickableAndClick(driver, videosTab)

    fun openPhotosInside() = waitClickableAndClick(driver, photosInsideTab)
}
