package com.test.asyncapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    static int count = 0;
    @GetMapping
    public String test() {
        try {
            System.out.println(Thread.currentThread() + " # " + count++);
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "OK#" + count;
    }
}
