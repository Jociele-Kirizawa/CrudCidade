package br.com.ada.cru.Model.cidade.dao.impl;

import br.com.ada.cru.Model.Estado;
import br.com.ada.cru.Model.Pais;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PaisBinaryDAO implements PaisDAO{

    String diretorioRaiz = "database/binario";
    String diretorioPais= diretorioRaiz + "/pais";

    @Override
    public void cadastrar(Pais pais) {
        Path diretorio = Paths.get(diretorioPais);
        if (!diretorio.toFile().exists()) {
            throw new RuntimeException("Diretório não disponível");
        }
        File file = new File(
                diretorio.toAbsolutePath().toString(),
                pais.getId().toString() + ".dat"
        );

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(pais);
            objectOutputStream.flush();
        } catch (IOException ex) {
            throw new DAOException("Falha ao trabalhar os arquivos.", ex);
        }

    }

    @Override
    public List<Pais> listar() {
        FilenameFilter filter = (dir, nome) -> nome.endsWith(".dat");
        List<Pais> paises = new ArrayList<>();
        File diretorio = new File(diretorioPais);
        for (File arquivo : diretorio.listFiles(filter)) {
            try (FileInputStream fileInputStream = new FileInputStream(arquivo);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                Object object = objectInputStream.readObject();
                if (object instanceof Pais) {
                    Pais pais = (Pais) object;
                    paises.add(pais);
                }
            } catch (IOException | ClassNotFoundException ex) {
                throw new DAOException("Falha na leitura do arquivo " + arquivo.getAbsolutePath(), ex);
            }


        }
        return paises;

    }

    @Override
    public Pais buscar(UUID id) {
        File arquivo = new File(diretorioPais, id.toString() + ".dat");
        try (FileInputStream fileInputStream = new FileInputStream(arquivo);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Object object = objectInputStream.readObject();
            if (object instanceof Pais) {
                return (Pais) object;
            }else{
                return null;
            }
        } catch (IOException | ClassNotFoundException ex) {
            throw new DAOException("Falha na leitura do arquivo " + arquivo.getAbsolutePath(), ex);
        }

    }

    @Override
    public void atualizar(UUID id, Pais pais) {
        File arquivo = new File(diretorioPais, id.toString() + ".dat");
        try (FileOutputStream fileOutputStream = new FileOutputStream(arquivo);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(pais);
            objectOutputStream.flush();
        } catch (IOException ex) {
            throw new DAOException("Falha ao trabalhar os arquivos.", ex);
        }

    }

    @Override
    public Pais apagar(UUID id) {
        Pais pais = buscar(id);
        if (pais!= null){
            File arquivo = new File(diretorioPais, id.toString() + ".dat");
            arquivo.delete();

        }
        return pais;
    }
}
