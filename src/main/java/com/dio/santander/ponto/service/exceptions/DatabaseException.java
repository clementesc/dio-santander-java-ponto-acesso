package com.dio.santander.ponto.service.exceptions;

public class DatabaseException extends RuntimeException {
    public DatabaseException(String message){
        super(message);
    }
}
