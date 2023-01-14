package Controler.impl;

import Controler.CidadeController;
import Model.Cidade;

import java.util.UUID;

public class CidadeArmazenamentoController implements CidadeController {
    @Override
    public void cadastrar(Cidade cidade) {
            System.out.println("Cidade: " + cidade.getNome() + " Estado: " + cidade.getEstado()); //Não esquecer de tirar no proximo passo
        }



    @Override
    public Cidade ler(UUID id) {
        return null;
    }

    @Override
    public Cidade update(UUID id, Cidade cidade) {
        return null;
    }

    @Override
    public Cidade Delete(UUID id) {
        return null;
    }



}
