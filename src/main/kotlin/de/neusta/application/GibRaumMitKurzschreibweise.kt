package de.neusta.application

import de.neusta.application.models.RaumMitKurzschreibweise
import de.neusta.domain.PersonRepository
import de.neusta.domain.Raum
import de.neusta.domain.RaumRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class GibRaumMitKurzschreibweise(
    private val raumRepository: RaumRepository,
    private val personRepository: PersonRepository
) {

    operator fun invoke(raumId: Raum.ID): RaumMitKurzschreibweise? {
        val raum = raumRepository.sucheNachId(raumId) ?: return null
        return RaumMitKurzschreibweise(raum.name, raum.nummer, raum.personen.map {
            personRepository.sucheNachId(it)
        }.filter { it.isPresent }.map { it.get().berechneKurzschreibweise() })
    }
}