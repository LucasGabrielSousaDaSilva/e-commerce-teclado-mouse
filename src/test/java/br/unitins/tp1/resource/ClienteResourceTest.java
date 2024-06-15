package br.unitins.tp1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.pessoa.ClienteDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
// import io.quarkus.test.security.TestSecurity;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class ClienteResourceTest {
    
    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void findAllTest(){
        given()
            .when()
            .get("/clientes")
            .then()
            .statusCode(200)
            .body("nome", hasItem(is("Gabriel")));
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void findByIdTest(){
        given()
            .when()
            .get("/clientes/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void FindByNomeTest(){
        given()
            .when()
            .get("/clientes/search/nome/Speed")
            .then()
            .statusCode(200)
            .body("nome", everyItem(is("Speed")));
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void createTest() {
        ClienteDTO dto = new ClienteDTO(
            "Speed", 16, "teste@teste.com", 
            "Rua ali, do lote da esquina",
            "SpeedRacing", "456"
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .post("/clientes")
            .then()
            .statusCode(201)
            .body("nome", is("Speed"))
            .body("idade", is(16))
            .body("email", is("teste@teste.com"))
            .body("endereco", is("Rua ali, do lote da esquina"))
            .body("username", is("SpeedRacing"));
    }
    
    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void updateTest(){
        ClienteDTO dto = new ClienteDTO(
            "Lukas", 20, "Lindo@teste.com", 
            "Rua 103, do lote 46",
            "SpeedSlow", "321"
        );

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .pathParam("id", 1)
            .post("/clientes/{id}")
            .then()
            .statusCode(204);
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void deleteTest(){
        
        given()
            .when()
            .pathParam("id", 2)
            .delete("/clientes/{id}")
            .then()
            .statusCode(204);
    }
}
