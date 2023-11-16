package de.neusta.application.dto

import de.neusta.domain.Person

data class PersonDto(val benutzername: Person.Benutzername,
                     val vorname: Person.Vorname,
                     val name: Person.Name,
                     val namenszusatz: Person.Namenszusatz? = null) {

    fun toDomain(): Person = Person(
        benutzername = benutzername,
        vorname = vorname,
        name = name,
        namenszusatz = namenszusatz
    )
}