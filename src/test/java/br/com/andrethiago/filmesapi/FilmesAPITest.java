package br.com.andrethiago.filmesapi;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;

public class FilmesAPITest {
	
	@Test
	public void todosFilmesRetornaStatusCode200ComListaFilmesEQuantidade() {
		
		when().get("/filmesapi/filmes").
			then().statusCode(200).
			body("dados", notNullValue()).
			and().
			body("quantidade", notNullValue()).
			and();
		
	}
	
	@Test
	public void todosFilmesQuantidadeIgualTamanhoListaRetornada() {
		
		String response = when().get("/filmesapi/filmes").asString();
			
		
	}

}
