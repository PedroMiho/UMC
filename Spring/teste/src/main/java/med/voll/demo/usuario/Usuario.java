package med.voll.demo.usuario;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuarios")
@Entity(name =  "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;

    // Construtor sem parâmetros
    public Usuario() {}

    // Construtor com parâmetros
    public Usuario(String nome, String sobrenome, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
    }

}
