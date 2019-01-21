import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.interactions.Actions

class WebTest {

    private val webDriver by lazy { buildWebDriver() }

    private fun buildWebDriver(): ChromeDriver {
        System.setProperty(
            "webdriver.chrome.driver",
            "C:\\Users\\flip6\\IdeaProjects\\mttppFilipBabic\\chromedriver.exe"
        )

        return ChromeDriver()
    }

    @Before
    fun setUp() {
        webDriver.navigate().to("https://www.ferit.unios.hr/")
    }

    @After
    fun tearDown() {
        webDriver.close()
    }

    @Test
    fun testHeaderExists() {
        assertTrue(webDriver.findElement(By.id("header")).isDisplayed)
    }

    @Test
    fun testFindTestingSubject() {
        webDriver.findElementByXPath("//*[@id=\"content-contain\"]/div[3]/div/ul[2]/li[1]/a").click()
        webDriver.findElementByXPath("//*[@id=\"sidebar\"]/p[3]/a").click()
        webDriver.findElementByXPath("//*[@id=\"content\"]/div[2]/div[8]/a/span").click()
        webDriver.findElementByClassName("prikaz-studij-link-38").click()

        Actions(webDriver).moveToElement(webDriver.findElementByName("1819717-38"))

        Thread.sleep(2000)
    }

    @Test
    fun testBreaksLanguageNavigation() {
        webDriver.findElementByXPath("//*[@id=\"search\"]/a/img").click()
        webDriver.findElementByXPath("//*[@id=\"search\"]/a/img").click()

        // this test will fail
        assertEquals("https://www.ferit.unios.hr/", webDriver.currentUrl)
    }

    @Test
    fun testBreaksWebsite() {
        webDriver.findElementByXPath("//*[@id=\"search\"]/a/img").click()
        webDriver.findElementByXPath("//*[@id=\"search\"]/a/img").click()
        webDriver.findElementByXPath("//*[@id=\"search\"]/a/img").click()

        // clicking three times on the localization flag breaks the website
    }

    @Test
    fun testSearchDoesNotShowResults() {
        val search = webDriver.findElementByName("search")
        search.sendKeys("praksa")

        webDriver.findElementByName("trazi").click()

        webDriver.findElementByXPath("//*[contains(text(), 'praksa')]")
        Thread.sleep(2000)

        // this test fails because there the search doesn't work properly, and without sending 'enter', we won't be able to search anything
    }
}