package br.com.ada.cru.Model.cidade.dao.impl;

import br.com.ada.cru.Model.cidade.Cidade;
import br.com.ada.cru.Model.cidade.dao.CidadeDAO;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CidadeBinaryDAO implements CidadeDAO {

    String diretorioRaiz = "database/binario";
    String diretorioCidade= diretorioRaiz + "/cidades";

    @Override
    public void cadastrar(Cidade cidade) {
        Path diretorio = Paths.get(diretorioCidade);
        if (!diretorio.toFile().exists()) {
            throw new RuntimeException("Diretório não disponível");
        }
        File file = new File(
                diretorio.toAbsolutePath().toString(),
                cidade.getId().toString() + ".dat"
        );

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(cidade);
            objectOutputStream.flush();
        } catch (IOException ex) {
            throw new DAOException("Falha ao trabalhar os arquivos.", ex);
        }
    }



    @Override
    public List<Cidade> listar() {
        FilenameFilter filter = (dir, nome) -> nome.endsWith(".dat");
        List<Cidade> cidades = new ArrayList<>();
        File diretorio = new File(diretorioCidade);
        for (File arquivo : diretorio.listFiles(filter)) {
            try (FileInputStream fileInputStream = new FileInputStream(arquivo);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                Object object = objectInputStream.readObject();
                if (object instanceof Cidade) {
                    Cidade cidade = (Cidade) object;
                    cidades.add(cidade);
                }
            } catch (IOException | ClassNotFoundException ex) {
                throw new DAOException("Falha na leitura do arquivo " + arquivo.getAbsolutePath(), ex);
            }
        }
        return cidades;


    }

    @Override
    public Cidade buscar(UUID id) {
        File arquivo = new File(diretorioCidade, id.toString() + ".dat");
        try (FileInputStream fileInputStream = new FileInputStream(arquivo);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Object object = objectInputStream.readObject();
            if (object instanceof Cidade) {
               return (Cidade) object;

            }else{
                return null;
            }
        } catch (IOException | ClassNotFoundException ex) {
            throw new DAOException("Falha na leitura do arquivo " + arquivo.getAbsolutePath(), ex);
        }
    }

    @Override
    public void atualizar(UUID id, Cidade cidade) {
        File arquivo = new File(diretorioCidade, id.toString() + ".dat");
        try (FileOutputStream fileOutputStream = new FileOutputStream(arquivo);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(cidade);
            objectOutputStream.flush();
        } catch (IOException ex) {
            throw new DAOException("Falha ao trabalhar os arquivos.", ex);
        }

    }

    @Override
    public Cidade apagar(UUID id) {
        Cidade cidade = buscar(id);
        if (cidade != null){
            File arquivo = new File(diretorioCidade, id.toString() + ".dat");
            arquivo.delete();
        }
        return cidade;
    }
}
