package com.project.urlcount.urlhitcounter.controller;

import com.project.urlcount.urlhitcounter.model.Url;
import com.project.urlcount.urlhitcounter.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/visitor-count-app")
public class UrlController {
        @Autowired
        private UrlService urlHitService;

        @GetMapping("/count")
        public Url getCount() {
               return urlHitService.getCount();
        }
    }

