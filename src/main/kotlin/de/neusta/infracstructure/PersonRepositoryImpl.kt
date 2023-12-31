package de.neusta.infracstructure

import de.neusta.domain.*
import jakarta.enterprise.context.ApplicationScoped
import java.util.*

@ApplicationScoped
class PersonRepositoryImpl : PersonRepository {

    private val liste: MutableList<Person> = mutableListOf()

    override fun speichere(person: Person): SpeicherErgebnis {
        sucheNachBenutzername(person.benutzername).apply { if (this.isPresent) return BenutzernameExistiertBereits }
        liste.add(person).let { return PersonWurdeGespeichert(person) }
    }

    override fun sucheNachBenutzername(benutzername: Person.Benutzername): Optional<Person> =
        liste.firstOrNull {
            it.benutzername == benutzername
        }?.let { Optional.of(it) } ?: Optional.empty()

    override fun sucheNachId(personId: Person.ID): Optional<Person> =
        liste.firstOrNull {
            it.id == personId
        }?.let { Optional.of(it) } ?: Optional.empty()

}
