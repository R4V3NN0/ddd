package de.neusta.infracstructure.dto

import de.neusta.domain.Raum

class GetRaumDto(val name: String, val nummer: String, val personen: List<String>) {
    constructor(raum: Raum, personen: List<String>) : this(raum.name.value, raum.nummer.value, personen) {
    }
}