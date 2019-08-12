package com.EscuelaU.API_SitioU.Models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
	Usuario findByUsername(String username);
}
