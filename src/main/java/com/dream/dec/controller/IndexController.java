package com.dream.dec.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.net.MalformedURLException;

@Controller
@RequiredArgsConstructor
public class IndexController {

    @GetMapping(value = "/image/meta")
    @ResponseBody
    public ResponseEntity<Resource> showImage() throws MalformedURLException {
        Resource resource = new ClassPathResource("static/img/photo/facility/facility-img4.jpeg");
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .cacheControl(CacheControl.noCache())
                .header(HttpHeaders.CONTENT_DISPOSITION)
                .body(resource);
    }


}
