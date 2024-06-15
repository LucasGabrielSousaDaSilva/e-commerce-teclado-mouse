package br.unitins.tp1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.produto.SensorDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class SensorResourceTest {
    
    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void findAllTest(){
        given()
            .when()
            .get("/sensor")
            .then()
            .statusCode(200);
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void findByIdTest(){
        given()
            .when()
            .pathParam("id", 2)
            .get("/sensor/{id}")
            .then()
            .statusCode(200);
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void FindByNomeTest(){
        given()
            .when()
            .get("/sensor/search/nome/Snow")
            .then()
            .statusCode(200)
            .body("nome", everyItem(is("Snow")));
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void createTest(){
        SensorDTO dto = new SensorDTO(
            "Races", 
            8000.0, 
            9000.1, 
            2l, 
            1l);

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .post("/sensor")
            .then()
            .statusCode(201)
            .body("nome", is("Races"))
            .body("dpi", is(8000.0f))
            .body("ips", is(9000.1f))
            .body("idModelo.id", is(2))
            .body("idFormato.id", is(1));
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void updateTest(){
        SensorDTO dto = new SensorDTO(
            "Fast", 
            6500.0, 
            5400.0, 
            1l, 
            2l);

            given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .pathParam("id", 4)
                .put("/sensor/{id}")
                .then()
                .statusCode(204);
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void deleteTest(){

        given()
            .when()
            .pathParam("id", 3)
            .delete("/sensor/{id}")
            .then()
            .statusCode(204);
    }
}
