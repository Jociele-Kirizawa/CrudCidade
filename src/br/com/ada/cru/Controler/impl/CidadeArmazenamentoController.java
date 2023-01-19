package br.com.ada.cru.Controler.impl;

import br.com.ada.cru.Controler.CidadeController;
import br.com.ada.cru.Controler.exceptions.CidadeNaoEncontrada;
import br.com.ada.cru.Model.Cidade;

import java.util.*;

public class CidadeArmazenamentoController implements CidadeController {
    private Map<UUID, Cidade> cidades = new HashMap<>();


    @Override
    public List<Cidade> listar() {
        return new ArrayList<>(cidades.values());
    }

    @Override
    public void cadastrar(Cidade cidade) {
        cidade.setId(UUID.randomUUID());
        cidades.put(cidade.getId(), cidade);


    }




    @Override
    public Cidade ler(UUID id) {
        Cidade encontrada = cidades.get(id);
        if (encontrada==null){
            throw new CidadeNaoEncontrada();
            }

        return encontrada;
    }

    @Override
    public void update(UUID id, Cidade cidade) {
        if (cidades.containsKey(id)) {
            cidades.put(id, cidade);
        } else {
            throw new CidadeNaoEncontrada();
        }

    }


    @Override
    public Cidade Delete(UUID id) {
        Cidade apagada = cidades.remove(id);
        return apagada;
    }



}
