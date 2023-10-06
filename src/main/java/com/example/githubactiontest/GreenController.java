package com.example.githubactiontest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class GreenController {

    @Value("${app.version:1.0.0}")
    String version;

    @GetMapping("/submit")
    public String submitData(@RequestParam String inputText, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(inputText, String.class);
        String versionCheck = "Hello CICD! version: " + version;
        model.addAttribute("version", versionCheck);
        model.addAttribute("inputText", inputText);
        model.addAttribute("apiResponse", response);
        return "result";
    }

}
