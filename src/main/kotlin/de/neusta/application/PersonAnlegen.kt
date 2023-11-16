package de.neusta.application

import de.neusta.domain.Person
import de.neusta.domain.PersonRepository
import de.neusta.domain.PersonWurdeGespeichert
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class PersonAnlegen(private val repository: PersonRepository) {

    operator fun invoke(person: Person): Person? {
        if (existiertPersonBereits(person.benutzername)) {
            return null
        }

        repository.speichere(person).let {
            return when (it) {
                is PersonWurdeGespeichert -> person
                else -> null
            }
        }
    }


    private fun existiertPersonBereits(benutzername: Person.Benutzername): Boolean =
        repository.sucheNachBenutzername(benutzername).isPresent

}