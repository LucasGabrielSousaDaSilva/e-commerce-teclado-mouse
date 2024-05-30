package br.unitins.tp1.resource;

import br.unitins.tp1.dto.produto.ConstrucaoDTO;
import br.unitins.tp1.service.ConstrucaoService;
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
@Path("/construcao")
public class ConstrucaoResource {
    
    @Inject
    public ConstrucaoService construcaoService;

    @GET

    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(construcaoService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(construcaoService.findAll()).build();
    }

    @GET
    @Path("/search/cor/{cor}")
    public Response findByCor(@PathParam("cor") String cor) {
        return Response.ok(construcaoService.findByCor(cor)).build();
    }

    @POST
    public Response create(@Valid ConstrucaoDTO dto) {
        return Response.status(Status.CREATED).entity(construcaoService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, ConstrucaoDTO dto) {
        construcaoService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        construcaoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }


}
