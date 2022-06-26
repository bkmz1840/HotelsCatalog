package hotelscatalog

import geb.spock.GebSpec
import grails.testing.mixin.integration.Integration

@Integration
class HomeSpec extends GebSpec {

    void "Test the home page renders correctly"() {
        when: "The home page is visited"
        go '/'

        then: "The title is correct"
        $('title').text() == "Каталог отелей"
        $('.navbar-brand').text() == "Каталог отелей"
    }
}
