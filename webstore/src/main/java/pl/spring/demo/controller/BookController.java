package pl.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.spring.demo.constants.ViewNames;

/**
 * Book controller
 * 
 * @author mmotowid
 *
 */
@Controller
@RequestMapping("/books")
public class BookController {

//    @RequestMapping(method = RequestMethod.GET)
//    public String list() {
//        return ViewNames.BOOKS;
//    }

    /**
     * Binder initialization
     */
    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
        binder.setAllowedFields("id", "title", "authors");
    }

}
