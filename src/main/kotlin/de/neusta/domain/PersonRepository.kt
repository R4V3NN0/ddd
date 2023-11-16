package de.neusta.domain

import java.util.*

interface PersonRepository {
    fun speichere(person: Person): SpeicherErgebnis;
    fun sucheNachBenutzername(benutzername: Person.Benutzername): Optional<Person>
    fun sucheNachId(personId: Person.ID): Optional<Person>

}

sealed class SpeicherErgebnis()
data class PersonWurdeGespeichert(val person: Person) : SpeicherErgebnis()
data object BenutzernameExistiertBereits : SpeicherErgebnis()
