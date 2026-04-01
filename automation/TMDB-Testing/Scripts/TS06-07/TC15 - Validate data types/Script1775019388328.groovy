import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import internal.GlobalVariable
import groovy.json.JsonSlurper

// --- Call API ---
def response = WS.sendRequest(findTestObject(
    'Movie/GetMovieById',
    [
        ('BASE_URL') : GlobalVariable.BASE_URL,
        ('API_KEY')  : GlobalVariable.API_KEY,
        ('id')       : 550
    ]
))

WS.verifyResponseStatusCode(response, 200)

// --- Parse JSON ---
def body = new JsonSlurper().parseText(response.getResponseText())

// --- Validate data type of each field ---

// string fields
assert body.title instanceof String
assert body.original_title instanceof String
assert body.overview instanceof String

// number fields
assert body.id instanceof Integer
assert body.budget instanceof Integer
assert body.revenue instanceof Integer
assert body.runtime instanceof Integer

// boolean fields
assert body.adult instanceof Boolean
assert body.video instanceof Boolean

// array fields
assert body.genres instanceof List
assert body.production_companies instanceof List
assert body.production_countries instanceof List
assert body.spoken_languages instanceof List

// object fields
assert body.belongs_to_collection == null || (body.belongs_to_collection instanceof Map)

// optional fields (may be null → treat as OK)
assert body.homepage == null || body.homepage instanceof String
assert body.tagline == null || body.tagline instanceof String

