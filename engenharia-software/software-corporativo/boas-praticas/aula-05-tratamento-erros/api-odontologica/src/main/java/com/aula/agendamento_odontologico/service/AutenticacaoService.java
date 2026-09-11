package com.aula.agendamento_odontologico.service;


import com.aula.agendamento_odontologico.repository.UsuarioRepository;
import org.hibernate.annotations.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    //Repositorio responsavel por buscar valores no banco de dados
    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Busca no banco de dados o usuário pelo login
        return repository.findByLogin(username);
    }
}
