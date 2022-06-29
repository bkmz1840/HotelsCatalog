package hotelscatalog

import groovy.json.JsonSlurper

class BootStrap {

    private LinkedHashMap<String, Country> createCountries() {
        def countries = [
                "Россия": "Москва",
                "Азербайджан": "Баку",
                "Багамы": "Нассау",
                "Грузия": "Тбилиси",
                "Египет": "Каир",
                "Израиль": "Иерусалим",
                "Испания": "Мадрид",
                "ОАЭ": "Абу-Даби",
                "Турция": "Анкара",
        ]
        LinkedHashMap<String, Country> countriesModels = []
        countries.each {
            def country = Country.create()
            country.title = it.key
            country.capital = it.value
            country.save()
            countriesModels[it.key] = country
        }
        return countriesModels
    }

    private def createHotels(LinkedHashMap<String, Country> countries) {
        def hotelsFile = new File("./grails-app/init/hotelscatalog/hotels.json")
        def jsonSlurper = new JsonSlurper()
        def obj = jsonSlurper.parse(hotelsFile)
        countries.each {pair ->
            obj[pair.key].each { hotelObj ->
                def hotel = Hotel.create()
                hotel.title = hotelObj["title"]
                hotel.country = pair.value
                hotel.rate = hotelObj["rate"] as int
                if (hotelObj.containsKey("link"))
                    hotel.link = hotelObj["link"]
                hotel.save()
            }
        }
    }

    def init = { servletContext ->
        Hotel.deleteAll()
        Country.deleteAll()
        def countries = createCountries()
        createHotels(countries)
    }
    def destroy = {
    }
}
