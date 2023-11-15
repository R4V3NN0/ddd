package de.neusta.domain

interface RaumRepository {

    fun speichere(raum: Raum);
    fun sucheNachRaumNummer(raumNummer: RaumNummer) : Raum?
}
