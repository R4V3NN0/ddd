package de.neusta.domain

import java.util.*

// Aggregat
class Raum(
    val id: ID = ID(),
    val name: Name,
    val nummer: Nummer,
    val personen: MutableList<Person.ID> = mutableListOf()
) {
    infix fun fügePersonHinzu(id: Person.ID) {
        this.personen.add(id)
    }

    // Value-Objects
    data class ID(val value: UUID = UUID.randomUUID())
    data class Name(val value: String)
    data class Nummer(val value: String);
}
