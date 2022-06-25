package hotelscatalog

class Country {
    String title
    String capital

    static constraints = {
        title(nullable: false, blank: false, size: 1..255)
        capital(nullable: false, blank: false, size: 1..128)
    }

    String toString() {
        return title
    }
}
