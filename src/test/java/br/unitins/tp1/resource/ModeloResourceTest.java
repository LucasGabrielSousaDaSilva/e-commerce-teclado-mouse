package br.unitins.tp1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.ModeloDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class ModeloResourceTest {

    @Test
    public void findAllTest(){
        given()
            .when()
            .get("/modelo")
            .then()
            .statusCode(200)
            .body("nome", hasItems("Paliin", "Motor", "Super"));
    }
    
    @Test
    public void findByIdTest(){
        given()
            .when()
            .get("/modelo/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    public void createTest(){
        ModeloDTO dto = new ModeloDTO(
            "furi", 
            "14528sd");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .post("/modelo")
            .then()
            .statusCode(201)
            .body("nome", is("furi"))
            .body("serie", is("14528sd"));

    }

    @Test
    public void updateTest(){
        ModeloDTO dto = new ModeloDTO("Super", "256384g");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .pathParam("id", 2)
            .put("/modelo/{id}")
            .then()
            .statusCode(204);
    }

    @Test
    public void deleteTest(){
        given()
            .when()
            .pathParam("id", 3)
            .delete("/modelo/{id}")
            .then()
            .statusCode(204);
    }
}
