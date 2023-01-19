package br.com.ada.cru.Controler.impl;

import br.com.ada.cru.Controler.exceptions.EstadoNaoEncontrado;
import br.com.ada.cru.Model.Estado;

import java.util.*;

public class EstadoArmazenamentoController implements EstadoController{

    private Map<UUID, Estado> estados = new HashMap<>();
    @Override
    public List<Estado> listar() {
        return new ArrayList<>(estados.values());
    }

    @Override
    public void cadastrar(Estado estado) {
        estado.setId(UUID.randomUUID());
        estados.put(estado.getId(), estado);

    }

    @Override
    public Estado ler(UUID id) {
        Estado encontrado = estados.get(id);
        if(encontrado==null){
            throw new EstadoNaoEncontrado();
        }
        return encontrado;
    }

    @Override
    public void update(UUID id, Estado estado) {
        if (estados.containsKey(id)){
            estados.put(id, estado);
        }else {
            throw new EstadoNaoEncontrado();
        }

    }

    @Override
    public Estado delete(UUID id) {
        Estado estado = estados.remove(id);
        return estado;
    }
}
