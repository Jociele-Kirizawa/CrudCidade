package Controler;

import Model.Cidade;

import java.util.UUID;

public interface CidadeController {

    void cadastrar (Cidade cidade);

    Cidade ler(UUID id);

    Cidade update (UUID id, Cidade cidade);

    Cidade Delete (UUID id);


}
