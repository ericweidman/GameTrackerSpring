package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ericweidman on 3/8/16.
 */
@Controller
public class GameTrackerController {
    @Autowired
    GameRepository games;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, String genre, Integer releaseYear){
        if(genre != null && releaseYear != null) {
            model.addAttribute("games", games.findByGenreAndReleaseYear(genre, releaseYear));
        }
        else if (genre != null){
            model.addAttribute("games", games.findByGenre(genre));
        }
        else{
            model.addAttribute("games", games.findAll());
        }
        return "home";
    }
    @RequestMapping(path = "/add-game", method = RequestMethod.POST)
    public String addGame(String gameName, String gamePlatform, String gameGenre, int gameYear){
        Game game = new Game(gameName, gamePlatform, gameGenre, gameYear);
        games.save(game);
        return "redirect:/";
    }
}
