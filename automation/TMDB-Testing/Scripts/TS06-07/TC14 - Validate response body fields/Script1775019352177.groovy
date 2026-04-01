import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.TestObject
import internal.GlobalVariable

// Call API
response = WS.sendRequest(findTestObject('Movie/GetMovieById', [
    ('BASE_URL'): GlobalVariable.BASE_URL,
    ('API_KEY') : GlobalVariable.API_KEY,
    ('id')      : 550
]))

WS.verifyResponseStatusCode(response, 200)

// Check important fields exist
WS.verifyElementPropertyValue(response, 'id', 550)
WS.verifyElementPropertyValue(response, 'title', 'Fight Club')

// Fields not empty
assert WS.getElementPropertyValue(response, 'overview').length() > 0