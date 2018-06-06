package com.amandabeltoso.alergias.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amanda Beltoso on 19/04/2018.
 */

public class Alergia {

    private Integer id;
    private String alergia;
    private String descricao;
    private Usuario usuario;

    public Alergia(){


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
