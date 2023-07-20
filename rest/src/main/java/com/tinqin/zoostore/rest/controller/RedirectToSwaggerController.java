package com.tinqin.zoostore.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectToSwaggerController {

    @GetMapping(path = "/")
    public String redirectToSwagger() {
        return "redirect:/swagger-ui/index.html";
    }
}
