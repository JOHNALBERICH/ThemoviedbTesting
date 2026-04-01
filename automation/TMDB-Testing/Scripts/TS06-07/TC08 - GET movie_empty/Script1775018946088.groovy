import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.TestObject
import internal.GlobalVariable

// Call API
response = WS.sendRequest(findTestObject('Movie/SearchMovie', [
    ('BASE_URL'): GlobalVariable.BASE_URL,
    ('API_KEY') : GlobalVariable.API_KEY,
    ('query')   : '',
    ('page')    : 1
]))

WS.verifyResponseStatusCode(response, 200)
println(response.getResponseBodyContent())