package com.dream.dec.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IntroduceCardForeignerController {

    @GetMapping(value = "/foreigner")
    public String Home() {
        return "page/Introduce-Card-Foreigner";
    }


}
