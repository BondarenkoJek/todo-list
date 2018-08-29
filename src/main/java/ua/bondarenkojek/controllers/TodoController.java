package ua.bondarenkojek.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.bondarenkojek.models.Task;
import ua.bondarenkojek.models.User;
import ua.bondarenkojek.services.TaskService;
import ua.bondarenkojek.services.UserService;

import java.util.Date;


import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@Transactional
public class TodoController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;



    @RequestMapping("/index/{userId}")
    public String view(@PathVariable("userId")Long userId, Model model) {
        model.addAttribute("user", userService.findById(userId));
        model.addAttribute("list", taskService.findAllByUser_Id(userId));
        return "index";
    }

    @RequestMapping(value = "/add/{userId}", method = POST)
    public String addTask(@ModelAttribute("task") Task task, @PathVariable("userId")Long userId) {
        task.setDate(new Date());
        task.setUser(userService.findById(userId));
//        User user = userService.findById(userId);
//        user.addTask(task);
        taskService.save(task);
//        userService.save(user);
//
        return "redirect:/index/" + userId;
    }

    @RequestMapping("/del/{userId}")
    public String del(@RequestParam("id") Long id, @PathVariable("userId") Long userId) {
//        Task task = taskService.findById(id);
//        User user = task.getUser();
//
//        user.removeTask(task);
//        taskService.deleteTask(task);
//        userService.save(user);
//        return "redirect:/index/" + user.getId();

        taskService.deleteTaskById(id);
        return "redirect:/index/" + userId;
    }


    @RequestMapping("/")
    public String viewSignIn() {
        return "sign_in";
    }

    @RequestMapping("/registration")
    public String viewRegistration() {
        return "registration";
    }

    @RequestMapping(value = "/sign_in", method = RequestMethod.POST)
    public String signIn(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        User user = userService.findByName(userName);

        if(user != null && user.getPassword().equals(password))
            return "redirect:/index/" + user.getId();

        return "redirect:/";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String registration(@ModelAttribute(name = "user") User user) {
        userService.save(user);
        return "redirect:/index/" + userService.findByName(user.getUserName()).getId();
    }

}
