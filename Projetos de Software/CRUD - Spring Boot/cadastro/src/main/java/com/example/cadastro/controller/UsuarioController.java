package com.example.cadastro.controller;

import com.example.cadastro.model.DadosCadastroUsuario;
import com.example.cadastro.model.Usuario;
import com.example.cadastro.model.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @PostMapping
    public  void cadastrarUsuario(@RequestBody DadosCadastroUsuario dados){
        usuarioRepositorio.save(new Usuario(dados.nome(),dados.sobrenome(),dados.email(),dados.senha()));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody DadosCadastroUsuario dados) {
        Optional<Usuario> usuario = usuarioRepositorio.findByEmail(dados.email());

        if (usuario.isPresent()) {
            if (usuario.get().getSenha().equals(dados.senha())) {
                return ResponseEntity.ok("✅ Login realizado com sucesso!");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("❌ Senha incorreta!");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("❌ Usuário não encontrado!");
        }
    }


}
