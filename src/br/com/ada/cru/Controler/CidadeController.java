package br.com.ada.cru.Controler;

import br.com.ada.cru.Model.Cidade;

import java.util.List;
import java.util.UUID;

public interface CidadeController {
    List<Cidade>listar();

    void cadastrar (Cidade cidade);

    Cidade ler(UUID id);

    void update (UUID id, Cidade cidade);

    Cidade Delete (UUID id);


}
