package uk.gov.companieshouse.moviefinder.web.controller.movie;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.gov.companieshouse.moviefinder.web.service.MovieService;

@Controller
@RequestMapping("/movies/all")
public class AllMoviesController {

    private static final Logger logger = LogManager.getLogger(AllMoviesController.class);

    private static final String MODEL_ATTR = "movieList";
    private static final String VIEW = "fullMovieList";

    @Autowired
    private MovieService movieService;

    @GetMapping
    public String get(Model model) {

        logger.info("Fetching full movie list");

        model.addAttribute(MODEL_ATTR, movieService.getFullMovieList());

        return VIEW;
    }
}
