package org.unity

class Sport {

    String name

    static hasMany = [categories: Category]

    String toString() {
        name
    }

    static constraints = {
        name(nullable: false, unique: true)
        categories(nullable: true)
    }
}
