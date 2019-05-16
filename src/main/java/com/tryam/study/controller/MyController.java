package com.tryam.study.controller;

import com.tryam.study.entity.Account;
import com.tryam.study.entity.User;
import com.tryam.study.validator.AccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping
public class MyController {

    private static final String GET_USER_FIRST_NAME = "SELECT users.firstName FROM users JOIN accounts " +
            "ON users.account_id = accounts.Id";
    private static final String GET_LOGIN = "SELECT login FROM accounts";
    private static final String GET_PASSWORD = "SELECT password FROM accounts";

    @Autowired
    @Qualifier("accountValidator")
    private AccountValidator accountValidator;

    /*@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(accountValidator);
    }*/


    @GetMapping("/")
    public String getIndexPage(Model model) {
        model.addAttribute("account", new Account());
        return "index";
    }

    @PostMapping("/user")
    public String sendUserPage(@Valid @ModelAttribute("account") Account account, BindingResult bindingResult,
                               @RequestParam String login, @RequestParam String password) {
        accountValidator.validate(account, bindingResult);
        if (bindingResult.hasErrors()) {
            return "redirect:/";
        }
        if (login.equalsIgnoreCase(GET_LOGIN) && password.equalsIgnoreCase(GET_PASSWORD)) {
            //User user = userService.getUser(GET_USER_FIRST_NAME);
            return "user";
        } else {
            return "user";//"redirect:/index";
        }
    }

    @GetMapping("/user")
    public String getUserPage(Model model) {
        model.addAttribute("account", new User());
        return "user";
    }

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

}
