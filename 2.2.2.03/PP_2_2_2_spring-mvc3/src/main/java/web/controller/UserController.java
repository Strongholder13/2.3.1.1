package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("allUsers", userService.listUsers());
        return "/list";
    }
    @GetMapping("/new")
    public String newUser(Model model){
    User user = new User();
    model.addAttribute("user", user);
        return "/info";
    }
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect: /";
    }
    @GetMapping("/edit")
    public String editeUser(@RequestParam("id") int id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/edit";
    }

    @RequestMapping("/update")
    public String updateUser(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/";
    }
    @RequestMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}
