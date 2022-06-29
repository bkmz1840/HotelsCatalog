package hotelscatalog

class FoundHotelController {

    def index() {
        render(view: "/layouts/index", model: [countries: Country.all])
    }

    def foundHotels(String hotelTitle, long countryId) {
        if (hotelTitle != null && !hotelTitle.isEmpty() && countryId != -1) {
            def hotels = Hotel.withCriteria {
                country {
                    eq("id", countryId)
                }
                ilike("title", "%" + hotelTitle + "%")
                and {
                    order("rate", "desc")
                    order("title")
                }
            }
            render(view: "/layouts/foundHotels", model: [hotels: hotels])
        } else render(view: "/layouts/foundHotels")
    }
}
