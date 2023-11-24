package com.leydy.DAWII_CL2_sotoleydy.respository;

import com.leydy.DAWII_CL2_sotoleydy.model.bd.Rol;
import com.leydy.DAWII_CL2_sotoleydy.model.bd.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {
    Rol findByNomrol(String nomrol);
}
