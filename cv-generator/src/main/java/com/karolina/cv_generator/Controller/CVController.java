package com.karolina.cv_generator.Controller;

import com.karolina.cv_generator.Model.CVData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

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
        List<String> originalSkills = cvData.getSkills();

        if (originalSkills != null && originalSkills.size() == 1) {
            List<String> parsedSkills = Arrays.stream(originalSkills.get(0).split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .toList();
            cvData.setSkills(parsedSkills);
        }

//        MultipartFile file = cvData.getPhoto();
//        if (file != null && !file.isEmpty()) {
//            try {
//                byte[] bytes = file.getBytes();
//                String base64 = Base64.getEncoder().encodeToString(bytes);
//                cvData.setPhotoBase64(base64);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        model.addAttribute("cv", cvData);
        return "cv-preview";
    }
}
