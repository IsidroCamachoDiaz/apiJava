package es.altair.pruebaSpring.controladores;

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
import es.altair.pruebaSpring.bean.Usuario;
import es.altair.pruebaSpring.dao.AccesoRepository;
import es.altair.pruebaSpring.dao.UsuarioRepository;
import es.altair.pruebaSpring.excepciones.ResourceNotFoundException;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
		@Autowired
		UsuarioRepository usuarioRepository;
		
		@GetMapping
		  public Iterable<Usuario> findAllAccesos() {
		    return this.usuarioRepository.findAll();
		  }

		  @PostMapping
		  public Usuario addOneEmployee(@RequestBody Usuario usuario) {
		    return this.usuarioRepository.save(usuario);
		  }
		  
		  @DeleteMapping("/{id}")   
		     public void delete(@PathVariable Long id)
		     {
			  usuarioRepository.deleteById(id);
		     }
		  
		  @PutMapping("/{id}")   
		     public void update(@PathVariable Long id,@RequestBody Usuario u2 )
		     {
			  Usuario u=usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
		     u.setAcceso(u.getAcceso());
		     u.setApellidos_usuario(u2.getApellidos_usuario());
		     u.setClave_usuario(u2.getClave_usuario());
		     u.setDni_usuario(u2.getDni_usuario());
		     u.setEstabloqueado_usuario(u2.isEstabloqueado_usuario());
		     u.setFch_alta_usuario(u2.getFch_alta_usuario());
		     u.setFch_baja_usuario(u2.getFch_baja_usuario());
		     u.setFch_fin_bloqueo_usuario(u2.getFch_fin_bloqueo_usuario());
		     u.setNombre_usuario(u2.getNombre_usuario());
		     u.setTlf_usuario(u2.getTlf_usuario());
		     usuarioRepository.save(u);
		     }
}
