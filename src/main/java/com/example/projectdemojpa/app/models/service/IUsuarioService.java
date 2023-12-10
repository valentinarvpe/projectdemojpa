package com.example.projectdemojpa.app.models.service;

import java.util.List;

import com.example.projectdemojpa.app.models.entity.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();

	public void save(Usuario cliente);
		
	public Usuario findOne(Long id);
	
	public void delete(Long id);
}
