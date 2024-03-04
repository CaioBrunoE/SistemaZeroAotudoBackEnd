package br.com.caiobruno.ProjetoDoZeroAoTudo.services;

import br.com.caiobruno.ProjetoDoZeroAoTudo.dto.UsuarioDTO;
import br.com.caiobruno.ProjetoDoZeroAoTudo.entities.UsuarioEntity;
import br.com.caiobruno.ProjetoDoZeroAoTudo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public List<UsuarioDTO> findAll(){
          List<UsuarioEntity> listEnttiti = repository.findAll();
        List<UsuarioDTO> listDTO = listEnttiti.stream().map(x -> new UsuarioDTO(x)).toList();
        return listDTO ;

    }

    public UsuarioDTO findById(Long id) {
     UsuarioEntity entity = repository.findById(id).get();
        UsuarioDTO dto = new UsuarioDTO(entity);
        return  dto;
    }

    public UsuarioDTO create(UsuarioEntity entity) {
        UsuarioEntity usuario = new UsuarioEntity(entity);
        repository.save(usuario);

        UsuarioDTO dto = new UsuarioDTO(usuario);
        return dto ;
    }

    public UsuarioDTO update(UsuarioEntity entity , Long id) {
        UsuarioEntity usuario = repository.findById(id).get();

        usuario.setNome(entity.getNome());
        usuario.setLogin(entity.getLogin());
        usuario.setEmail(entity.getEmail());
        usuario.setSenha(entity.getSenha());

        repository.save(usuario);
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);

        return usuarioDTO;

    }
    public void delete(Long id) {
        UsuarioEntity entity = repository.findById(id).get();
       repository.delete(entity);

    }
}
