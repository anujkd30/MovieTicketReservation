package org.geminisolutions.MovieTicketReservation.Dao.impl;

import org.geminisolutions.MovieTicketReservation.Dao.TheatreDao;
import org.geminisolutions.MovieTicketReservation.model.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TheatreDaoImpl implements TheatreDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createTheatre(Theatre theatre) {

        String query = "insert into THEATRE (type, name, reserved_seats, capacity, no_of_rows, no_of_screens) " +
                "values(?,?,?,?,?,?)";
        jdbcTemplate.update(query,theatre.getType(),theatre.getName(),
                theatre.getReserved_seats(),theatre.getCapacity(),
                theatre.getNo_of_rows(),theatre.getNo_of_screens());

    }

    @Override
    public void updateTheatreByName(int theatreId,String name) {
        String query = "Update THEATRE set name = ? where id = ?";
        jdbcTemplate.update(query,name,theatreId);
    }

    @Override
    public void deleteTheatreById(int theatreId) {
        String query = "delete from THEATRE where id = ?";
        jdbcTemplate.update(query,theatreId);
    }

    @Override
    public List<Theatre> getTheatres() {
        String query = "Select * from THEATRE";
        return jdbcTemplate.query(query, new RowMapper<Theatre>() {
            @Override
            public Theatre mapRow(ResultSet rs, int i) throws SQLException {
                Theatre theatre = new Theatre();
                theatre.setType(rs.getString(2));
                theatre.setName(rs.getString(3));
                theatre.setReserved_seats(rs.getInt(4));
                theatre.setCapacity(rs.getInt(5));
                theatre.setNo_of_rows(rs.getInt(6));
                theatre.setNo_of_screens(rs.getInt(7));
                return theatre;
            }
        });
    }
}
