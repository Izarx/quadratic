package ua.com.zakharko.ihor.controllers;


import ua.com.zakharko.ihor.controllers.forms.QuadraticEntityForm;
import ua.com.zakharko.ihor.model.QuadraticEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.zakharko.ihor.services.*;

@Controller
public class QuadraticEntityController {

    @Autowired
    QuadraticEntityService quadraticEntityService;

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @GetMapping("/calculate")
    public String calculate (Model model) {
        model.addAttribute("message", message);
        model.addAttribute("form", new QuadraticEntityForm());
        return "calculate";
    }

    @PostMapping("/calculate")
    public String saveQuadratic (Model model, @ModelAttribute ("form") QuadraticEntityForm quadraticEntityForm){
        QuadraticEntity quadratic = new QuadraticEntity(quadraticEntityForm.getA(), quadraticEntityForm.getB(), quadraticEntityForm.getC());
        if(quadratic.setAnswear()) {
            quadraticEntityService.save(quadratic);
            return "result";
        }
        else {
            return "error";
        }
    }

}
