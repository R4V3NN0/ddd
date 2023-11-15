package de.neusta.infracstructure

import de.neusta.domain.Raum
import de.neusta.domain.RaumNummer
import de.neusta.domain.RaumRepository
import jakarta.enterprise.context.ApplicationScoped
import java.util.ArrayList

@ApplicationScoped
class RaumRepositoryImpl: RaumRepository{

    private val liste: MutableList<Raum> = mutableListOf();

    override fun speichere(raum: Raum) {
        liste.add(raum)
    }

    override fun sucheNachRaumNummer(raumNummer: RaumNummer): Raum? =
        liste.filter {
            it.nummer.nummer == raumNummer.nummer
        }.firstOrNull()
}
