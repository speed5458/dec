package com.dream.dec.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class OnlineConsultingController {

    @GetMapping(value = "/onlineconsulting")
    public String Home() {
        return "page/Online-Consulting";
    }


}
