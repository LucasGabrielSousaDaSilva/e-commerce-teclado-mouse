package br.unitins.tp1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.pessoa.FuncionarioDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class FuncionarioResourceTest {

    @Test
    public void findAllTest(){
        given()
            .when()
            .get("/funcionarios")
            .then()
            .statusCode(200)
            .body("nome", hasItem(is("Gabriel")));
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void findByIdTest(){
        given()
        .when()
        .get("/funcionarios/1")
        .then()
        .statusCode(200)
        .body("id", is(1));
    }

    @Test
    public void FindByNomeTest(){
        given()
        .when()
        .get("/funcionarios/search/nome/Gabriel")
        .then()
        .statusCode(200)
        .body("nome", everyItem(is("Gabriel")));
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void createTest(){
        FuncionarioDTO dto = new FuncionarioDTO(
            "Rafael", 16, "Abastecedor", "teste@teste.com", 
            1200.00, "Rafael", "123"
        );

        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .get("/funcionarios")
        .then()
        .statusCode(200);
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void updateTest(){
        FuncionarioDTO dto = new FuncionarioDTO(
            "Gabriel", 18, "Empacotador", "Bonitoem@teste.com", 
            1500.00, "Dragon", "258"
        );

        given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(dto)
        .when()
        .get("/funcionarios/1")
        .then()
        .statusCode(200);
    }

    @Test
    // @TestSecurity(user = "user", roles = {"Funcionario"})
    public void deleteTest(){
        given()
            .when()
            .pathParam("id", 2)
            .delete("/funcionarios/{id}")
            .then()
            .statusCode(204);
    }
}
