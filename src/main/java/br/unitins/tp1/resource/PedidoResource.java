package br.unitins.tp1.resource;

import br.unitins.tp1.dto.pedido.PedidoDTO;
import br.unitins.tp1.service.pedido.PedidoService;
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
@Path("/pedidos")
public class PedidoResource {
    
    @Inject
    public PedidoService pedidoService;


    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") long id){
        return Response.ok(pedidoService.findById(id)).build();
    }

    @GET
    public Response findAll(){
        return Response.ok(pedidoService.findAll()).build();
    }

    @GET
    @Path("/search/cliente/{cliente}")
    public Response findByCliente(@PathParam("cliente") Long cliente){
        return Response.ok(pedidoService.findByCliente(cliente)).build();
    }

    @POST
    public Response create(PedidoDTO dto) {
        return Response.status(Status.CREATED).entity(pedidoService.create(dto)).build();
    }
}
