package com.test.asyncapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class TestController {

    public static AtomicInteger count = new AtomicInteger(0);
    @GetMapping
    public Integer test() {
        int a = count.getAndIncrement();
        try {
            System.out.println(Thread.currentThread() + " # " + a);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
    @GetMapping("/e")
    public Integer teste() {
        int a = count.getAndIncrement();
        try {
            System.out.println(Thread.currentThread() + " # " + a);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(a % 3 ==0 ){
            throw new RuntimeException(a+"");
        }
        return a;
    }
}
