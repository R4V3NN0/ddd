package de.neusta.domain

interface RaumRepository {

    fun speichere(raum: Raum);
    fun sucheNachRaumNummer(raumNummer: Raum.Nummer): Raum?

    fun sucheNachId(raumId: Raum.ID): Raum?
}
