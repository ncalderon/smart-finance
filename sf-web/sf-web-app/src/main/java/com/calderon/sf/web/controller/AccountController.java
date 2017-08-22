package com.calderon.sf.web.controller;

import com.calderon.sf.data.model.AccountEntity;
import com.calderon.sf.data.service.AccountService;
import com.calderon.sf.data.service.BankService;
import com.calderoncode.sf.transport.AccountStatusEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller()
@RequestMapping("/account")
public class AccountController extends WebMvcConfigurerAdapter {

    private static final Logger log = LogManager.getLogger(AccountController.class.getName());


    private AccountService accountService;
    private BankService bankService;

    @Autowired
    public AccountController(AccountService accountService, BankService bankService) {
        this.accountService = accountService;
        this.bankService = bankService;
    }

    @GetMapping()
    public String index (Model model){
        model.addAttribute("viewState", ViewStateEnum.VIEW.toString());
        model.addAttribute("accounts", accountService.findAll());
        return "/account";
    }

    @GetMapping(path = "/new")
    public String create (Model model){
        model.addAttribute("viewState", ViewStateEnum.CREATE.toString());
        model.addAttribute("account", new AccountEntity());
        model.addAttribute("banks", bankService.findAll());
        return "/account";
    }

    @GetMapping("/account/:id")
    public String view (Model model){
        model.addAttribute("viewState", ViewStateEnum.VIEW.toString());
        model.addAttribute("account", new AccountEntity());
        return "/account";
    }

    @PostMapping("/save")
    public String save (@ModelAttribute("account") AccountEntity account, BindingResult result, SessionStatus status, Model model){
        log.info(account);
        if(result.hasErrors()) {
            model.addAttribute("viewState", ViewStateEnum.CREATE.toString());
            model.addAttribute("banks", bankService.findAll());
            return "/account";
        }
        model.addAttribute("viewState", ViewStateEnum.VIEW.toString());
        return "/account";
    }
}
