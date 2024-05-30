package br.unitins.tp1.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.everyItem;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.unitins.tp1.dto.produto.MouseDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;

@QuarkusTest
public class MouseResourceTest {

    @Test
    public void findAllTest(){
        given()
            .when()
            .get("/mouse")
            .then()
            .statusCode(200);
    }

    @Test
    public void findByIdTest(){
        given()
            .when()
            .get("/mouse/1")
            .then()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    public void FindByNomeTest(){
        given()
            .when()
            .get("/mouse/search/nome/dragon")
            .then()
            .statusCode(200)
            .body("nome", everyItem(is("dragon")));
    }

    @Test
    public void createTest(){
        MouseDTO dto = new MouseDTO(
            "Acer", 
            "Fury", 
            "Super Rapido", 
            120.6f, 
            6, 
            "RGB_Azul", 
            "8 Botões", 
            "Japão", 
            2, 
            2, 
            2l, 
            List.of(1L, 2L));

            given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .when()
                .post("/mouse")
                .then()
                .statusCode(201)
                .body("nome", is("Acer"))
                .body("modelo", is("Fury"))
                .body("descricao", is("Super Rapido"))
                .body("valor", is(120.6f))
                .body("quantidade", is(6))
                .body("iluminacao", is("RGB_Azul"))
                .body("botao", is("8 Botões"))
                .body("made", is("Japão"))
                .body("idPegada", is("FINGERTIP"))
                .body("idConexao", is("SEMFIO"))
                .body("idConstrucao.id", is(2))
                .body("sensores.nome", containsInAnyOrder("Speed", "Snow"));


    }

    @Test
    public void updateTest(){
        MouseDTO dto = new MouseDTO(
            "Acer", 
            "Inspirion", 
            "Muito Rapido", 
            150.5f, 
            5, 
            "RGB_Verde", 
            "9 Botões", 
            "USA", 
            1, 
            1, 
            2l, 
            List.of(1l,2l));

        given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(dto)
            .when()
            .pathParam("id", 2)
            .put("/mouse/{id}")
            .then()
            .statusCode(204);
    }

    @Test
    public void deleteTest(){

        given()
            .when()
            .pathParam("id", 3)
            .delete("/mouse/{id}")
            .then()
            .statusCode(204);
    }
    
}
