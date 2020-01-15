package com.killerwilmer.amazonviewer.dao;

import com.killerwilmer.amazonviewer.db.IDBConnection;
import com.killerwilmer.amazonviewer.model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.killerwilmer.amazonviewer.db.DataBase.*;

public interface MovieDAO extends IDBConnection {

    default Movie setMovieViewed(Movie movie) {

        return movie;
    }

    default ArrayList<Movie> read() {

        ArrayList<Movie> movies = new ArrayList<>();
        try (Connection connection = connectToDB()) {
            String query = "Select * from " + TMOVIE;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Movie movie = new Movie(rs.getString(TMOVIE_TITLE),
                        rs.getString(TMOVIE_GENRE),
                        rs.getString(TMOVIE_CREATOR),
                        Integer.valueOf(rs.getString(TMOVIE_DURATION)),
                        Short.valueOf(rs.getString(TMOVIE_YEAR)));
                movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
                movie.setViewed(getMovieViewd(connection, movie.getId()));
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    private boolean getMovieViewd(Connection connection, int idMovie) {

        boolean viwed = false;
        String query = "Select * from " + TVIEWED +
                " where " + TVIEWED_IDMATERIAL + "= ?" +
                " and " + TVIEWED_IDELEMENT + "= ? " +
                " and " + TVIEWED_IDUSUARIO + "= ?";

        ResultSet rs = null;

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1 , ID_TMATERIALS[0]);
            preparedStatement.setInt(2, idMovie);
            preparedStatement.setInt(3, TUSER_IDUSUARIO);

            rs = preparedStatement.executeQuery();
            viwed = rs.next();
        } catch (Exception e) {

        }


        return viwed;
    }
}
