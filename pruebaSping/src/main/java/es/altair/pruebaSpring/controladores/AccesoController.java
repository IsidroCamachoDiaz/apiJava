package es.altair.pruebaSpring.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.altair.pruebaSpring.bean.Acceso;
import es.altair.pruebaSpring.dao.AccesoRepository;

@RestController
public class AccesoController {
	
	@Autowired
	AccesoRepository accesoRepository;
	
	@GetMapping("/acceso")
	  public Iterable<Acceso> findAllAccesos() {
	    return this.accesoRepository.findAll();
	  }

	  @PostMapping("/acceso")
	  public Acceso addOneEmployee(@RequestBody Acceso acceso) {
	    return this.accesoRepository.save(acceso);
	  }

}
