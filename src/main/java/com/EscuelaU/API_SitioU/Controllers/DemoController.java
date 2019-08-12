package com.EscuelaU.API_SitioU.Controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.EscuelaU.API_SitioU.Models.Saludo;

@CrossOrigin
@RestController

public class DemoController {
    private static final String template = "Hola, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping(value = "/saludar", method = RequestMethod.GET)
    public Saludo greeting(@RequestParam(value="name", defaultValue="Escuela!") String name) {
        return new Saludo(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
