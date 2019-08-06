package org.geminisolutions.MovieTicketReservation;

import org.geminisolutions.MovieTicketReservation.Dao.TheatreDao;
import org.geminisolutions.MovieTicketReservation.model.Theatre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(value = "theatre")
@Controller
public class HomeController {
    @Autowired
    TheatreDao theatreDao;
    private static final Logger logger = LoggerFactory.getLogger(MovieTicketReservationApplication.class);
    private Integer id;

    public String index(){
        return "index";
    }

    @PostMapping(value = "/" )
    public String save(@ModelAttribute(name = "theatreDetails") Theatre theatre){
        try {
            theatreDao.createTheatre(theatre);
        }
        catch(Exception e){
            logger.warn("Record not added");
            e.printStackTrace();
        }
        logger.info("Record added");
        return "redirect:/";
    }

    @RequestMapping(value = "/showTheatres" , method = RequestMethod.GET)
    public String showTheatres(Model model){
        try {
            List<Theatre> list = theatreDao.getTheatres();
            model.addAttribute("list",list);
        }
        catch(Exception e){
            logger.warn("Attribute Not Added.");
            e.printStackTrace();
        }
        logger.info("Displayed successfully");
        return "AvailableTheatres";
    }

    @DeleteMapping(value = "/")
    public String deleteTheatre(@RequestParam("id") String id ){
        try {
            theatreDao.deleteTheatreById(Integer.parseInt(id));
        }
        catch(Exception e){
            logger.warn("Error encountered");
            e.printStackTrace();
        }
        logger.info("Success");
        return "redirect:/";
    }
    @PutMapping(value = "/")
    public String updateTheatre(@RequestParam("id") String id,@RequestParam("name") String name,Model md){
        try {
            theatreDao.updateTheatreByName(Integer.parseInt(id), name);
        }catch(Exception e){
            e.printStackTrace();
        }
        return showTheatres(md);
    }
}
