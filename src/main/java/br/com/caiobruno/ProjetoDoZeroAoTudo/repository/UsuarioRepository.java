package br.com.caiobruno.ProjetoDoZeroAoTudo.repository;

import br.com.caiobruno.ProjetoDoZeroAoTudo.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity , Long> {


}
