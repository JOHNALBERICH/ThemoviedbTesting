import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.TestObject
import internal.GlobalVariable

// Call API
response = WS.sendRequest(findTestObject('Movie/GetMovieById', [
    ('BASE_URL'): GlobalVariable.BASE_URL,
    ('API_KEY') : GlobalVariable.API_KEY,
    ('id')      : 99999999999999999999999
]))

WS.verifyResponseStatusCode(response, 404)

import groovy.json.JsonOutput
def jsonPretty = JsonOutput.prettyPrint(response.getResponseBodyContent())
println(jsonPretty)