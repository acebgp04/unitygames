package org.unity

class Sport {

    String name

    static hasMany = [categories: Category]

    String toString() {
        name
    }

    static constraints = {
    }
}
