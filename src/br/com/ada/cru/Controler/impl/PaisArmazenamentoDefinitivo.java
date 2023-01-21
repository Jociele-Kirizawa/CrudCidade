package br.com.ada.cru.Controler.impl;

import br.com.ada.cru.Model.Pais;
import br.com.ada.cru.Model.cidade.dao.impl.PaisDAO;

import java.util.List;
import java.util.UUID;

public class PaisArmazenamentoDefinitivo implements PaisController{
    private  PaisDAO paisDAO;

    public PaisArmazenamentoDefinitivo(PaisDAO paisDAO) {
        this.paisDAO = paisDAO;
    }

    @Override
    public List<Pais> listar() {
        return paisDAO.listar();
    }

    @Override
    public void cadastrar(Pais pais) {
        pais.setId(UUID.randomUUID());
        paisDAO.cadastrar(pais);

    }

    @Override
    public Pais ler(UUID id) {
        return paisDAO.buscar(id);}

    @Override
    public void update(UUID id, Pais pais) {
        paisDAO.atualizar(id, pais);

    }

    @Override
    public Pais delete(UUID id) {
        return paisDAO.apagar(id);
    }
}
