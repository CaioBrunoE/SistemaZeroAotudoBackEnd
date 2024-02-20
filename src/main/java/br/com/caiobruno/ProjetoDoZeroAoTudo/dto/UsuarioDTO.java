package br.com.caiobruno.ProjetoDoZeroAoTudo.dto;

import br.com.caiobruno.ProjetoDoZeroAoTudo.entities.UsuarioEntity;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;

public class UsuarioDTO {



    private Long id;
    private String nome;
    private String login;
    private String senha;
    private String email;

    public  UsuarioDTO (UsuarioEntity usuarioEntity){
        BeanUtils.copyProperties(usuarioEntity, this);
    }

    public UsuarioDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
