package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.servise.UserServise;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServise userServise;

    @GetMapping()
    public String allUsers(Model model) {

        List<User> users = userServise.getAllUsers();
        model.addAttribute("users", users);

        return "main";
    }

    @GetMapping("/registration")
    public String addUser(Model model) {

        User user = new User();
        model.addAttribute("newUser", user);

        return "registration-user";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {

        User user = userServise.getUser(id);
        model.addAttribute("newUser", user);

        return "registration-user";
    }

    @PostMapping()
    public String create(@ModelAttribute("newUser")User user) {

        userServise.addUser(user);

        return "redirect:/user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){

        userServise.removeUser(id);

        return "redirect:/user";
    }
}
