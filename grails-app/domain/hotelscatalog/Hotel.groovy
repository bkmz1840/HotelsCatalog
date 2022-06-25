package hotelscatalog

class Hotel {
    String title
    Country country
    int rate
    String link

    static constraints = {
        title(nullable: false, blank: false, size: 1..255)
        rate(min: 1, max: 5)
        link(nullable: true, blank: true, matches: "(http://|https://)([a-zA-Z]|/|\\w|.)*")
    }

    String toString() {
        return title
    }
}
