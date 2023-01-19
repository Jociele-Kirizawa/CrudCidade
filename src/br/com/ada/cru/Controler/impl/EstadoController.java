package br.com.ada.cru.Controler.impl;

import br.com.ada.cru.Model.Estado;

import java.util.List;
import java.util.UUID;

public interface EstadoController {
    List<Estado> listar();

    void cadastrar(Estado estado); //cadastro de pessoa

    Estado ler(UUID id);

    void update (UUID id, Estado estado);

   Estado delete (UUID id);
}
