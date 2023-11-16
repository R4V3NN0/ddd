package de.neusta.application

import de.neusta.application.dto.PersonDto
import de.neusta.domain.Person
import de.neusta.domain.Raum
import de.neusta.domain.RaumRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject

@ApplicationScoped
class PersonHinzufügen {

    @Inject
    private lateinit var repository: RaumRepository;

    operator fun invoke(raumNummer: String, person: PersonDto): Raum? {
        val raum = repository.sucheNachRaumNummer(Raum.RaumNummer(raumNummer)) ?: return null
        raum fügePersonHinzu person.toDomain()
        repository.speichere(raum)
        return raum
    }
}