package ua.com.zakharko.ihor.controllers;


import org.springframework.web.bind.annotation.*;
import ua.com.zakharko.ihor.controllers.forms.QuadraticEntityForm;
import ua.com.zakharko.ihor.model.QuadraticEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ua.com.zakharko.ihor.services.*;

@Controller
public class QuadraticEntityController {

    @Autowired
    QuadraticEntityService quadraticEntityService;

    @Value("${welcome.message}")
    private String message1;

    @Value("${view.message}")
    private String message2;

    @Value("${error.message}")
    private String errorMessage;

    @GetMapping(value = { "/", "/calculate"})
    public String calculate (Model model) {
        model.addAttribute("message1", message1);
        model.addAttribute("message2", message2);
        model.addAttribute("form", new QuadraticEntityForm());
        return "calculate";
    }

    @PostMapping("/calculate")
    public String saveQuadratic (Model model, @ModelAttribute ("form") QuadraticEntityForm quadraticEntityForm){
        QuadraticEntity quadratic = new QuadraticEntity(quadraticEntityForm.getA(), quadraticEntityForm.getB(), quadraticEntityForm.getC());
        if(quadratic.setAnswear()) {
            quadraticEntityService.save(quadratic);
            return "redirect:/result";
        }
        else {
            return "redirect:/error";
        }
    }

    @GetMapping("/result")
    public String result (Model model){
        model.addAttribute("result", errorMessage);
        return "result";
    }

    @GetMapping("/error")
    public String error (Model model){
        model.addAttribute("error", errorMessage);
        return "error";
    }

}
