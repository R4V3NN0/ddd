package de.neusta.infracstructure

import de.neusta.domain.Raum
import de.neusta.domain.RaumRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class RaumRepositoryImpl : RaumRepository {

    private val liste: MutableList<Raum> = mutableListOf()

    override fun speichere(raum: Raum) {
        liste.remove(raum)
        liste.add(raum)
    }

    override fun sucheNachRaumNummer(raumNummer: Raum.Nummer): Raum? =
        liste.filter {
            it.nummer.value == raumNummer.value
        }.firstOrNull()

    override fun sucheNachId(raumId: Raum.ID): Raum? =
        liste.filter {
            it.id == raumId
        }.firstOrNull()
}
