package Enterprise_Application.demo.controller;

import Enterprise_Application.demo.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactUsController {

    private final EmailService emailService;

    public ContactUsController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contactus";
    }

    @PostMapping("/contact")
    public String sendMessage(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String subject,
            @RequestParam String message,
            Model model) {

        String content =
                "Naam: " + name + "\n" +
                "Email: " + email + "\n\n" +
                message;

        emailService.sendMail(
                "admin@ngo.be",
                subject,
                content
        );

        model.addAttribute("success", true);

        return "contactus";
    }
}