package com.workbook.web.controller;

import com.workbook.service.UserService.UserCommandService;
import com.workbook.web.dto.UserRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserViewController {

    private final UserCommandService userCommandService;

    @PostMapping("/users/signup")
    public String joinUser(@ModelAttribute("userJoinDto") UserRequestDTO.JoinDto request,
                           BindingResult bindingResult,
                           Model model) {
        if (bindingResult.hasErrors()) {

            return "signup";
        }

        try {
            userCommandService.joinUser(request);
            return "redirect:/login";
        } catch (Exception e) {

            model.addAttribute("error", e.getMessage());
            return "signup";
        }
    }

    public UserViewController(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("userJoinDto", new UserRequestDTO.JoinDto());
        return "signup";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
