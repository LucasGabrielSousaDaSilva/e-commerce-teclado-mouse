package br.unitins.tp1.resource;

import br.unitins.tp1.dto.pedido.FormaPagamentoDTO;
import br.unitins.tp1.service.pedido.FormaPagamentoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/formas Pagamentos")
public class FormaPagamentoResource {
    
    @Inject
    public FormaPagamentoService formaPagamentoService;


    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") long id){
        return Response.ok(formaPagamentoService.findById(id)).build();
    }

    @GET
    public Response findAll(){
        return Response.ok(formaPagamentoService.findAll()).build();
    }

    @POST
    public Response create(FormaPagamentoDTO dto) {
        return Response.status(Status.CREATED).entity(formaPagamentoService.create(dto)).build();
    }
}
