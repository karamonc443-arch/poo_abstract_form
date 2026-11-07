package org.karamon.poo.abstracta.form.validador;

public class RequeridoValidador extends Validador {
    private String mensaje = " El campo %s es requerido";

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
        return (valor != null && valor.length() > 0);
    }
}
