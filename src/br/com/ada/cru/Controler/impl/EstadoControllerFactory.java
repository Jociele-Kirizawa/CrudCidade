package br.com.ada.cru.Controler.impl;


import br.com.ada.cru.Model.cidade.dao.impl.EstadoBinaryDAO;

public class EstadoControllerFactory {
    EstadoController estadoController = null;

    public EstadoController criar (EstadoArmazenamentoTipo tipoEstado){
        if (tipoEstado == EstadoArmazenamentoTipo.VOLATILESTADO){
            estadoController = new EstadoArmazenamentoController();

        } else if (tipoEstado == EstadoArmazenamentoTipo.DEFINITIVOESTADO) {
            estadoController =new EstadoArmazenamentoDefinitivo(new EstadoBinaryDAO());

        }else {
            throw new RuntimeException("Nenhuma implementação disponível");
        }
        return estadoController;
    }
}
