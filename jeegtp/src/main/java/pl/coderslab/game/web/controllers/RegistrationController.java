package pl.coderslab.game.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.game.dto.RegistrationFormDTO;
import pl.coderslab.game.services.RegistrationService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String prepareRegistrationPage(Model model) {
        model.addAttribute("data", new RegistrationFormDTO());
        return "registration";

    }

    @PostMapping
    public String processRegistrationPage(@ModelAttribute("data") @Valid RegistrationFormDTO data, BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        }if (result.hasErrors()) {
            result.rejectValue("Password", null, "Password must have at least 8!");
            return "registration";
        }
        if (!data.getPassword().equals(data.getRePassword())) {
            result.rejectValue("rePassword", null, "Password and RePassword have to be the same.");
            return "registration";
        }
        if (!registrationService.isLoginAvailable(data.getLogin())) {
            result.rejectValue("login", null, "Login already exists.");
            return "registration";
        }
        if (!registrationService.isEmailAvailable(data.getEmail())) {
            result.rejectValue("email", null, "Email already exists.");
            return "registration";
        }
        registrationService.registerUser(data);
        return "redirect:/login";
    }

}
