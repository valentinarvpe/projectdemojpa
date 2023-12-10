package com.example.projectdemojpa.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.projectdemojpa.app.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

}
