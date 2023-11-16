package de.neusta.application

import de.neusta.domain.PersonRepository
import de.neusta.domain.Raum
import de.neusta.domain.RaumRepository
import jakarta.enterprise.context.ApplicationScoped


@ApplicationScoped
class RaumService(private val raumRepository: RaumRepository, private val personRepository: PersonRepository) {

    fun erzeugeRaum(raumName: String, raumNummer: String): Raum? {
        if (!istRaumNummerValide(raumNummer)) return null;
        if (existiertRaumNummerBereits(raumNummer)) return null;
        Raum(name = Raum.Name(raumName), nummer = Raum.Nummer(raumNummer)).let {
            raumRepository.speichere(it);
            return it;
        }
    }

    private fun istRaumNummerValide(raumNummer: String): Boolean {
        //TODO: Refactor
        return raumNummer.length == 4;
    }

    private fun existiertRaumNummerBereits(raumNummer: String): Boolean {
        return raumRepository.sucheNachRaumNummer(Raum.Nummer(raumNummer)) != null;
    }

    fun raumAbfragen(raumId: Raum.ID): Raum? = raumRepository.sucheNachId(raumId)
}
