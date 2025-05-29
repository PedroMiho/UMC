package med.voll.demo.controller;


import med.voll.demo.usuario.DadosCadastroUsuario;
import med.voll.demo.usuario.Usuario;
import med.voll.demo.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public void cadastrarUsuario(@RequestBody DadosCadastroUsuario dados){
        repository.save(new Usuario(dados.nome(), dados.sobrenome(), dados.email()));
    }

}
