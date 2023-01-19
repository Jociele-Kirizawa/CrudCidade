package br.com.ada.cru.Controler.impl;

import br.com.ada.cru.Model.Pais;
import br.com.ada.cru.Controler.exceptions.PaisNaoEncontrada;

import java.util.*;

public class PaisArmazenamentoController implements PaisController {

    private Map<UUID, Pais> paises = new HashMap<>();

    Scanner scan = new Scanner(System.in);

    @Override
    public List<Pais> listar() {
        return new ArrayList<>(paises.values());
    }

    @Override
    public void cadastrar(Pais pais) {
        pais.setId(UUID.randomUUID());
        paises.put(pais.getId(), pais);

   }
   @Override
    public Pais ler(UUID id) {
        Pais encontrado = paises.get(id);
        if (encontrado == null ){
            throw new PaisNaoEncontrada();
        }

        return encontrado ;
    }

    @Override
    public void update(UUID id, Pais pais) {
        if (paises.containsKey(id)){
            paises.put(id,pais);
        }else{
            throw new PaisNaoEncontrada();
        }

    }

    @Override
    public Pais delete(UUID id) {
        Pais apagado = paises.remove(id);
        return apagado;

    }
}
