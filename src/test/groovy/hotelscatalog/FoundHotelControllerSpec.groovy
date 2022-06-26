package hotelscatalog

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class FoundHotelControllerSpec
        extends Specification
        implements ControllerUnitTest<FoundHotelController>, DataTest
{
    Class<?>[] getDomainClassesToMock() {
        [Hotel, Country] as Class<?>[]
    }

    def setup() {
        def country = new Country(title: "Турция", capital: "Анкара")
        def hotels = [
                new Hotel(
                        title: "Novotel Istanbul Bosphorus Hotel",
                        rate: 5,
                        country: country,
                        link: "https://www.novotelistanbulbosphorus.com"
                ),
                new Hotel(
                        title: "Swissotel The Bosphorus Istanbul",
                        rate: 5,
                        country: country,
                        link: "https://www.swissotel-hotels.ru/hotels/istanbul"
                ),
                new Hotel(
                        title: "ISG Sabiha Gökçen Airport Hotel",
                        rate: 4,
                        country: country,
                        link: "https://www.isgairporthotel.com/ru/"
                )
        ]
        mockDomain(Country, [country])
        mockDomain(Hotel, hotels)
    }

    void "test get hotels by country and title"() {
        given:
        def expected = [
                Hotel.find {title == "Novotel Istanbul Bosphorus Hotel"},
                Hotel.find {title == "ISG Sabiha Gökçen Airport Hotel"}
        ]
        def countryId = Country.find {title == "Турция"}.id

        when: 'The found hotels action is executed'
        controller.foundHotels("Hotel", countryId)

        then: 'The model is correct'
        model.hotels
        model.hotels == expected
    }

    void "test get hotels by country"() {
        given:
        def expected = Hotel.findAll {country.title == "Турция"}

        when:
        controller.foundHotels(
                "",
                Country.find {title == "Турция"}.id
        )

        then: 'The model is correct'
        model.hotels
        model.hotels == expected
    }

    void "test get hotels by title"() {
        given:
        def expected = [
                Hotel.find {title == "Novotel Istanbul Bosphorus Hotel"},
                Hotel.find {title == "ISG Sabiha Gökçen Airport Hotel"}
        ]

        when:
        controller.foundHotels("Hotel", -1)

        then: 'The model is correct'
        model.hotels
        model.hotels == expected
    }

    void "test index action"() {
        given:
        def expectedCountries = Country.all

        when:
        controller.index()

        then: 'The view and the model is correct'
        model.countries
        model.countries == expectedCountries
        view == "/layouts/index"
    }
}
