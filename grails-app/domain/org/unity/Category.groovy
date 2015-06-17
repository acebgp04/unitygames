package org.unity

class Category {

    String name
    String CFO = ""
    String venue
    Date dateOfEvent
    static belongsTo = [sport: Sport]

    String toString() {
        (sport ? sport.name + " : ${CFO} - " + name : name)
    }
    static constraints = {
        name()
        venue()
        dateOfEvent()
    }
}
