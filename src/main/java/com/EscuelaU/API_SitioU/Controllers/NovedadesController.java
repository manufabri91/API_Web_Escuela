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

import com.EscuelaU.API_SitioU.Models.Novedad;
import com.EscuelaU.API_SitioU.Models.NovedadDAO;

@CrossOrigin
@RestController
@RequestMapping("/novedades")
public class NovedadesController {

    @Autowired
    private NovedadDAO novedadDAO;

    
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Novedad>>  listarNovedades() {
    	Iterable<Novedad> novedades = novedadDAO.findAll();
		return new ResponseEntity<Iterable<Novedad>>(novedades, HttpStatus.OK);
    }

    @RequestMapping(value = "/cargar", method = RequestMethod.POST)
    public ResponseEntity<Novedad> cargarDocentes(@Valid @RequestBody Novedad novedad) {
    	Novedad novedadCreado = novedadDAO.save(novedad);
        return new ResponseEntity<Novedad>(novedadCreado, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/borrar/{id_novedad}")
    public ResponseEntity<Novedad> borrar(@PathVariable Long id_novedad) {
    	if(novedadDAO.findById(id_novedad).isPresent()) {
    		novedadDAO.deleteById(id_novedad);
    		return new ResponseEntity<>(HttpStatus.OK);
    	} 
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
    @RequestMapping(value = "/getDocente/{id_novedad}", method = RequestMethod.GET)
    public ResponseEntity<Novedad> getNovedad(@PathVariable Long id_novedad) {
    	Optional<Novedad> novedad = novedadDAO.findById(id_novedad);
    	if(novedad.isPresent()) {
    		return new ResponseEntity<Novedad>(novedad.get(), HttpStatus.OK);
    	} 
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity<Novedad> actualizar(@Valid @RequestBody Novedad novedad) {
    	
    	if(novedadDAO.findById(novedad.getId_novedad()).isPresent()) {
    		novedadDAO.save(novedad);
    		return new ResponseEntity<>(HttpStatus.OK);
    	} 
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
