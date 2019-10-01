package pl.coderslab.game.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/battle")
public class BattleController {

    @GetMapping("/score/{characterId}/{monsterId}")
    public String prepareScorePage(@PathVariable Long characterId, @PathVariable Long monsterId, Model model){

    }


}
