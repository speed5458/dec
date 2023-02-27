package com.dream.dec.controller;

import com.dream.dec.dto.OnlineConsultingDTO;
import com.dream.dec.service.OnlineConsultingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class OnlineConsultingController {

    private final OnlineConsultingService service;

    @GetMapping(value = "/onlineconsulting")
    public String Home() {
        return "page/Online-Consulting";
    }

    @GetMapping(value = "/onlineconsulting/mail")
    @ResponseBody
    public int createMessage(OnlineConsultingDTO dto) throws Exception {
        int rs = service.createMessage(dto);
        return rs;
    }

}
