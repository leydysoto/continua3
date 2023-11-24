package com.leydy.DAWII_CL2_sotoleydy.controller;

import com.leydy.DAWII_CL2_sotoleydy.model.bd.Usuario;
import com.leydy.DAWII_CL2_sotoleydy.model.security.UsuarioSecurity;
import com.leydy.DAWII_CL2_sotoleydy.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/auth")
public class Login {
    private UsuarioService usuarioService;
    @GetMapping("/login")
    public String login(){
        return "frontoffice/auth/frmLogin";
    }
    @GetMapping("/registrar")
    public String registrar(){
        return "frontoffice/auth/frmRegistroUsuario";
    }

    @PostMapping("/guardarusuario")
    public String guardarUsuario(@ModelAttribute Usuario usuario){
        usuarioService.guardarUsuario(usuario);
        return "frontoffice/auth/frmLogin";
    }
    @GetMapping("/login-success")
    public String loginSuccess(){
        return "redirect:/auth/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        UsuarioSecurity usuarioSecurity = (UsuarioSecurity) userDetails;
        session.setAttribute("usuario", usuarioSecurity.getUsername());
        return "frontoffice/principal";
    }






}
