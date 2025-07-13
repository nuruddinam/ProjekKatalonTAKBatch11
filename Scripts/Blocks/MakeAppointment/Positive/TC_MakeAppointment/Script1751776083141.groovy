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

WebUI.selectOptionByValue(findTestObject('Page_MakeAppointment/selectFacility_btn'), facility, true)

'Mengganti Element by Nuruddin 120725'
WebUI.comment('Check Readmission')

WebUI.click(findTestObject('Page_MakeAppointment/inputReadmission_Checkbox'))

WebUI.comment('Input Health Care Program')

WebUI.click(findTestObject('Page_MakeAppointment/inputMedicaid_Radiobtn'))

WebUI.comment('Input Visit Date')

WebUI.click(findTestObject('Page_MakeAppointment/inputVisitDate_text'))

WebUI.click(findTestObject('Object Repository/Object Recorder/td_29'))

WebUI.comment('Input Comment')

WebUI.setText(findTestObject('Object Repository/Object Recorder/textarea_Comment_comment'), komentar)

WebUI.comment('Click tombol Button')

WebUI.waitForElementVisible(findTestObject('Page_MakeAppointment/bookAppointment_btn'), 60)

WebUI.verifyElementVisible(findTestObject('Page_MakeAppointment/bookAppointment_btn'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_MakeAppointment/bookAppointment_btn'))

WebUI.verifyElementVisible(findTestObject('Object Recorder/h2_Appointment Confirmation'))

WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/facility_lbl'), 'Hongkong CURA Healthcare Center')

WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/readmission_lbl'), 'Yes')

WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/healthCareProgram_lbl'), 'Medicaid')

WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/visitDate_lbl'), '29/07/2025')

WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/comment_lbl'), 'oke', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.takeScreenshot(FailureHandling.OPTIONAL)

