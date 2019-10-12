package pl.coderslab.game.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.game.dto.UserEmailFormDTO;
import pl.coderslab.game.dto.UserLoginFormDTO;
import pl.coderslab.game.dto.UserPasswordFormDTO;
import pl.coderslab.game.services.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/settings")
    public String prepareSettingPage() {
        return "user/settings";
    }

    @GetMapping("/settings/login")
    public String prepareLoginChange(Model model, Principal principal) {
        String userLogin = principal.getName();
        model.addAttribute("new_user_login", new UserLoginFormDTO());
        model.addAttribute("user_data", userService.readUser(userLogin));
        return "user/change_login";
    }

    @PostMapping("/settings/login")
    public String processLoginChange(@ModelAttribute("new_user_login") @Valid UserLoginFormDTO data, BindingResult result, Principal principal) {
        String login = principal.getName();
        if (result.hasErrors()) {
            return "user/change_login";
        }
        if (!userService.isLoginAvailable(data.getLogin())) {
            result.rejectValue("login", null, "Login already exists.");
            return "user/change_login";
        }
        userService.updateUserLogin(data, login);
        return "redirect: /logout";
    }

    @GetMapping("/settings/email")
    public String prepareEmailChange(Model model, Principal principal) {
        String userLogin = principal.getName();
        model.addAttribute("new_user_email", new UserEmailFormDTO());
        model.addAttribute("user_data", userService.readUser(userLogin));
        return "user/change_email";
    }

    @PostMapping("/settings/email")
    public String processEmailChange(@ModelAttribute("new_user_email") @Valid UserEmailFormDTO data, BindingResult result, Principal principal) {
        String login = principal.getName();
        if (result.hasErrors()) {
            return "user/change_email";
        }
        if (!userService.isEmailAvailable(data.getEmail())) {
            result.rejectValue("email", null, "Email already exists.");
            return "user/change_email";
        }
        userService.updateUserEmail(data, login);
        return "redirect: /settings";
    }

    @GetMapping("/settings/password")
    public String preparePasswordChange(Model model, Principal principal) {
        String userLogin = principal.getName();
        model.addAttribute("new_user_password", new UserPasswordFormDTO());
        model.addAttribute("user_data", userService.readUser(userLogin));
        return "user/change_password";
    }

    @PostMapping("/settings/password")
    public String processPasswordChange(@ModelAttribute("new_user_password") @Valid UserPasswordFormDTO data, BindingResult result, Principal principal) {
        String login = principal.getName();
        if (result.hasErrors()) {
            return "user/change_password";
        }
        if (result.hasErrors()) {
            result.rejectValue("Password", null, "Password must have at least 8!");
            return "user/change_password";
        }
        if (!data.getPassword().equals(data.getRePassword())) {
            result.rejectValue("rePassword", null, "Password and RePassword have to be the same.");
            return "user/change_password";
        }

        userService.updateUserPassword(data, login);
        return "redirect: /logout";
    }

    @GetMapping("/settings/delete")
    public String deleteUser(Principal principal) {
        String userLogin = principal.getName();
        userService.deleteUser(userLogin);
        return "redirect: /login";
    }
}
