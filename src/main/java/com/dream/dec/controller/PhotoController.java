package com.dream.dec.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PhotoController {

    @GetMapping(value = "/photo")
    public String Home() {
        return "page/photo";
    }


}
