package br.unitins.tp1.resource;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.MarcaDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MarcaResourceTest {

    @Test
    public void findAllTest() {
        given()
            .when()
            .get("/marca")
            .then()
            .statusCode(200);
    }

    @Test
    public void findByIdTest() {
        given()
            .when()
            .get("/marca/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    public void createTest() {
        MarcaDTO dto = new MarcaDTO(
            "Jump", 
            "Voilet");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .post("/marca")
            .then()
            .statusCode(201)
            .body("nome", is("Jump"))
            .body("empresa", is("Voilet"));
    }

    @Test
    public void updateTest(){
        MarcaDTO dto = new MarcaDTO(
            "Vault", 
            "Vault_tec");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .pathParam("id", 2)
            .put("/marca/{id}")
            .then()
            .statusCode(204);
    }

    @Test
    public void deleteTest(){
        
        given()
            .when()
            .pathParam("id", 3)
            .delete("/marca/{id}")
            .then()
            .statusCode(204);
        }
}

