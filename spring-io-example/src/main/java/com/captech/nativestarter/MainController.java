package com.captech.nativestarter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("yo")
    public String yoWorld() {
        return "yo world";
    }
}
