package br.com.andrethiago.filmesapi;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class FilmesAPITest {
	
	@Test
	public void todosFilmesRetorna200ComListaFilmes() {
		
		when().get("/filmesapi/filmes").then().statusCode(200);
		
	}

}
