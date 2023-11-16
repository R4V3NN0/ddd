package de.neusta.infracstructure.resources

import de.neusta.application.GibRaumMitKurzschreibweise
import de.neusta.application.PersonHinzufügen
import de.neusta.application.RaumService
import de.neusta.domain.Person
import de.neusta.domain.Raum
import de.neusta.infracstructure.dto.RaumDto
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import java.util.*

@Path("/api/room")
class RoomResource(
    private val raumService: RaumService,
    private val personHinzufügen: PersonHinzufügen,
    private val gibRaumMitKurzschreibweise: GibRaumMitKurzschreibweise
) {

    // TODO: Change aggregate to response dto
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun `raum erstellen`(
        erstellenDto: RaumDto
    ): Response = raumService.erzeugeRaum(erstellenDto.name, erstellenDto.raumNummer).let {
        if (it == null) return Response.status(Response.Status.BAD_REQUEST).build()
        return Response.ok(it).build()
    }

    @PUT
    @Path("/{raumId}/person/{personId}")
    fun `hizufügen einer Person`(
        @PathParam("raumId")
        raumId: String,
        @PathParam("personId")
        personId: String
    ): Response = personHinzufügen(Raum.ID(UUID.fromString(raumId)), Person.ID(UUID.fromString(personId))).let {
        when (it) {
            is PersonHinzufügen.Erfolg -> return Response.ok().build()
            else -> return Response.status(Response.Status.BAD_REQUEST).build()
        }
    }

    @GET
    @Path("/{raumId}")
    @Produces(MediaType.APPLICATION_JSON)
    fun `raum abfragen`(
        @PathParam("raumId")
        raumId: String
    ): Response = gibRaumMitKurzschreibweise(Raum.ID(UUID.fromString(raumId)))?.let { Response.ok(it).build() }
        ?: Response.status(Response.Status.BAD_REQUEST).build()
}