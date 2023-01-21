package br.com.ada.cru.Model;

import java.io.Serializable;
import java.util.UUID;

public class Pais implements Serializable {
    public static final long serialVersionUID = 1l;

   private String nome;
   private UUID id;

   private String sigla;

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
