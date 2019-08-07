package com.EscuelaU.API_SitioU.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.EscuelaU.API_SitioU.Models.Alumno;
import com.EscuelaU.API_SitioU.Models.AlumnoDAO;

@CrossOrigin
@RestController
@RequestMapping("/alumnos")
public class AlumnosController {

    @Autowired
    private AlumnoDAO alumnoDAO;

    
    @RequestMapping(value = "/listarAlumnos", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Alumno>>  listarAlumnos() {
    	Iterable<Alumno> alumnos = alumnoDAO.findAll();
		return new ResponseEntity<Iterable<Alumno>>(alumnos, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/cargarAlumno", method = RequestMethod.POST)
    public ResponseEntity<Alumno> cargarAlumno(@Valid @RequestBody Alumno alumno) {
        Alumno alumnoCreado = alumnoDAO.save(alumno);
        return new ResponseEntity<Alumno>(alumnoCreado, HttpStatus.CREATED);
    }
    
}
