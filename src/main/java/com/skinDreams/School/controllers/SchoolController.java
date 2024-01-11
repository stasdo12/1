package com.skinDreams.School.controllers;

import com.skinDreams.School.entity.Client;
import com.skinDreams.School.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SchoolController {

    private final ClientService clientService;

    @Autowired
    public SchoolController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping("/")
    public String SchoolPage() {
        return "school_page";
    }


    @PostMapping("/new_client")
    public String newClient(Client client, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "school_page";
        }
        clientService.saveClient(client);
        return "redirect:/";
    }
}
