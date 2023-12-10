package com.example.projectdemojpa.app.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.projectdemojpa.app.models.dao.IUsuarioDao;
import com.example.projectdemojpa.app.models.entity.Usuario;


@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	public void save(Usuario cliente) {
		try {
			usuarioDao.save(cliente);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Usuario findOne(Long id) {
		Usuario user = new Usuario();
		try {
			return usuarioDao.findById(id).orElse(user);
		} catch (Exception e) {
			e.printStackTrace();
			return user;
		}
	}

	@Override
	public void delete(Long id) {
		try {
			usuarioDao.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public String update(Usuario usuario) {
		try {
			Usuario Usuarioencontrado = usuarioDao.findById(usuario.getId()).orElse(null);
			if (Usuarioencontrado != null) {
				usuarioDao.save(usuario);
				return "Actualizado";
			} else {
				return "No existe";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
