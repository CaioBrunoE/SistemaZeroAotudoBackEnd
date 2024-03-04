package br.com.caiobruno.ProjetoDoZeroAoTudo.controllers;

import br.com.caiobruno.ProjetoDoZeroAoTudo.dto.UsuarioDTO;
import br.com.caiobruno.ProjetoDoZeroAoTudo.entities.UsuarioEntity;
import br.com.caiobruno.ProjetoDoZeroAoTudo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuraioController {

    @Autowired
    private UsuarioService service;


    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll(){
         List<UsuarioDTO> dto = service.findAll();
         return ResponseEntity.ok(dto);

    }
    @GetMapping(value="/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id){
        UsuarioDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
 
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioEntity entity){
        UsuarioDTO dto = service.create(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioEntity entity, @PathVariable Long id){
        UsuarioDTO dto = service.update(entity,  id);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);

    }

    @DeleteMapping(value="/{id}")
    public  ResponseEntity<Void> delete(@PathVariable Long id){

        if (id != null) {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }



}
