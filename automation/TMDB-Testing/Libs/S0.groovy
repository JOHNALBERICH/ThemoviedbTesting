import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData


import com.katalon.execution.application.ExecutionMain

Map<String, String> suiteProperties = new HashMap<String, String>();

suiteProperties.put('rerunTestFailImmediately', 'true')
suiteProperties.put('retryCount', '3')
suiteProperties.put('name', 'TS06-07 - API')
suiteProperties.put('description', '')
suiteProperties.put('id', 'Test Suites/TS06-07 - API')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.windows.keyword.contribution.WindowsDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.testng.keyword.internal.TestNGDriverCleaner())



RunConfiguration.setExecutionSettingFile("D:\\Users\\Admin\\Desktop\\ThemoviedbTesting\\automation\\TMDB-Testing\\Reports\\20260409_204122\\TS06-07 - API\\20260409_204122\\execution.properties")

TestCaseMain.beforeStart()

new ExecutionMain().init();

TestCaseMain.startTestSuite('Test Suites/TS06-07 - API', suiteProperties, new File("D:\\Users\\Admin\\Desktop\\ThemoviedbTesting\\automation\\TMDB-Testing\\Reports\\20260409_204122\\TS06-07 - API\\20260409_204122\\testCaseBinding"))
