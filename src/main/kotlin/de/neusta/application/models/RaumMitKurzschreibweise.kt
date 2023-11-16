package de.neusta.application.models

import de.neusta.domain.Raum

data class RaumMitKurzschreibweise(
    val name: Raum.Name,
    val nummer: Raum.Nummer,
    val personen: List<String>
)
