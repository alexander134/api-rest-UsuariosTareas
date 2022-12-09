package com.init.usuario.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.init.usuario.dao.UsuariosDAO;
import com.init.usuario.daotarea.TareaDAO;
import com.init.usuario.entitys.Usuario;
import com.init.usuario.entitytarea.Tarea;

@RestController
@RequestMapping("")
public class UsuariosREST {
	
	@Autowired
	private UsuariosDAO usuarioDAO;
	
	@Autowired
	private TareaDAO tareaDAO;
	
	@GetMapping // http://localhost:8080/
	//@RequestMapping(value="", method = RequestMethod.GET)
	public String main() {
		return "<ul>"+
				"<li><a href='http://localhost:8080/llamadaprueba'>llamadaprueba</a></li>"+
				"<li><a href='http://localhost:8080/usuarioDefault'>usuarioDefault</a></li>"+
				"<li><a href='http://localhost:8080/todousuarios'>todousuarios</a></li>"+
				"<li><a href='http://localhost:8080/usuario/1'>usuario = 1</a></li>"+
				"<li><a href='http://localhost:8080/v2/api-docs'>estandar oas </a> 'O' <a href='http://localhost:8080/swagger-ui.html'>swagger-ui</a></li>"+
				"<li><a href='http://localhost:8080/borrarUsu/3'>usuario = 2 verificar primero que exista</a></li>"+
				"<li>-</li>"+
				"<li><a href='http://localhost:8080/tareaDefault'>tareaDefault</a></li>"+
				"<li><a href='http://localhost:8080/todasTareas'>todos Tareas</a></li>"+
				"<li><a href='http://localhost:8080/tarea/1'>tarea1</a></li>"+
			   "</ul>"; 
	}
	
	
	@RequestMapping(value="todousuarios", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> getAllUsuario(){
		List<Usuario> usu= usuarioDAO.findAll();
		return ResponseEntity.ok(usu);
	}
	
	@RequestMapping(value="usuario/{usu}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> getUsuarioPorId(@PathVariable("usu")Long usuLongId){
		Optional<Usuario> opt= usuarioDAO.findById(usuLongId);
		if(opt.isPresent()){
			return ResponseEntity.ok(opt.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@RequestMapping(value="llamadaprueba", method = RequestMethod.GET)
	public String llamadaPrueba() {
		return "esta es una prueba3"; 
	}
	
	@PostMapping
	public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usu){
		Usuario newUsu =usuarioDAO.save(usu);
		return ResponseEntity.ok(newUsu);
	}
	
	@DeleteMapping(value="borrarUsu/{usuId}") 
	public ResponseEntity<Void> borrarUsuario(@PathVariable("usuId") Long usuId){
		usuarioDAO.deleteById(usuId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping
	public ResponseEntity<Usuario> actUsuario(@RequestBody Usuario usuario){
		Optional<Usuario> opt= usuarioDAO.findById(usuario.getId());
		if(opt.isPresent()){
			Usuario updUsu = opt.get();
			updUsu.setMail(usuario.getMail());
			updUsu.setName(usuario.getName());
			updUsu.setPassword(usuario.getPassword());
			updUsu.setPhone(usuario.getPhone());
			
			usuarioDAO.save(updUsu);
			return ResponseEntity.ok(updUsu);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	@RequestMapping(value="usuarioDefault", method = RequestMethod.GET)
	public ResponseEntity<Usuario> getUsuarioUni(){
		Usuario usu = new Usuario();
		usu.setId(1L);
		usu.setName("alexander");
		usu.setMail("alex@alex.com");
		usu.setPassword("123456");
		usu.setPhone("99999999");
		return ResponseEntity.ok(usu);
	}
	
	@RequestMapping(value="tareaDefault", method = RequestMethod.GET)
	public ResponseEntity<Tarea> getTarea(){
		Tarea tarea = new Tarea();
		tarea.setIdTarea(1L);
		tarea.setIdUsuario(1L);
		tarea.setName("nompre de la primera tarea");
		tarea.setDescripcion("esta es la descricion de la primera tarea");
		return ResponseEntity.ok(tarea);
	}
	
	@RequestMapping(value="todasTareas", method = RequestMethod.GET)
	public ResponseEntity<List<Tarea>> getAllTareas(){
		List<Tarea> tarea = tareaDAO.findAll();
		return ResponseEntity.ok(tarea);
	}
	
	
	@RequestMapping(value="tarea/{tar}", method = RequestMethod.GET)
	public ResponseEntity<Tarea> getTareaPorId(@PathVariable("tar")Long tarLongId){
		Optional<Tarea> opt= tareaDAO.findById(tarLongId);
		if(opt.isPresent()){
			return ResponseEntity.ok(opt.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}

	@PostMapping(value = "crearTarea")
	public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea tar){
		Tarea newtar =tareaDAO.save(tar);
		return ResponseEntity.ok(newtar);
	}
	
	@DeleteMapping(value="borrarTarea/{tareaId}") 
	public ResponseEntity<Void> borrarTarea(@PathVariable("tareaId") Long tarId){
		tareaDAO.deleteById(tarId);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping(value="actualizarTarea")
	public ResponseEntity<Tarea> actTarea(@RequestBody Tarea tar){
		Optional<Tarea> opt= tareaDAO.findById(tar.getIdTarea());
		if(opt.isPresent()){
			Tarea updtar = opt.get();
			updtar.setDescripcion(tar.getDescripcion());
			updtar.setName(tar.getName());
			
			tareaDAO.save(updtar);
			return ResponseEntity.ok(updtar);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
}
