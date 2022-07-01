package hotelscatalog

class FoundHotelController {

    def index() {
        render(view: "/layouts/index", model: [countries: Country.all])
    }

    def foundHotels() {
        def hotelTitle = params.hotelTitle
        def countryId = params.countryId as Long
        def criteria = Hotel.createCriteria()
        def hotels = criteria.list {
            if (hotelTitle && countryId != -1) {
                country {
                    eq("id", countryId)
                }
                ilike("title", "%" + hotelTitle + "%")
                and {
                    order("rate", "desc")
                    order("title")
                }
            }
        }
        render(view: "/layouts/foundHotels", model: [hotels: hotels])
    }
}
