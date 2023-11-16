package de.neusta.infracstructure.resources

import de.neusta.application.PersonHinzufügen
import de.neusta.application.RaumService
import de.neusta.application.dto.GetRaumDto
import de.neusta.application.dto.PersonDto
import de.neusta.application.dto.RaumDto
import jakarta.inject.Inject
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.PUT
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/api/room")
class RoomResource {

    @Inject
    private lateinit var raumService: RaumService

    @Inject
    private lateinit var personHinzufügen: PersonHinzufügen

    // TODO: Change aggregate to response dto
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    fun `raum erstellen`(
        erstellenDto: RaumDto
    ): Response = raumService.erzeugeRaum(erstellenDto.name, erstellenDto.raumNummer).let {
        if (it == null) return Response.status(Response.Status.BAD_REQUEST).build()
        return Response.ok(it).build()
    }

    @PUT
    @Path("/{raum_nummer}/person")
    fun `hizufügen einer Person`(
        @PathParam("raum_nummer")
        raumNummer: String,
        personDto: PersonDto
    ): Response = personHinzufügen(raumNummer, personDto).let {
        if (it == null) return Response.status(Response.Status.BAD_REQUEST).build()
        return Response.ok().build()
    }

    @GET
    @Path("/{raum_nummer}")
    @Produces(MediaType.APPLICATION_JSON)
    fun `raum abfragen`(
        @PathParam("raum_nummer")
        raumNummer: String
    ): Response = raumService.raumAbfragen(raumNummer).let {
        if (it == null) return Response.status(Response.Status.BAD_REQUEST).build()
        return Response.ok(GetRaumDto(it)).build()
    }
}