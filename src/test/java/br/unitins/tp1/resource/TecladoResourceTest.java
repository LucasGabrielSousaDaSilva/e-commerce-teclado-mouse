package br.unitins.tp1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.Matchers.everyItem;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.produto.TecladoDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class TecladoResourceTest {

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void findAllTest(){
        given()
            .when()
            .get("/teclado")
            .then()
            .statusCode(200)
            .body("nome", hasItem(is("dragon")));
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void findByIdTest(){
        given()
            .when()
            .get("/teclado/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void FindByNomeTest(){
        given()
            .when()
            .get("/teclado/search/nome/dagon")
            .then()
            .statusCode(200)
            .body("nome", everyItem(is("dagon")));
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void createTest(){
        TecladoDTO dto = new TecladoDTO(
            "Mancer", 
            "Super", 
            "Confortavel", 
            32.41f, 
            5, 
            "ABNT2", 
            "Avantajado", 
            "50% led", 
            "RGB_Verde", 
            2l,
            2l);

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .post("/teclado")
            .then()
            .statusCode(201)
            .body("nome", is("Mancer"))
            .body("modelo", is("Super"))
            .body("descricao", is("Confortavel"))
            .body("valor", is(32.41f))
            .body("quantidade", is(5))
            .body("layout", is("ABNT2"))
            .body("design", is("Avantajado"))
            .body("tipoTeclado", is("50% led"))
            .body("iluminacao", is("RGB_Verde"))
            .body("idConstrucao.id", is(2))
            .body("idMarca.id", is(2));
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void updateTest(){
        TecladoDTO dto = new TecladoDTO(
            "Acer", 
            "Super", 
            "Confortavel", 
            32.41f, 
            5, 
            "ABNT2", 
            "Circular", 
            "70%_Gamer", 
            "RGB_Verde", 
            1l,
            1l);

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .pathParam("id", 2)
            .put("/teclado/{id}")
            .then()
            .statusCode(204);
    }

    @Test
    @TestSecurity(user = "user", roles = {"Funcionario"})
    public void deleteTest(){
        given()
            .when()
            .pathParam("id", 3)
            .delete("/teclado/{id}")
            .then()
            .statusCode(204);
    }
    
}
