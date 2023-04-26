package vamk.fi.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vamk.fi.user.model.UserModel;
import vamk.fi.user.service.UserService;

@Controller
public class UserController {
    
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new UserModel());
        return "error_page";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(@ModelAttribute UserModel userModel, Model model) {
        System.out.println("login request: " + userModel);
        UserModel authenticated = userService.authenticate(userModel.getLogin(), userModel.getPassword());
        if (authenticated != null) {
            model.addAttribute("userLogin", authenticated.getLogin());
            return "personal_page";
        } else {
            return "error_page";
        }
    }
}
