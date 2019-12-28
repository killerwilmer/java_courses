package com.killerwilmer.javatests.movies.data;

import com.killerwilmer.javatests.movies.model.Genre;
import com.killerwilmer.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;

public class MovieRepositoryImplTest {

  @Test
  public void test_load_all_movies() throws SQLException {

    DriverManagerDataSource managerDataSource =
        new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

    ScriptUtils.executeSqlScript(
        managerDataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

    JdbcTemplate jdbcTemplate = new JdbcTemplate(managerDataSource);

    MovieRepositoryImpl movieRepository = new MovieRepositoryImpl(jdbcTemplate);

    Collection<Movie> movies = movieRepository.findAll();

    assertThat(
        movies,
        CoreMatchers.is(
            Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION))));
  }
}
