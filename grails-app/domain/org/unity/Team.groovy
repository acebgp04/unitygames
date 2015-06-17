package org.unity

class Team {
    transient springSecurityService
    String name
    static hasMany = [players: Player]

    String toString() {
        name
    }
    static constraints = {
        name()
    }

}