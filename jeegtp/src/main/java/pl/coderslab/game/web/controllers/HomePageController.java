package pl.coderslab.game.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.game.repositories.MonsterRepository;

import java.security.Principal;

@Controller
@RequestMapping("/home")
public class HomePageController {
    private MonsterRepository monsterRepository;

    public HomePageController(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    @GetMapping
    public String prepareHomePage(Model model, Principal principal){
//        String username = principal.getName();
//        model.addAttribute("username", username);
        return "index";
    }

    @GetMapping("/monster-list")
    public String prepareMonsterList(Model model){
        model.addAttribute("monster_list", monsterRepository.findAll());
        return "monsters/monsters_list";
    }

}
