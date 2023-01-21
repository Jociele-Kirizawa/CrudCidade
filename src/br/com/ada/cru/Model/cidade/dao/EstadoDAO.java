package br.com.ada.cru.Model.cidade.dao;

import br.com.ada.cru.Model.Estado;
import br.com.ada.cru.Model.cidade.Cidade;

import java.util.List;
import java.util.UUID;

public interface EstadoDAO  {


    void cadastrar(Estado estado);

    List<Estado> listar();

    Estado buscar(UUID id);

    void atualizar(UUID id,Estado estado );

    Estado apagar(UUID id);
}
