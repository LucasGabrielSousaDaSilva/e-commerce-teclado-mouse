package br.unitins.tp1.resource;

import br.unitins.tp1.dto.produto.ConstrucaoDTO;
import br.unitins.tp1.service.ConstrucaoService;
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
@Path("/construcao")
public class ConstrucaoResource {
    
    @Inject
    public ConstrucaoService construcaoService;

    @GET
    @Path("/{id}")
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findById(@PathParam("id") Long id) {
    Log.infof("Executando o metodo findById. Id: %s", id.toString()); 
        return Response.ok(construcaoService.findById(id)).build();
    }

    @GET
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findAll() {
        Log.info("Executando o findAll");
        return Response.ok(construcaoService.findAll()).build();
    }

    @GET
    @Path("/search/cor/{cor}")
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findByCor(@PathParam("cor") String cor) {
        Log.info(cor);
        return Response.ok(construcaoService.findByCor(cor)).build();
    }

    @POST
    @RolesAllowed("Funcionario")
    public Response create(@Valid ConstrucaoDTO dto) {
        Log.info("Criando uma nova Construção");
        return Response.status(Status.CREATED).entity(construcaoService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed("Funcionario")
    public Response update(@PathParam("id") Long id, ConstrucaoDTO dto) {
        Log.debugf("DTO Atualizado: %s", dto);
        construcaoService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("Funcionario")
    public Response delete(@PathParam("id") Long id) {
        Log.infof("Deletando. Id: %s", id.toString());
        construcaoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }


}
