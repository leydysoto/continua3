package com.leydy.DAWII_CL2_sotoleydy.respository;

import com.leydy.DAWII_CL2_sotoleydy.model.bd.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Usuario findByEmail(String email);
    Usuario findByNomusuario(String nomusuario);
    Usuario findByPassword(String password);

}
