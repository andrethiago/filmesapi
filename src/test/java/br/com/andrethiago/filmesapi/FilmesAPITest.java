package br.com.andrethiago.filmesapi;

import static io.restassured.RestAssured.basic;
import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.andrethiago.filmesapi.model.Filme;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FilmesAPITest {
	
	@Before
	public void configuraAutenticacao() {
		RestAssured.authentication = basic("joao", "123456");
	}

	@Test
	public void todosFilmesVerificaCabecalhosResposta() {
		
		get("/filmesapi/filmes").
			then().
			statusCode(200).
				and().
			contentType(JSON);

	}

	@Test
	public void todosFilmesRetornaListaFilmesEQuantidade() {

		get("/filmesapi/filmes").
			then().
			body("dados", notNullValue()).
				and().
			body("dados", not(empty())).
				and().
			body("quantidade", notNullValue());

	}

	@Test
	public void todosFilmesVerificaAtributosFilmes() {
		List<Filme> filmes = get("/filmesapi/filmes").getBody().jsonPath().getList("dados", Filme.class);
		
		assertThat(filmes, everyItem(hasProperty("id", notNullValue())));
		assertThat(filmes, everyItem(hasProperty("nome", notNullValue())));
		assertThat(filmes, everyItem(hasProperty("sinopse", notNullValue())));
		assertThat(filmes, everyItem(hasProperty("atores", not(empty()))));
	}

	@Test
	public void todosFilmesVerificaQuantidadeIgualTamanhoListaRetornada() {
		Response response = get("/filmesapi/filmes").then().extract().response();
		Integer quantidade = response.path("quantidade");
		List<Object> lista = response.jsonPath().getList("dados");

		assertEquals(Integer.valueOf(lista.size()), quantidade);
	}

	@Test
	public void filmePorIdValido() {
		get("/filmesapi/filmes/1").
			then().
			statusCode(200).
				and().
			body("id", equalTo(1));
	}

	@Test
	public void filmePorIdInvalidoRetorna404() {
		get("/filmesapi/filmes/100").then().statusCode(404);
	}
	
	@Test
	public void gravaNovoAtor() {
		given().
			contentType(JSON).
			body("{\"nome\" : \"Robert De Niro\"}").
			when().
			put("/filmesapi/atores").
			then().
			statusCode(201).
			log().all().
			and().
			body(equalTo("Ator criado com sucesso."));
		
	}
	
	@Test
	public void apagaAtorExistente() {
		Integer atoresAntes = get("/filmesapi/atores").then().extract().response().path("quantidade");
		
		delete("/filmesapi/atores/{id}", 1).
		then().
		statusCode(200).
		and().
		body(equalTo("Ator removido com sucesso."));
		
		Integer atoresDepois = get("/filmesapi/atores").then().extract().response().path("quantidade");
		assertTrue(atoresDepois == Integer.valueOf(atoresAntes - 1));
	}
	
	@Test
	public void acessoExigeAutenticacao() {
		RestAssured.authentication = RestAssured.DEFAULT_AUTH;
		
		get("/filmesapi/filmes").
		then().
		statusCode(401);
	}

}
