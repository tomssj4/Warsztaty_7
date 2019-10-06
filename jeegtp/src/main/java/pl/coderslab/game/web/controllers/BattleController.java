package pl.coderslab.game.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.game.services.BattleService;

@Controller
@RequestMapping("/battle")
public class BattleController {
    private BattleService battleService;

    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @GetMapping("/score/{characterId}/{monsterId}")
    public String prepareScorePage(@PathVariable Long characterId, @PathVariable Long monsterId, Model model){
       model.addAttribute("battle_result", battleService.goBattle(characterId, monsterId));
return "battle";
    }


}
