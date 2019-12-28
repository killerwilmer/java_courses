package com.killerwilmer.javatests.movies.data;

import com.killerwilmer.javatests.movies.model.Genre;
import com.killerwilmer.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;

public class MovieRepositoryImplTest {

  private MovieRepositoryImpl movieRepository;
  private DriverManagerDataSource managerDataSource;

  @Before
  public void setUp() throws Exception {

    managerDataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

    ScriptUtils.executeSqlScript(
        managerDataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

    JdbcTemplate jdbcTemplate = new JdbcTemplate(managerDataSource);

    movieRepository = new MovieRepositoryImpl(jdbcTemplate);
  }

  @Test
  public void test_load_all_movies() throws SQLException {

    Collection<Movie> movies = movieRepository.findAll();

    assertThat(
        movies,
        CoreMatchers.is(
            Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix 1", 136, Genre.ACTION),
                new Movie(4, "Matrix 2", 138, Genre.ACTION),
                new Movie(5, "Matrix 3", 132, Genre.ACTION))));
  }

  @Test
  public void test_load_movie_by_id() {

    Movie movie = movieRepository.findById(2);

    assertThat(movie, CoreMatchers.is(new Movie(2, "Memento", 113, Genre.THRILLER)));
  }

  @Test
  public void test_insert_a_movie() {

    Movie movie = new Movie("Super 8", 112, Genre.THRILLER);

    movieRepository.saveOrUpdate(movie);

    Movie movieFromDb = movieRepository.findById(6);

    assertThat(movieFromDb, CoreMatchers.is(new Movie(6, "Super 8", 112, Genre.THRILLER)));
  }

  @Test
  public void test_find_movies_by_name() {

    Collection<Movie> movies = movieRepository.findByName("matr");

    assertThat(
        movies,
        CoreMatchers.is(
            Arrays.asList(
                new Movie(3, "Matrix 1", 136, Genre.ACTION),
                new Movie(4, "Matrix 2", 138, Genre.ACTION),
                new Movie(5, "Matrix 3", 132, Genre.ACTION))));
  }

  @After
  public void tearDown() throws Exception {

    final Statement statement = managerDataSource.getConnection().createStatement();
    statement.execute("drop all objects delete files"); // shutdown is also enough for mem db
  }
}
