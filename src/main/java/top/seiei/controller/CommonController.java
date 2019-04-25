package top.seiei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

    @RequestMapping("/test")
    public void test() {
        System.out.println("test");
    }
}
