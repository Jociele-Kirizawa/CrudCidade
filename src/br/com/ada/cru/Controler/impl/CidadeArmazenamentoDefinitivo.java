package br.com.ada.cru.Controler.impl;

import br.com.ada.cru.Controler.CidadeController;
import br.com.ada.cru.Model.cidade.Cidade;
import br.com.ada.cru.Model.cidade.dao.CidadeDAO;

import java.util.List;
import java.util.UUID;

public class CidadeArmazenamentoDefinitivo implements CidadeController {
    private CidadeDAO cidadeDAO;

    public CidadeArmazenamentoDefinitivo(
            CidadeDAO cidadeDAO

    ) {
        this.cidadeDAO = cidadeDAO;
    }

    @Override
    public List<Cidade> listar() {
        return cidadeDAO.listar();
    }

    @Override
    public void cadastrar(Cidade cidade) {
        cidade.setId(UUID.randomUUID());
        cidadeDAO.cadastrar(cidade);

    }

    @Override
    public Cidade ler(UUID id) {
        return cidadeDAO.buscar(id);
    }

    @Override
    public void update(UUID id, Cidade cidade) {
        cidadeDAO.atualizar(id, cidade);

    }

    @Override
    public Cidade Delete(UUID id) {
        return cidadeDAO.apagar(id);
    }
}
