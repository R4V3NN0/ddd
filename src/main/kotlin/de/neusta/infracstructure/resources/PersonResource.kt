package de.neusta.infracstructure.resources

import de.neusta.application.PersonAnlegen
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/api/person")
class PersonResource(private val personAnlegen: PersonAnlegen) {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    fun `person erstellen`(
        dto: PersonErstellenDto
    ): Response =
        personAnlegen(dto.toDomain())?.let { Response.ok(it).build() }
            ?: Response.status(Response.Status.BAD_REQUEST).build()
}