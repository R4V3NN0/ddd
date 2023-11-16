package de.neusta.application

import de.neusta.domain.Person
import de.neusta.domain.PersonRepository
import de.neusta.domain.Raum
import de.neusta.domain.RaumRepository
import jakarta.enterprise.context.ApplicationScoped
import kotlin.jvm.optionals.getOrNull

@ApplicationScoped
class PersonHinzufügen(private val repository: RaumRepository, private val personRepository: PersonRepository) {

    operator fun invoke(raumId: Raum.ID, personId: Person.ID): Ergebnis {
        val raum = repository.sucheNachId(raumId) ?: return RaumNichtGefunden
        val person = personRepository.sucheNachId(personId).getOrNull() ?: return PersonNichtGefunden
        raum fügePersonHinzu person.id
        repository.speichere(raum)
        return Erfolg
    }

    sealed class Ergebnis

    data object RaumNichtGefunden : Ergebnis()
    data object PersonNichtGefunden : Ergebnis()
    data object Erfolg : Ergebnis()
}