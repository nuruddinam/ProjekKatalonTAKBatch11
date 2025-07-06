import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

// Setup ChromeOptions
ChromeOptions options = new ChromeOptions()

Map<String, Object> prefs = new HashMap()

prefs.put('credentials_enable_service', false)

prefs.put('profile.password_manager_enabled', false)

prefs.put('password_leak_detection_enabled', false)

options.setExperimentalOption('prefs', prefs)

options.addArguments('--disable-features=SafeBrowsing,PasswordLeakToggleMove')

options.addArguments('--guest')

// ✅ SET PATH CHROMEDRIVER SESUAI DENGAN YANG KAMU PUNYA
System.setProperty('webdriver.chrome.driver', 'C:\\Users\\User\\.katalon\\packages\\KS-10.2.3\\configuration\\resources\\drivers\\chromedriver_win32\\chromedriver.exe')

// Jalankan Chrome dengan custom options
ChromeDriver driver = new ChromeDriver(options)

DriverFactory.changeWebDriver(driver)

// Mulai navigasi ke base URL
WebUI.navigateToUrl(GlobalVariable.baseUrl)

