package br.unitins.tp1.resource;

import br.unitins.tp1.dto.pessoa.ClienteDTO;
import br.unitins.tp1.dto.update.UpdateSenhaDTO;
import br.unitins.tp1.dto.update.UpdateUsernameDTO;
import br.unitins.tp1.service.pessoa.ClienteService;
import io.quarkus.logging.Log;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
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
@Path("/funcionarios")
public class FuncionarioResource {

    @Inject
    public ClienteService clienteService;

    @GET
    @Path("/{id}")
    @RolesAllowed("Funcionario")
    public Response findById(@PathParam("id") Long id) {
        Log.infof("Deletando cliente. Id: %s", id.toString());
        return Response.ok(clienteService.findById(id)).build();
    }

    @GET
    @RolesAllowed("Funcionario")
    public Response findAll() {
        Log.info("Executando o findAll");
        return Response.ok(clienteService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    @RolesAllowed("Funcionario")
    public Response findByNome(@PathParam("nome") String nome) {
        Log.info("Executando o findByNome");
        return Response.ok(clienteService.findByNome(nome)).build();
    }

    @POST
    @RolesAllowed("Funcionario")
    public Response create(@Valid ClienteDTO dto) {
        Log.infof("Funcionario criado com sucesso. Nome: %d", dto.nome());
        return Response.status(Status.CREATED).entity(clienteService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed("Funcionario")
    public Response update(@PathParam("id") Long id, ClienteDTO dto) {
        Log.debugf("DTO Atualizado: %s", dto);
        clienteService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("Funcionario")
    public Response delete(@PathParam("id") Long id) {
        Log.infof("Deletando. Id: %s", id.toString());
        clienteService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @PATCH
    @Path("/update-password/{id}")
    @RolesAllowed("Funcionario")
    public Response updateUsuarioSenha(@PathParam("id") Long id, UpdateSenhaDTO dto){
        Log.info("Atualizando senha");
        clienteService.updateUsuarioPassword(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @PATCH
    @Path("/update-username/{id}")
    @RolesAllowed("Funcionario")
    public Response updateUsuarioUsername(@PathParam("id") Long id, UpdateUsernameDTO dto){
        Log.info("Atualizando username");
        clienteService.updateUsuarioUsername(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }
}
