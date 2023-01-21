package br.com.ada.cru.Controler.impl;

import br.com.ada.cru.Model.Estado;
import br.com.ada.cru.Model.cidade.dao.EstadoDAO;

import java.util.List;
import java.util.UUID;

public class EstadoArmazenamentoDefinitivo implements EstadoController{

    private EstadoDAO estadoDAO;

    public EstadoArmazenamentoDefinitivo(EstadoDAO estadoDAO) {
        this.estadoDAO = estadoDAO;
    }

    @Override
    public List<Estado> listar() {
        return estadoDAO.listar();
    }

    @Override
    public void cadastrar(Estado estado) {
        estado.setId(UUID.randomUUID());
        estadoDAO.cadastrar(estado);

    }

    @Override
    public Estado ler(UUID id) {
        return estadoDAO.buscar(id);
    }

    @Override
    public void update(UUID id, Estado estado) {
        estadoDAO.atualizar(id, estado);

    }

    @Override
    public Estado delete(UUID id) {
        return estadoDAO.apagar(id);
    }
}
