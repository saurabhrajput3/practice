package com.project.urlcount.urlhitcounter.service;

import com.project.urlcount.urlhitcounter.model.Url;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Service
public class UrlService {
int count=1;
public Url getCount(){
    Url url=new Url(count++);
    return url;
}
}
