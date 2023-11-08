package es.altair.pruebaSpring.controladores;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.altair.pruebaSpring.bean.Acceso;
import es.altair.pruebaSpring.dao.AccesoRepository;
import es.altair.pruebaSpring.excepciones.ResourceNotFoundException;

@RestController
@RequestMapping("/api/acceso")
public class AccesoController {
	
	@Autowired
	AccesoRepository accesoRepository;
	
	@GetMapping
	  public Iterable<Acceso> findAllAccesos() {
	    return this.accesoRepository.findAll();
	  }

	  @PostMapping
	  public Acceso addOneEmployee(@RequestBody Acceso acceso) {
	    return this.accesoRepository.save(acceso);
	  }
	  
	  @DeleteMapping("/{id}")   
	     public void delete(@PathVariable Long id)
	     {
	      accesoRepository.deleteById(id);
	     }
	  
	  @PutMapping("/{id}")   
	     public void update(@PathVariable Long id,@RequestBody Acceso acceso )
	     {
		  Acceso a=accesoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
	     a.setCodigo_acceso(acceso.getCodigo_acceso());
	     a.setDescripcion(acceso.getDescripcion());
		  accesoRepository.save(a);
	     }
}
