package org.geminisolutions.MovieTicketReservation.Dao;

import org.geminisolutions.MovieTicketReservation.model.Theatre;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TheatreDao {
    public abstract void createTheatre(Theatre theatre);
    public abstract void updateTheatreByName(int theatreId,String name);
    public abstract void deleteTheatreById(int theatreId);
    public abstract List<Theatre> getTheatres();
}
