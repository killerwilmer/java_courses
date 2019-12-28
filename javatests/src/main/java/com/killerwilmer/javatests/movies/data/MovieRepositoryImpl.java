package com.killerwilmer.javatests.movies.data;

import com.killerwilmer.javatests.movies.model.Genre;
import com.killerwilmer.javatests.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;

public class MovieRepositoryImpl implements MovieRepository {

  private JdbcTemplate jdbcTemplate;

  public MovieRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Movie findById(long id) {

    Object[] args = {id};

    return jdbcTemplate.queryForObject("select * from movies where id = ?", args, movieMapper);
  }

  @Override
  public Collection<Movie> findAll() {

    return jdbcTemplate.query("select * from movies", movieMapper);
  }

  @Override
  public void saveOrUpdate(Movie movie) {}

  private static RowMapper<Movie> movieMapper =
      (rs, rowNum) ->
          new Movie(
              rs.getInt("id"),
              rs.getString("name"),
              rs.getInt("minutes"),
              Genre.valueOf(rs.getString("genre")));
}
