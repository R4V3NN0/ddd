package de.neusta.domain

import java.util.UUID

// Entity
class Person(
    val id: UUID,
    val benutzername: Benutzername,
    val vorname: Vorname,
    val name: Name,
    val namenszusatz: Namenszusatz? = null
) {


    // Value-Objects
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
        builder.append(vorname).append(" ")
        if (namenszusatz != null) builder.append(namenszusatz).append(" ")
        builder.append(name).append(" ")
        builder.append("($benutzername)")
        return builder.toString()
    }

}