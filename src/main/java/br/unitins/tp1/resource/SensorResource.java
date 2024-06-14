package br.unitins.tp1.resource;

import br.unitins.tp1.dto.produto.SensorDTO;
import br.unitins.tp1.service.SensorService;
import io.quarkus.logging.Log;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/sensor")
public class SensorResource {
    
    @Inject
    public SensorService sensorService;

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findById(@PathParam("id") Long id) {
        Log.infof("Executando o metodo findById. Id: %s", id.toString()); 
        return Response.ok(sensorService.findById(id)).build();
    }

    @GET
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findAll() {
        Log.info("Executando o findAll");
        return Response.ok(sensorService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findByNome(@PathParam("nome") String nome) {
        Log.info("Executando o findByNome");
        return Response.ok(sensorService.findByNome(nome)).build();
    }

    @POST
    @RolesAllowed("Funcionario")
    public Response create(@Valid SensorDTO dto) {
        Log.info("Criando um novo sensor");
        return Response.status(Status.CREATED).entity(sensorService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed("Funcionario")
    public Response update(@PathParam("id") Long id, SensorDTO dto) {
        Log.debugf("DTO Atualizado: %s", dto);
        sensorService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("Funcionario")
    public Response delete(@PathParam("id") Long id) {
        Log.infof("Deletando. Id: %s", id.toString());
        sensorService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}
