package br.com.ada.cru.Controler;

import br.com.ada.cru.Controler.impl.CidadeArmazenamentoController;
import br.com.ada.cru.Controler.impl.CidadeArmazenamentoDefinitivo;
import br.com.ada.cru.Model.cidade.Cidade;
import br.com.ada.cru.Model.cidade.dao.CidadeDAO;
import br.com.ada.cru.Model.cidade.dao.impl.CidadeBinaryDAO;

import java.util.List;
import java.util.UUID;

public class CidadeControllerFactory {
    CidadeController controller = null;

    public CidadeController criar(CidadeArmazenamentoTipo tipo) {
        if (tipo == CidadeArmazenamentoTipo.VOLATIL) {
            controller = new CidadeArmazenamentoController();
        } else if (tipo == CidadeArmazenamentoTipo.DEFINITIVO) {
            controller = new CidadeArmazenamentoDefinitivo(new CidadeBinaryDAO());
        } else {
            throw new RuntimeException("Nenhuma implementação disponível");
        }
        return controller;
    }
}
