package de.neusta.domain

// Aggregat
class Raum(val name: String, val nummer: RaumNummer, var personen: List<Person> = mutableListOf()) {
    infix fun fügePersonHinzu(person: Person) {
        personen += person
    }

    data class RaumNummer (val nummer: String);
}
