package hotelscatalog

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'foundHotel')
        "/found-hotels/"(controller: 'foundHotel', action: 'foundHotels')
        "/country/"(controller: 'country')
        "/hotel/"(controller: 'hotel')
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
