package br.unitins.tp1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.pedido.FormaPagamentoDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class FormaPagamentoResourceTest {
    
    @Test
    @TestSecurity(user = "user", roles = {"Cliente"})
    public void findAllTest(){
        given()
            .when()
            .get("/formaPagamentos")
            .then()
            .statusCode(200);
    }

    @Test
    @TestSecurity(user = "user", roles = {"Cliente"})
    public void findByIdTest(){
        given()
            .when()
            .get("/formaPagamentos/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    @TestSecurity(user = "user", roles = {"Cliente"})
    public void createTest(){
        FormaPagamentoDTO dto = new FormaPagamentoDTO(
            2, LocalDateTime.now(), 1
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .post("/formaPagamentos")
            .then()
            .statusCode(201);
    }
}
