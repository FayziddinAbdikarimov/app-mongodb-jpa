package uz.fayziddin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.fayziddin.entity.Contact;
import uz.fayziddin.repository.ContactRepository;

import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @GetMapping
    public String getContactList(){
        contactRepository.findAll();
        return "contact";
    }

    @GetMapping("/addPage")
    public String addPage(){
        return "addPage";
    }

    @PostMapping("/save")
    public String saveContact(@RequestParam String first_name,
                               @RequestParam String last_name,
                               @RequestParam String phone,
                              Model model){
        contactRepository.save(new Contact(first_name, last_name, phone));
        model.addAttribute("contacts", contactRepository.findAll());
        return "contact";
    }
}
