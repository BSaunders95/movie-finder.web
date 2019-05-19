package uk.gov.companieshouse.moviefinder.web.controller.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.gov.companieshouse.moviefinder.web.service.UserService;

@Controller
@RequestMapping("/users/most-comments")
public class UserWithMostCommentsController {

    private static final Logger logger = LogManager.getLogger(UserWithMostCommentsController.class);

    private static final String MODEL_ATTR = "user";
    private static final String VIEW = "userWithMostComments";

    @Autowired
    private UserService userService;

    @GetMapping
    public String get(Model model) {

        logger.info("Fetching the user with the most comments");

        model.addAttribute( MODEL_ATTR, userService.getUserWithMostComments());

        return VIEW;
    }
}
