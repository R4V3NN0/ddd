package de.neusta.infracstructure

import de.neusta.domain.Raum
import de.neusta.domain.RaumNummer
import de.neusta.domain.RaumRepository
import jakarta.enterprise.context.ApplicationScoped
import java.util.ArrayList

@ApplicationScoped
class RaumRepositoryImpl: RaumRepository{

    private val liste = mutableListOf();

    override fun speichere(raum: Raum) {
        liste.add
        TODO("Not yet implemented")
    }

    override fun sucheNachRaumNummer(raumNummer: RaumNummer): Raum? {
        TODO("Not yet implemented")
    }
}
