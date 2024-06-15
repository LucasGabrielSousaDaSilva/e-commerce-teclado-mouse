package br.unitins.tp1.resource;

import static io.restassured.RestAssured.given;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.pedido.ItemPedidoDTO;
import br.unitins.tp1.dto.pedido.PedidoDTO;
import br.unitins.tp1.service.pedido.PedidoService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class PedidoResourceTest {
    
    @Inject
    public PedidoService service;

    @Test
    public void findAllTest() {
        given()
                .when()
                .get("/pedidos")
                .then()
                .statusCode(200);
    }

    @Test
    public void findByIdTest() {
        given()
                .when()
                .get("/pedidos/1")
                .then()
                .statusCode(200);
    }

    // @Test
    // public void findByClienteTest(){
    //     given()
    //             .when()
    //             .get("/pedidos/search/cliente/2")
    //             .then()
    //             .statusCode(200)
    //             .body("nome",is(2));
    // }

    @Test
    public void createTest() {

        List<ItemPedidoDTO> itens = new ArrayList<ItemPedidoDTO>();
        
        ItemPedidoDTO item = new ItemPedidoDTO(10.20, 2.1, 5, 1l);
        itens.add(item);

        PedidoDTO dto = new PedidoDTO(
                8.1, LocalDate.now(), 
                2, 1, 2l, 1l, 
                itens);

        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .post("/pedidos")
                .then()
                .statusCode(201);

    }

}
