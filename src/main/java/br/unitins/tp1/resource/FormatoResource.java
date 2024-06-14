package br.unitins.tp1.resource;

import br.unitins.tp1.dto.produto.FormatoDTO;
import br.unitins.tp1.service.FormatoService;
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
@Path("/formato")
public class FormatoResource {

    
    @Inject
    public FormatoService formatoService;

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findById(@PathParam("id") Long id) {
        Log.infof("Deletando cliente. Id: %s", id.toString());
        return Response.ok(formatoService.findById(id)).build();
    }

    @GET
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findAll() {
        Log.info("Executando o findAll");
        return Response.ok(formatoService.findAll()).build();
    }

    @POST
    @RolesAllowed("Funcionario")
    public Response create(@Valid FormatoDTO dto) {
        Log.info("Criando um novo Formato");
        return Response.status(Status.CREATED).entity(formatoService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed("Funcionario")
    public Response update(@PathParam("id") Long id, FormatoDTO dto) {
        Log.debugf("DTO Atualizado: %s", dto);
        formatoService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("Funcionario")
    public Response delete(@PathParam("id") Long id) {
        Log.infof("Deletando. Id: %s", id.toString());
        formatoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }


}
