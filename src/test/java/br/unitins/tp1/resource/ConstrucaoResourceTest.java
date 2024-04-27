package br.unitins.tp1.resource;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.ConstrucaoDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ConstrucaoResourceTest {

    @Test
    public void findAllTest(){
        given()
            .when()
            .get("/construcao")
            .then()
            .statusCode(200)
            .body("cor", hasItem(is("Verde")));
    }

    @Test
    public void findByIdTest(){
        given()
            .when()
            .get("/construcao/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    public void findByCor(){
        given()
            .when()
            .get("/construcao/search/cor/Preto")
            .then()
            .statusCode(200)
            .body("cor", everyItem(is("Preto")));
    }

    @Test
    public void createTest(){
        ConstrucaoDTO dto = new ConstrucaoDTO(
            20.1f, 
            10.2f, 
            "Plastico", 
            "Prata");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .post("/construcao")
            .then()
            .statusCode(201)
            .body("peso", is(20.1f))
            .body("comprimento", is(10.2f))
            .body("revestimento", is("Plastico"))
            .body("cor", is("Prata"));
    }

    @Test
    public void updateTest(){
        ConstrucaoDTO dto = new ConstrucaoDTO(
            3.5f, 
            5.6f, 
            "Poli_Plastico", 
            "Cinza");

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .pathParam("id", 2)
            .put("/construcao/{id}")
            .then()
            .statusCode(204);
    }

    @Test
    public void deleteTest(){

        given()
            .when()
            .pathParam("id", 3)
            .delete("/construcao/{id}")
            .then()
            .statusCode(204);
    }
    
}
