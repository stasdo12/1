package com.skinDreams.School.controllers;

import com.skinDreams.School.entity.Client;
import com.skinDreams.School.service.ClientService;
import com.skinDreams.School.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SchoolController {

    private final ClientService clientService;
    private final EmailSenderService emailSenderService;

    @Autowired
    public SchoolController(ClientService clientService, EmailSenderService emailSenderService) {
        this.clientService = clientService;

        this.emailSenderService = emailSenderService;
    }


    @GetMapping("/")
    public String SchoolPage(Model model) {
        model.addAttribute("client", new Client());
        return "school_page";
    }


    @PostMapping("/new_client")
    public String newClient(@Valid   @ModelAttribute("client") Client client, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "school_page";
        }
        clientService.saveClient(client);
        String toEmail = "stanislavdonetc@gmail.com";
        emailSenderService.sendEmail(toEmail, "Client orders consultation", "Client names: " +
                client.getName() +"\n" + "Client phone: " +
                client.getPhone());

        redirectAttributes.addFlashAttribute("successMessage", "ДЯКУЮ з Вами скоро зв'яжуться");
        return "redirect:/#success";
    }


}
