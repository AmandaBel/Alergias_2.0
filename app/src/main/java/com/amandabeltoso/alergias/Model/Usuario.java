package com.amandabeltoso.alergias.Model;

import java.util.List;

/**
 * Created by Amanda Beltoso on 24/05/2018.
 */

public class Usuario {

    private Integer id;
    private String nome;
    private Integer idade;
    private String telefone;
    private Integer cartaoSus;
    private String email;
    private String senha;
    private List<Alergia> alergias;

    public Usuario() {

    }

    public Usuario(Integer id, String nome, Integer idade, String telefone, Integer cartaoSus, String email, String senha, List<Alergia> alergias) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.cartaoSus = cartaoSus;
        this.email = email;
        this.senha = senha;
        this.alergias = alergias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getCartaoSus() {
        return cartaoSus;
    }

    public void setCartaoSus(Integer cartaoSus) {
        this.cartaoSus = cartaoSus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Alergia> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<Alergia> alergias) {
        this.alergias = alergias;
    }
}
