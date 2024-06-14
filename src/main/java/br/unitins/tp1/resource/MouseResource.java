package br.unitins.tp1.resource;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.tp1.dto.produto.MouseDTO;
import br.unitins.tp1.form.ImageForm;
import br.unitins.tp1.service.MouseService;
import br.unitins.tp1.service.imagem.MouseFileServiceImpl;
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
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/mouse")
public class MouseResource {
    
    @Inject
    public MouseService mouseService;

    @Inject
    public MouseFileServiceImpl fileService;

    @GET

    @Path("/{id}")
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findById(@PathParam("id") Long id) {
        Log.infof("Executando o metodo findById. Id: %s", id.toString()); 
        return Response.ok(mouseService.findById(id)).build();
    }

    @GET
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findAll() {
        Log.info("Executando o findAll");
        return Response.ok(mouseService.findAll()).build();
    }

    @GET
    @RolesAllowed({"Funcionario", "Cliente"})
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        Log.info("Executando o findByNome");
        return Response.ok(mouseService.findByNome(nome)).build();
    }

    @POST
    @RolesAllowed("Funcionario")
    public Response create(@Valid MouseDTO dto) {

        try {
            Log.infof("Mouse criado com sucesso. Nome: %d", dto.nome());
            return Response.status(Status.CREATED).entity(mouseService.create(dto)).build();
        } catch (Exception e) {
            Log.error("Falha ao Criar Mouse");
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PUT
    @Path("/{id}")
    @RolesAllowed("Funcionario")
    public Response update(@PathParam("id") Long id, MouseDTO dto) {
        Log.debugf("DTO Atualizado: %s", dto);
        mouseService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("Funcionario")
    public Response delete(@PathParam("id") Long id) {
        Log.infof("Deletando. Id: %s", id.toString());
        mouseService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @PATCH
    @Path("/{id}/image/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
     public Response upload(@PathParam("id") Long id, @MultipartForm ImageForm form) {
        Log.info("Fazendo upload de imagem");
        fileService.salvar(id, form.getNomeImagem(), form.getImagem());
        return Response.noContent().build();
     }

    @GET
    @Path("/image/download/{nomeImagem}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@PathParam("nomeImagem") String nomeImagem) {
        Log.info("Fazendo download de imagem");
        fileService.download(nomeImagem);
        ResponseBuilder response = Response.ok(fileService.download(nomeImagem));
        response.header("Content-Disposition", "attachment;filename=" + nomeImagem);
        return response.build();
    }
}
