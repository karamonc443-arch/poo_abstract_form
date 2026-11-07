package org.karamon.poo.abstracta.form.validador;

public class NumeroValidador extends Validador {
    protected String mensaje = " El campo %s debe ser un número";

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
        try {
            Integer.parseInt(valor);
            return true;

        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
