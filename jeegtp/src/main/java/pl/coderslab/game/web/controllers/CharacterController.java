package pl.coderslab.game.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.game.dto.CharacterFormDTO;
import pl.coderslab.game.services.CharacterService;
import pl.coderslab.game.services.MonsterService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/character")
public class CharacterController {
    private CharacterService characterService;
    private MonsterService monsterService;

    public CharacterController(CharacterService characterService, MonsterService monsterService) {
        this.characterService = characterService;
        this.monsterService = monsterService;
    }

    @GetMapping("/list")
    public String characterListPage(Model model){
        model.addAttribute("character_list", characterService.getList());
        return "/character/user_character_list";
    }

    @GetMapping("/create")
    public String prepareToCreateCharacter(Model model){
        model.addAttribute("new_character", new CharacterFormDTO());
        return "character/create_character";
    }

    @PostMapping("/create")
    public String processToCreateCharacter(@ModelAttribute("new_character") @Valid CharacterFormDTO newCharacter, BindingResult result, HttpServletRequest request){
        String type = request.getParameter("type");
        if (!characterService.isNameAvailable(newCharacter.getName())){
            result.rejectValue("Name", null, "This name already exists!");
            return "character/create_character";
        }
        System.out.println(type);
        newCharacter.setType(type);
        newCharacter.getCharacterClass().setType(type);
        characterService.createCharacter(newCharacter);
        return "redirect:/character/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCharacter(@PathVariable Long id){
        characterService.deleteCharacter(id);
        return "redirect:/character/list";
    }

    @GetMapping("/play/${id}")
    public String prepareBattlePage(@PathVariable Long id, Model model){
        model.addAttribute("character_data", characterService.readCharacter(id));
        model.addAttribute("monster_data", monsterService.getRandomMonster(id));
        return "battle";
    }

}
