package br.com.ada.cru.Model.cidade.dao.impl;

public class DAOException extends RuntimeException{

    public DAOException(String message, Exception cause) {
        super(message, cause);
    }
}
