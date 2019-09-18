package com.EscuelaU.API_SitioU.Controllers;

import javax.validation.Valid;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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

    
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Alumno>>  listarAlumnos() {
    	Iterable<Alumno> alumnos = alumnoDAO.findAll();
		return new ResponseEntity<Iterable<Alumno>>(alumnos, HttpStatus.OK);
    }

    @RequestMapping(value = "/cargar", method = RequestMethod.POST)
    public ResponseEntity<Alumno> cargarAlumno(@Valid @RequestBody Alumno alumno) {
        Alumno alumnoCreado = alumnoDAO.save(alumno);
        return new ResponseEntity<Alumno>(alumnoCreado, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/borrar/{legajo}")
    public ResponseEntity<Alumno> borrar(@PathVariable Long legajo) {
    	if(alumnoDAO.findById(legajo).isPresent()) {
    		alumnoDAO.deleteById(legajo);
    		return new ResponseEntity<>(HttpStatus.OK);
    	} 
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
    @RequestMapping(value = "/getAlumno/{legajo}", method = RequestMethod.GET)
    public ResponseEntity<Alumno> getAlumno(@PathVariable Long legajo) {
    	Optional<Alumno> alumno = alumnoDAO.findById(legajo);
    	if(alumno.isPresent()) {
    		return new ResponseEntity<Alumno>(alumno.get(), HttpStatus.OK);
    	} 
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<Alumno> actualizar(@Valid @RequestBody Alumno alumno) {
    	
    	if(alumnoDAO.findById(alumno.getLegajo()).isPresent()) {
    		alumnoDAO.save(alumno);
    		return new ResponseEntity<>(HttpStatus.OK);
    	} 
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
