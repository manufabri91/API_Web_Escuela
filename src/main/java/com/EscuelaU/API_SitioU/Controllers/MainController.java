package com.EscuelaU.API_SitioU.Controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.EscuelaU.API_SitioU.Models.Greeting;

@RestController

public class MainController {
    private static final String template = "Hola, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/saludar", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="Escuela!") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
