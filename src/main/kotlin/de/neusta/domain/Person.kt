package de.neusta.domain

import java.util.UUID

// Aggregat
class Person(
    val id: ID = ID(),
    val benutzername: Benutzername,
    val vorname: Vorname,
    val name: Name,
    val namenszusatz: Namenszusatz? = null
) {


    // Value-Objects
    data class ID(val value: UUID = UUID.randomUUID())
    data class Vorname(val value: String)
    data class Namenszusatz(val value: String) {

        // TODO: Custom constructor für data class möglich?
        init {
            ErlaubteNamenszusätze.valueOf(value)
        }
        enum class `ErlaubteNamenszusätze`(val value: String) {
            VON("von"),
            VAN("van"),
            DE("de")
        }
    }
    data class Name(val value: String)
    data class Benutzername(val value: String)
    data class Kurzschreibweise(val value: String)

     fun berechneKurzschreibweise(): String {
        val builder = StringBuilder()
        builder.append(vorname.value).append(" ")
        if (namenszusatz != null) builder.append(namenszusatz.value).append(" ")
        builder.append(name.value).append(" ")
        builder.append("(${benutzername.value})")
        return builder.toString()
    }

}