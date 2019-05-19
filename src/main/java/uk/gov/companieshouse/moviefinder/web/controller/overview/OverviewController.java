package uk.gov.companieshouse.moviefinder.web.controller.overview;

import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import uk.gov.companieshouse.moviefinder.web.model.Overview;

@Controller
@RequestMapping("/")
public class OverviewController {

    private static final Logger logger = LogManager.getLogger(OverviewController.class);

    private static final String MODEL_ATTR = "overview";
    private static final String VIEW = "overview";
    private static final String ERROR_VIEW = "error";

    private static final String ACTION_VIEW_ALL_MOVIES = "viewAllMovies";
    private static final String PATH_VIEW_ALL_MOVIES = "/movies/all";

    private static final String ACTION_VIEW_MOVIE_WITH_MOST_LIKES = "viewMovieWithMostLikes";
    private static final String PATH_VIEW_MOVIE_WITH_MOST_LIKES = "/movies/most-likes";

    private static final String ACTION_VIEW_USER_WITH_MOST_COMMENTS = "viewUserWithMostComments";
    private static final String PATH_VIEW_USER_WITH_MOST_COMMENTS = "/users/most-comments";

    @GetMapping
    public String get(Model model) {

        logger.info("User has landed on the start page");

        model.addAttribute(MODEL_ATTR, new Overview());

        return VIEW;
    }

    @PostMapping
    public String submit(@ModelAttribute(MODEL_ATTR) @Valid Overview overview,
                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return VIEW;
        }

        switch (overview.getAction()) {

            case ACTION_VIEW_ALL_MOVIES:
                logger.info("User has opted to view all movies");
                return UrlBasedViewResolver.REDIRECT_URL_PREFIX + PATH_VIEW_ALL_MOVIES;

            case ACTION_VIEW_MOVIE_WITH_MOST_LIKES:
                logger.info("User has opted to view the movie with the most likes");
                return UrlBasedViewResolver.REDIRECT_URL_PREFIX + PATH_VIEW_MOVIE_WITH_MOST_LIKES;

            case ACTION_VIEW_USER_WITH_MOST_COMMENTS:
                logger.info("User has opted to view the user with the most comments");
                return UrlBasedViewResolver.REDIRECT_URL_PREFIX + PATH_VIEW_USER_WITH_MOST_COMMENTS;

            default:
                logger.error("User has requested unexpected action: " + overview.getAction());
                return ERROR_VIEW;
        }
    }
}
