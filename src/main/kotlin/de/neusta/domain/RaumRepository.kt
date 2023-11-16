package de.neusta.domain

interface RaumRepository {

    fun speichere(raum: Raum);
    fun sucheNachRaumNummer(raumNummer: Raum.RaumNummer) : Raum?
}
