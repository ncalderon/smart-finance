package com.calderon.sf.web.controller;

import com.calderon.sf.data.model.AccountEntity;
import com.calderon.sf.data.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by nathaniel on 7/11/2017.
 */
@Controller

public class GreetingController {

    @Autowired
    private AccountService service;
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/test")
    @ResponseBody()
    public List<AccountEntity> test() {
        return service.findByAccName("Gold RD");
    }
}
