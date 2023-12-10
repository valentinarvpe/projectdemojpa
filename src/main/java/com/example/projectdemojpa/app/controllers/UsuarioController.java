package com.example.projectdemojpa.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.projectdemojpa.app.models.entity.Usuario;
import com.example.projectdemojpa.app.models.service.UsuarioService;

@RestController
@RequestMapping (value="usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService clienteService;
	
	@GetMapping("/test")
	public void prueba() {
		System.out.println("Mensaje de prueba");
		System.out.println(clienteService.findAll());
	}

	@GetMapping("/listar")
	public List<Usuario> traeUsuarios(){
		return clienteService.findAll();
	}
	
	@RequestMapping(value ="/guardar", method = RequestMethod.POST)
	public ResponseEntity<String> guardar (@RequestBody Usuario usuario) {
		clienteService.save(usuario);
		return ResponseEntity.ok("Guardado");
	}
	
	@RequestMapping(value ="/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<String> actualizar (@RequestBody Usuario usuario) {
		String resp = clienteService.update(usuario);
		return ResponseEntity.ok(resp);
	}
	
	@RequestMapping(value ="/eliminar", method = RequestMethod.DELETE)
	public ResponseEntity<String> eliminar (@RequestParam Long id) {
		String resp = "";
		clienteService.delete(id);
		return ResponseEntity.ok(resp);
	}
}
