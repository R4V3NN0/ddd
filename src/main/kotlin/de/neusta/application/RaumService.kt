package de.neusta.application

import de.neusta.domain.Raum
import de.neusta.domain.RaumRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import jakarta.ws.rs.ApplicationPath


@ApplicationScoped
class RaumService {

    @Inject
    private lateinit var repository: RaumRepository;

    @Transactional
    fun erzeugeRaum(raumName: String, raumNummer: String) : Raum? {
        if(!istRaumNummerValide(raumNummer)) return null;
        if(existiertRaumNummerBereits(raumNummer)) return null;
        Raum(raumName, Raum.RaumNummer(raumNummer)).let {
            repository.speichere(it);
            return it;
        }
    }


    private fun istRaumNummerValide(raumNummer: String) : Boolean {
        //TODO: Refactor
        return raumNummer.length == 4;
    }

    private fun existiertRaumNummerBereits(raumNummer: String) : Boolean {
        return repository.sucheNachRaumNummer(Raum.RaumNummer(raumNummer)) != null;
    }

    fun raumAbfragen(raumNummer: String): Raum? = repository.sucheNachRaumNummer(Raum.RaumNummer(raumNummer))
}
