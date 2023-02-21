package com.dream.dec.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IntroduceCardLocalController {

    @GetMapping(value = "/local")
    public String Home() {
        return "page/Introduce-Card-Local";
    }



}
