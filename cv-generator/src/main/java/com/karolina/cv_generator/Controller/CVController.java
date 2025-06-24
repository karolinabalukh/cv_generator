package com.karolina.cv_generator.Controller;

import com.karolina.cv_generator.Model.CVData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cv")
public class CVController {

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("cvData", new CVData());
        return "cv-form";
    }

    @PostMapping("/preview")
    public String showPreview(@ModelAttribute CVData cvData, Model model) {
        model.addAttribute("cv", cvData);
        return "cv-preview";
    }
}
