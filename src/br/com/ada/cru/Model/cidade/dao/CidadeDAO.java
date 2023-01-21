package br.com.ada.cru.Model.cidade.dao;

import br.com.ada.cru.Model.Estado;
import br.com.ada.cru.Model.cidade.Cidade;

import java.util.List;
import java.util.UUID;

public interface CidadeDAO {

    void cadastrar(Cidade cidade);

    List<Cidade> listar();

    Cidade buscar(UUID id);

    void atualizar(UUID id,Cidade Cidade );

    Cidade apagar(UUID id);

}
