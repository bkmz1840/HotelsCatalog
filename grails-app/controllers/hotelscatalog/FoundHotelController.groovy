package hotelscatalog

class FoundHotelController {

    def index() {
        render(view: "/layouts/index", model: [countries: Country.all])
    }

    def foundHotels(String hotelTitle, long countryId) {
        def model = []
        if (hotelTitle != null && !hotelTitle.isEmpty() && countryId != -1) {
            model = [
                    hotels: Hotel.withCriteria {
                        country {
                            eq("id", countryId)
                        }
                        ilike("title", "%" + hotelTitle + "%")
                        and {
                            order("rate", "desc")
                            order("title")
                        }
                    }
            ]
        } else if (hotelTitle != null && countryId != -1 && hotelTitle.isEmpty()) {
            model = [
                    hotels: Hotel.findAll {
                        country.id == countryId
                    }
            ]
        } else if (hotelTitle != null && countryId == -1 && !hotelTitle.isEmpty()) {
            model = [
                    hotels: Hotel.withCriteria {
                        ilike("title", "%" + hotelTitle + "%")
                        and {
                            order("rate", "desc")
                            order("title")
                        }
                    }
            ]
        }
        render(view: "/layouts/foundHotels", model: model)
    }
}
