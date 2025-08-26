package com.example.cadastro.controller;

import com.example.cadastro.model.DadosCadastroUsuario;
import com.example.cadastro.model.Usuario;
import com.example.cadastro.model.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @PostMapping
    public ResponseEntity<String> cadastrarUsuario(@RequestBody DadosCadastroUsuario dados) {
        boolean existeEmail = usuarioRepositorio.findByEmail(dados.email()).isPresent();

        if (existeEmail) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Erro: E-mail já cadastrado!");
        }

        usuarioRepositorio.save(new Usuario(dados.nome(), dados.sobrenome(), dados.email(), dados.senha()));
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado com sucesso!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody DadosCadastroUsuario dados) {
        Optional<Usuario> usuario = usuarioRepositorio.findByEmail(dados.email());

        if (usuario.isPresent()) {
            if (usuario.get().getSenha().equals(dados.senha())) {
                return ResponseEntity.ok(usuario.get());
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("erro", "❌ Senha incorreta!"));
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("erro", "❌ Usuário não encontrado!"));
        }
    }

    // Atualizar usuário pelo ID
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable Long id, @RequestBody DadosCadastroUsuario dados) {
        Optional<Usuario> usuarioOptional = usuarioRepositorio.findById(id);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();

            usuario.setNome(dados.nome());
            usuario.setSobrenome(dados.sobrenome());
            // Se quiser permitir alteração de email, remova o comentário:
            // usuario.setEmail(dados.email());
            usuario.setSenha(dados.senha());

            usuarioRepositorio.save(usuario);
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("erro", "❌ Usuário não encontrado para atualização!"));
        }
    }

    // Excluir usuário pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirUsuario(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepositorio.findById(id);

        if (usuarioOptional.isPresent()) {
            usuarioRepositorio.deleteById(id);
            return ResponseEntity.ok(Map.of("mensagem", "✅ Usuário excluído com sucesso!"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("erro", "❌ Usuário não encontrado para exclusão!"));
        }
    }
}
