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
WebUI.comment('Click Readmission')

//WebUI.click(findTestObject('Page_MakeAppointment/inputReadmission_Checkbox'))
if (readmission == true) {
    WebUI.click(findTestObject('Page_MakeAppointment/inputReadmission_Checkbox'))
}

WebUI.comment('Input Health Care Program')
//WebUI.click(findTestObject('Page_MakeAppointment/inputMedicaid_Radiobtn'))
select_radio = programs
switch (select_radio) {
    case 'Medicare':
        WebUI.click(findTestObject('Page_MakeAppointment/inputMedicare_Radiobtn'))
	break
	
    case 'Medicaid':
        WebUI.click(findTestObject('Page_MakeAppointment/inputMedicaid_Radiobtn'))
	break
	
    case 'None':
        WebUI.click(findTestObject('Page_MakeAppointment/inputNone_Radiobtn'))
    break
    
	default:
        WebUI.click(findTestObject('Page_MakeAppointment/inputNone_Radiobtn'))
    break
}

WebUI.comment('Input Visit Date')

WebUI.setText(findTestObject('Page_MakeAppointment/inputVisitDate_text'), visitDate)

WebUI.comment('Input Comment')

WebUI.setText(findTestObject('Object Repository/Object Recorder/textarea_Comment_comment'), komentar)

WebUI.comment('Click tombol Button')

WebUI.waitForElementVisible(findTestObject('Page_MakeAppointment/bookAppointment_btn'), 60)

WebUI.verifyElementVisible(findTestObject('Page_MakeAppointment/bookAppointment_btn'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_MakeAppointment/bookAppointment_btn'))

WebUI.verifyElementVisible(findTestObject('Object Recorder/h2_Appointment Confirmation'))

WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/facility_lbl'), facility)

WebUI.comment('Verify Readmission')
//WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/readmission_lbl'), readmission)
if (readmission == true) {
    WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/readmission_lbl'), 'Yes')
} else {
    WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/readmission_lbl'), 'No')
}

WebUI.comment('Verify Healthcare Programs')
//WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/healthCareProgram_lbl'), programs)
select_radio = programs
switch (select_radio) {
	case 'Medicare':
		WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/healthCareProgram_lbl'), programs)
	break
	
	case 'Medicaid':
		WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/healthCareProgram_lbl'), programs)
	break
	
	case 'None':
		WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/healthCareProgram_lbl'), programs)
	break
	
	default:
		WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/healthCareProgram_lbl'), 'None')
	break
}

WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/visitDate_lbl'), visitDate)

WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/comment_lbl'), komentar, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.takeScreenshot(FailureHandling.OPTIONAL)

