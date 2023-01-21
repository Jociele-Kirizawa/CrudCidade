package br.com.ada.cru.Model.cidade.dao.impl;

import br.com.ada.cru.Model.Pais;
import br.com.ada.cru.Model.cidade.Cidade;

import java.util.List;
import java.util.UUID;

public interface PaisDAO {
    void cadastrar(Pais pais);

    List<Pais> listar();

    Pais buscar(UUID id);

    void atualizar(UUID id,Pais pais );

    Pais apagar(UUID id);
}
