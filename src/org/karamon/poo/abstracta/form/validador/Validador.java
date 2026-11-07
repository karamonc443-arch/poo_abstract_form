package org.karamon.poo.abstracta.form.validador;

public abstract class Validador {
    protected String mensaje;

    public abstract String getMensaje();

    public abstract void setMensaje(String mensaje);

    public abstract boolean esValido(String valor);
}
