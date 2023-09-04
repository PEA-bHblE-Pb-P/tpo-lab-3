import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.By.cssSelector
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable
import java.time.Duration


class AuthorizedTest : BaseTest() {
    @Test
    fun `5 star`() {
        runTest(::oneDriver5Star, drivers)
    }

    private fun oneDriver5Star(d: WebDriver) {
        val mainPage = MainPage(d)
        Thread.sleep(Duration.ofSeconds(2).toMillis())
        mainPage.inputQuery("университет итмо")

        elementToBeClickable(
            cssSelector(".search-snippet-view:nth-child(1) .search-business-snippet-view__head")
        ).wait(mainPage.driver)
        mainPage.driver.findElement(
            cssSelector(".search-snippet-view:nth-child(1) .search-business-snippet-view__head")
        ).click()

        Thread.sleep(Duration.ofSeconds(1).toMillis())
        elementToBeClickable(
            cssSelector(".business-header-rating-view__text")
        ).wait(mainPage.driver)
        mainPage.driver.findElement(
            cssSelector(".business-header-rating-view__text")
        ).click()

        Thread.sleep(Duration.ofSeconds(1).toMillis())
        elementToBeClickable(
            cssSelector(".business-rating-edit-view__star:nth-child(5) path")
        ).wait(mainPage.driver)
        mainPage.driver.findElement(cssSelector(".business-rating-edit-view__star:nth-child(5) path")).click()

        Thread.sleep(Duration.ofSeconds(1).toMillis())
        elementToBeClickable(
            cssSelector(".login-dialog-view")
        ).wait(mainPage.driver)

    }
}