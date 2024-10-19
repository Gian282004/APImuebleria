package com.muebleria.exception;

public class UsuarioNoEncontrado extends RuntimeException {
    private final Integer id;

    public UsuarioNoEncontrado(Integer id) {
        super("Usuario con ID " + id + " no encontrado.");
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
