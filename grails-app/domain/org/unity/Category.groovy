package org.unity

class Category {

    String name
    String CFO = ""
    String venue
    Date dateOfEvent
    static belongsTo = [sport: Sport]

    String toString() {
        name
    }
    static constraints = {
        name()
        venue(nullable: true)
        dateOfEvent(nullable: true)
        sport(nullable: true)
    }
}
