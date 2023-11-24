package com.leydy.DAWII_CL2_sotoleydy.service;

import com.leydy.DAWII_CL2_sotoleydy.model.bd.Rol;
import com.leydy.DAWII_CL2_sotoleydy.model.bd.Usuario;
import com.leydy.DAWII_CL2_sotoleydy.respository.RolRepository;
import com.leydy.DAWII_CL2_sotoleydy.respository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
@AllArgsConstructor
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder =
            new BCryptPasswordEncoder();

    public Usuario buscarUsuarioPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public Usuario buscarUsuarioPorPassword(String password){
        return usuarioRepository.findByPassword(password);
    }

    public Usuario buscarUsuarioPorNombreUsuario(String username){
        return usuarioRepository.findByNomusuario(username);
    }

    public Usuario guardarUsuario(Usuario usuario){
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        usuario.setActivo(true);
        if(usuarioRepository.findByEmail(usuario.getEmail()) != null){

        }
        Rol usuarioRol = rolRepository.findByNomrol("ADMIN");
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        return usuarioRepository.save(usuario);
    }


}
