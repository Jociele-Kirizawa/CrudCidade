package br.com.ada.cru.Controler.impl;

import br.com.ada.cru.Controler.CidadeArmazenamentoTipo;
import br.com.ada.cru.Controler.CidadeController;
import br.com.ada.cru.Model.cidade.dao.impl.CidadeBinaryDAO;
import br.com.ada.cru.Model.cidade.dao.impl.PaisBinaryDAO;

public class PaisControllerFactory {
    PaisController paisController=null;
    public PaisController criar(PaisArmazenamentoTipo tipoPais) {
        if (tipoPais == PaisArmazenamentoTipo.VOLATILPAIS) {
            paisController = new PaisArmazenamentoController();
        } else if (tipoPais == PaisArmazenamentoTipo.DEFINITIVOPAIS) {
            paisController = new PaisArmazenamentoDefinitivo(new PaisBinaryDAO());
        } else {
            throw new RuntimeException("Nenhuma implementação disponível");
        }
        return paisController;
    }
}
