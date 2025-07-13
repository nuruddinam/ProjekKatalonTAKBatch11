import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.click(findTestObject('Homepage/makeAppointment_btn'))

WebUI.setText(findTestObject('Page_Login/username_textField'), username)

WebUI.setEncryptedText(findTestObject('Page_Login/password_textField'), password)

WebUI.click(findTestObject('Page_Login/login_btn'))

//WebUI.waitForElementVisible(findTestObject('Page_MakeAppointment/h2makeAppointment_text'), 30)
//WebUI.verifyElementVisible(findTestObject('Page_MakeAppointment/h2makeAppointment_text'))
// Tunggu sebentar untuk proses login
//WebUI.delay(2)
// Kalau login berhasil → halaman appointment muncul
if (WebUI.verifyElementPresent(findTestObject('Page_MakeAppointment/h2makeAppointment_text'), 5, FailureHandling.OPTIONAL)) {
    WebUI.comment('Login sukses - halaman appointment terbuka')

    WebUI.verifyElementVisible(findTestObject('Page_MakeAppointment/h2makeAppointment_text')) // Kalau login gagal → pesan error login muncul
} else if (WebUI.verifyElementPresent(findTestObject('Page_Login/loginErrorMessage_lbl'), 5, FailureHandling.OPTIONAL)) {
    WebUI.comment('Login gagal - username atau password salah')

    WebUI.verifyElementText(findTestObject('Page_Login/loginErrorMessage_lbl'), 'Login failed! Please ensure the username and password are valid.')
} else {
    WebUI.comment('Login tidak valid dan tidak ditemukan error message atau halaman appointment')
}

