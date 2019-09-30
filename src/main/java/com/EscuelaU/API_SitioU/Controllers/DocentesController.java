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

import com.EscuelaU.API_SitioU.Models.Docente;
import com.EscuelaU.API_SitioU.Models.DocenteDAO;

@CrossOrigin
@RestController
@RequestMapping("/docentes")
public class DocentesController {

    @Autowired
    private DocenteDAO docenteDAO;

    
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Docente>>  listarDocentes() {
    	Iterable<Docente> docentes = docenteDAO.findAll();
		return new ResponseEntity<Iterable<Docente>>(docentes, HttpStatus.OK);
    }

    @RequestMapping(value = "/cargar", method = RequestMethod.POST)
    public ResponseEntity<Docente> cargarDocentes(@Valid @RequestBody Docente docente) {
        Docente docenteCreado = docenteDAO.save(docente);
        return new ResponseEntity<Docente>(docenteCreado, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/borrar/{legajo}")
    public ResponseEntity<Docente> borrar(@PathVariable Long legajo) {
    	if(docenteDAO.findById(legajo).isPresent()) {
    		docenteDAO.deleteById(legajo);
    		return new ResponseEntity<>(HttpStatus.OK);
    	} 
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
    @RequestMapping(value = "/getDocente/{legajo}", method = RequestMethod.GET)
    public ResponseEntity<Docente> getDocente(@PathVariable Long legajo) {
    	Optional<Docente> docente = docenteDAO.findById(legajo);
    	if(docente.isPresent()) {
    		return new ResponseEntity<Docente>(docente.get(), HttpStatus.OK);
    	} 
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<Docente> actualizar(@Valid @RequestBody Docente docente) {
    	
    	if(docenteDAO.findById(docente.getLegajo()).isPresent()) {
    		docenteDAO.save(docente);
    		return new ResponseEntity<>(HttpStatus.OK);
    	} 
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
