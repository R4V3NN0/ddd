package de.neusta.application.dto

import de.neusta.domain.Raum

class GetRaumDto(val name: String, val nummer: String, val personen: List<String>) {
    constructor(raum: Raum) : this(raum.name, raum.nummer.nummer, raum.personen.map { person -> person.berechneKurzschreibweise() }) {
    }
}