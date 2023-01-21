package br.com.ada.cru.Model.cidade.dao.impl;

import br.com.ada.cru.Model.Estado;
import br.com.ada.cru.Model.cidade.Cidade;
import br.com.ada.cru.Model.cidade.dao.EstadoDAO;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class EstadoBinaryDAO implements EstadoDAO {
    String diretorioRaiz = "database/binario";
    String diretorioEstado= diretorioRaiz + "/estados";


    @Override
    public void cadastrar(Estado estado) {
        Path diretorio = Paths.get(diretorioEstado);
        if (!diretorio.toFile().exists()) {
            throw new RuntimeException("Diretório não disponível");
        }
        File file = new File(
                diretorio.toAbsolutePath().toString(),
                estado.getId().toString() + ".dat"
        );

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(estado);
            objectOutputStream.flush();
        } catch (IOException ex) {
            throw new DAOException("Falha ao trabalhar os arquivos.", ex);
        }

    }

    @Override
    public List<Estado> listar() {

        FilenameFilter filter = (dir, nome) -> nome.endsWith(".dat");
        List<Estado> estados = new ArrayList<>();
        File diretorio = new File(diretorioEstado);
        for (File arquivo : diretorio.listFiles(filter)) {
            try (FileInputStream fileInputStream = new FileInputStream(arquivo);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                Object object = objectInputStream.readObject();
                if (object instanceof Estado) {
                    Estado estado = (Estado) object;
                    estados.add(estado);
                }
            } catch (IOException | ClassNotFoundException ex) {
                throw new DAOException("Falha na leitura do arquivo " + arquivo.getAbsolutePath(), ex);
            }


        }
        return estados;
    }

    @Override
    public Estado buscar(UUID id) {
        File arquivo = new File(diretorioEstado, id.toString() + ".dat");
        try (FileInputStream fileInputStream = new FileInputStream(arquivo);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Object object = objectInputStream.readObject();
            if (object instanceof Estado) {
                return (Estado) object;
            }else{
        return null;
    }
        } catch (IOException | ClassNotFoundException ex) {
            throw new DAOException("Falha na leitura do arquivo " + arquivo.getAbsolutePath(), ex);
        }
    }

       @Override
    public void atualizar(UUID id , Estado estado )  {
        File arquivo = new File(diretorioEstado, id.toString() + ".dat");
           try (FileOutputStream fileOutputStream = new FileOutputStream(arquivo);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
               objectOutputStream.writeObject(estado);
               objectOutputStream.flush();
           } catch (IOException ex) {
               throw new DAOException("Falha ao trabalhar os arquivos.", ex);
           }

    }

    @Override
    public Estado apagar(UUID id) {
        Estado estado = buscar(id);
        if (estado != null){
            File arquivo = new File(diretorioEstado, id.toString() + ".dat");
            arquivo.delete();

        }
        return estado;
    }
}
