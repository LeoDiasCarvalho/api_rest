package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.leodias.api_rest.models.User;
import com.leodias.api_rest.repositories.UserRepository;

    @Service
    public class UserService {
    
    @Autowired
    private UserRepository repo;

    public ResponseEntity<List<User>> buscarTodosUsuario(){
        List<User> list = repo.findAll();
        return ResponseEntity.status(200).body(list);
    }

    public ResponseEntity<Optional<User>> buscarUsuarioPorId(@PathVariable Long id){
        Optional<User> user = repo.findById(id);
        return ResponseEntity.status(200).body(user);
    }

    public ResponseEntity<User> salvarUsuario(@PathVariable User user){
        repo.save(user);
        return ResponseEntity.status(201).body(user);
    }

     public ResponseEntity<User> atualizarUsuario(@PathVariable User user){
        repo.save(user);
        return ResponseEntity.status(200).body(user);
    }

    public void deletarUsuario(@PathVariable User user){
        
        if(repo.existsById(user.getId())){
            repo.delete(user);
            ResponseEntity.status(204);
        }else{
            ResponseEntity.status(500);
        }   
    }

}
