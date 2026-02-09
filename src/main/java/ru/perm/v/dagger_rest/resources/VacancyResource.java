package ru.perm.v.dagger_rest.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ru.perm.v.dagger_rest.dto.VacancyDTO;
import ru.perm.v.dagger_rest.entity.VacancyEntity;
import ru.perm.v.dagger_rest.mappers.VacancyMapper;
import ru.perm.v.dagger_rest.services.VacancyService;

import javax.inject.Inject;

@Path("/vacancy")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VacancyResource {
    VacancyService vacancyService;
    VacancyMapper vacancyMapper = new VacancyMapper();
    @Inject
    public VacancyResource(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }
    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        if (id == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        VacancyEntity vacancy = vacancyService.getVacancyById(id);
        return Response.ok(vacancyMapper.toDTO(vacancy)).build();
    }
}
