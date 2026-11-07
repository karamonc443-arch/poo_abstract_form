package org.karamon.poo.abstracta.form.validador;

public class EmailValidador extends Validador {
    private final static String EMAL_REGEX = "^(.+)@(.+)$";
    protected String mensaje = " El campo %s tiene un formato de correo inválido";

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        return valor.matches(EMAL_REGEX);
    }
}
