package hotelscatalog

class Country {
    String title
    String capital

    static hasMany = [hotels: Hotel]

    static constraints = {
        title(nullable: false, blank: false, unique: true, size: 1..255)
        capital(nullable: false, blank: false, size: 1..128)
    }

    String toString() {
        return title
    }
}
