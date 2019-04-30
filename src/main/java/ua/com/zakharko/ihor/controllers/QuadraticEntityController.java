package ua.com.zakharko.ihor.controllers;


import org.springframework.web.bind.annotation.*;
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

    @GetMapping(value = { "/", "/calculate"})
    public String calculate (Model model) {
        model.addAttribute("message1", message1);
        model.addAttribute("message2", message2);
        model.addAttribute("form", new QuadraticEntityForm());
        return "calculate";
    }

    @PostMapping("/calculate")
    public String saveQuadratic (Model model, @ModelAttribute ("form") QuadraticEntityForm quadraticEntityForm){
        Integer a = quadraticEntityForm.getA();
        Integer b = quadraticEntityForm.getB();
        Integer c = quadraticEntityForm.getC();
        QuadraticEntity quadratic = new QuadraticEntity(a, b, c);
        if(quadratic.setAnswear()) {
            quadraticEntityService.save(quadratic);
            return "redirect:/result?id=" + quadratic.getId();
        }
        else {
            return "redirect:/error";
        }
    }

    @GetMapping("/result")
    public String resultPage (Model model, @RequestParam("id") Long id){
        QuadraticEntity quadraticEntity = quadraticEntityService.getById(id);
        if (quadraticEntity != null) {
            model.addAttribute("quadratic", quadraticEntity);
            return "result";
        }
        else return "redirect:/error";
    }

}
