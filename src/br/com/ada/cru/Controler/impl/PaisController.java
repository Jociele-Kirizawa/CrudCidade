package br.com.ada.cru.Controler.impl;

import br.com.ada.cru.Model.Pais;

import java.util.List;
import java.util.UUID;

public interface PaisController {
    List<Pais> listar();
    void cadastrar (Pais pais);
    Pais ler (UUID id);
   void update (UUID id, Pais cidade);
    Pais delete (UUID id);

}
