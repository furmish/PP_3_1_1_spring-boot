package academy.kata.pp_3_1_1_springboot.controller;


import academy.kata.pp_3_1_1_springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import academy.kata.pp_3_1_1_springboot.service.UserService;


@Controller
@RequestMapping(value = "/users")
public class UserController {
    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String printUsers(@ModelAttribute(value = "user") User user, ModelMap model) {
        model.addAttribute("users", service.getUsers());
        return "users";
    }

    @PostMapping
    public String addUser(User user) {
        service.addUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/{id}/edit")
    public String editUser(@PathVariable(value = "id") long id, ModelMap model) {
        model.addAttribute("user", service.getUserById(id));
        return "edit";
    }

    @PostMapping(value = "/{id}/edit")
    public String updatedUser(@ModelAttribute(value = "user") User user) {
        service.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/{id}/delete")
    public String deleteUser(@PathVariable(value = "id") long id, ModelMap model) {
        model.addAttribute("user", service.getUserById(id));
        return "delete";
    }

    @PostMapping(value = "/{id}/delete")
    public String deletedUser(@ModelAttribute(value = "user") User user) {
        service.removeUser(user);
        return "redirect:/users";
    }
}
