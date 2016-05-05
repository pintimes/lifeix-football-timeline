package com.lifeix.football.timeline.module.temp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/temp")
public class TempController {


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String print(){
        return "hello";
    }

}
