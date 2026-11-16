import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.llm.keyword.LlmKeywords as LLM
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

WebUI.openBrowser(null)

WebUI.navigateToUrl('https://iyusportalmv.github.io/iyus-frontend-form-js/')

WebUI.setText(findTestObject('Page_Form Pendaftaran/input_Masukkan nama Anda'), 'Iyus Somantri')

WebUI.setText(findTestObject('Page_Form Pendaftaran/input_Masukkan email Anda'), 'iyus-qa@example.com')

WebUI.setText(findTestObject('Page_Form Pendaftaran/input_Masukkan nomor handphone Anda'), '087701101989')

// Membaca soal CAPTCHA acak dan menghitung jawabannya secara otomatis
String soalCaptcha = WebUI.getText(findTestObject('Page_Form Pendaftaran/label_Captcha'))
def matcher = (soalCaptcha =~ /(\d+)\s*([+\-×*xX\/÷])\s*(\d+)/)
int hasilCaptcha = 0
if (matcher.find()) {
	int angka1 = matcher.group(1).toInteger()
	String operator = matcher.group(2)
	int angka2 = matcher.group(3).toInteger()
	switch (operator) {
		case '+': hasilCaptcha = angka1 + angka2; break
		case '-': hasilCaptcha = angka1 - angka2; break
		case ['×', '*', 'x', 'X']: hasilCaptcha = angka1 * angka2; break
		case ['/', '÷']: hasilCaptcha = angka1.intdiv(angka2); break
	}
}
WebUI.setText(findTestObject('Page_Form Pendaftaran/input_Masukkan jawaban'), hasilCaptcha.toString())

WebUI.click(findTestObject('Page_Form Pendaftaran/button_Kirim'))

WebUI.verifyElementPresent(findTestObject('Page_Halaman Konfirmasi/h2_greeting'), 10)

WebUI.closeBrowser()