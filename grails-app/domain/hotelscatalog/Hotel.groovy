package hotelscatalog

class Hotel {
    String title
    int rate
    String link

    static belongsTo = [country: Country]

    static constraints = {
        title(nullable: false, blank: false, size: 1..255)
        rate(min: 1, max: 5)
        link(
                nullable: true,
                blank: true,
                matches: "(http://|https://)(/|\\w|\\.|\\?|=|#|-)*"
        )
    }

    String toString() {
        return title
    }
}
