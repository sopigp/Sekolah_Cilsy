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
import groovy.ui.SystemOutputInterceptor as SystemOutputInterceptor
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.github.javafaker.Faker as Faker

Faker faker = new Faker()

String firstName = faker.name().firstName()

String lastName = faker.name().lastName()

//String username = faker.name().username()
WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.url_OrangeHRM)

WebUI.setText(findTestObject('Manual/OrangeHRM/input_username'), 'Admin')

WebUI.setEncryptedText(findTestObject('Manual/OrangeHRM/input_password'), 'hUKwJTbofgPU9eVlw/CnDQ==')

WebUI.click(findTestObject('Manual/OrangeHRM/btn_login'))

WebUI.verifyElementVisible(findTestObject('Manual/OrangeHRM/verify_panel_username'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Manual/OrangeHRM/panel_PIM'))

WebUI.click(findTestObject('Manual/OrangeHRM/panel_add_employee'))

WebUI.setText(findTestObject('Manual/OrangeHRM/input_add_employee_FName'), 'Sofie')

WebUI.setText(findTestObject('Manual/OrangeHRM/input_add_emplotee_MName'), firstName)

WebUI.setText(findTestObject('Manual/OrangeHRM/input_add_employee_LName'), lastName)

WebUI.verifyElementVisible(findTestObject('Manual/OrangeHRM/input_add_employee_ID'))

WebUI.uploadFile(findTestObject('Manual/OrangeHRM/input_add_employee_upload_profile'), upload_file)

upload_file_success = WebUI.getText(findTestObject('Manual/OrangeHRM/input_add_employee_upload_profile'))

System.out.println(upload_file_success)

WebUI.click(findTestObject('Manual/OrangeHRM/checkbox_add_employee'))

WebUI.setText(findTestObject('Manual/OrangeHRM/input_add_employee_username'), GlobalVariable.add_employee_username)

WebUI.setText(findTestObject('Manual/OrangeHRM/input_add_employee_password'), GlobalVariable.add_employee_password)

WebUI.setText(findTestObject('Manual/OrangeHRM/input_add_employee_confirmpassword'), GlobalVariable.add_employee_password)

WebUI.click(findTestObject('Manual/OrangeHRM/btn_add_employee_save'))

def actual = WebUI.getText(findTestObject('Manual/OrangeHRM/verify_add_employee_name_uploaded_profile'))

def expected = WebUI.getText(findTestObject('Manual/OrangeHRM/verify_add_employee_name_uploaded_profile'))

WebUI.verifyMatch(actual, expected, false)

WebUI.verifyElementVisible(findTestObject('Manual/OrangeHRM/verify_add_employee_uploaded_profile'))

WebUI.verifyElementAttributeValue(findTestObject('Manual/OrangeHRM/verify_add_employee_FName'), 'value', verify_add_employee_firstName, 
    0)

WebUI.verifyElementAttributeValue(findTestObject('Manual/OrangeHRM/verify_add_employee_MName'), 'value', firstName, 0)

WebUI.verifyElementAttributeValue(findTestObject('Manual/OrangeHRM/verify_add_employee_LName'), 'value', lastName, 0)

WebUI.verifyElementVisible(findTestObject('Manual/OrangeHRM/verify_add_employee_ID'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Manual/OrangeHRM/verify_panel_username'))

WebUI.click(findTestObject('Manual/OrangeHRM/btn_logout'))

WebUI.closeWindowUrl(GlobalVariable.url_OrangeHRM)

WebUI.closeBrowser()

