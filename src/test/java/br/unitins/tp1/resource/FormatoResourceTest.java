package br.unitins.tp1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.produto.FormatoDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class FormatoResourceTest {

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void findAllTest(){
        given()
            .when()
            .get("/formato")
            .then()
            .statusCode(200)
            ;
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void findByIdTest() {
        given()
            .when()
            .get("/formato/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void createTest(){
        FormatoDTO dto = new FormatoDTO(
            3.5f,
            5.9f);

            given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .post("/formato")
                .then()
                .statusCode(201)
                .body("comprimento", is(3.5f))
                .body("largura", is(5.9f));
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void updateTest(){
        FormatoDTO dto = new FormatoDTO(3.1f, 4.2f);

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .pathParam("id", 2)
            .put("/formato/{id}")
            .then()
            .statusCode(204);
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void deleteTest(){

        given()
            .when()
            .pathParam("id", 3)
            .delete("/formato/{id}")
            .then()
            .statusCode(204);
    }
    
}
