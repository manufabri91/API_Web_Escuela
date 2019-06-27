package com.EscuelaU.API_SitioU.Controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.EscuelaU.API_SitioU.Models.Greeting;

@CrossOrigin
@RestController
@RequestMapping("/alumnos")
public class AlumnosController {
    private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="alumno 1") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format("alumno: ", name));
    }
}
