package org.karamon.poo.abstracta.form.validador;

import org.karamon.poo.abstracta.form.validador.mensaje.MensajeFormateable;

public class LargoValidador extends Validador implements MensajeFormateable {
    protected String mensaje = "El campo %s debe tener mínimo %d y máximo %d caracteres";
    private int longitudMin;
    private int longitudMax = Integer.MAX_VALUE;

    public LargoValidador() {
    }

    public LargoValidador(int longitudMin, int longitudMax) {
        this.longitudMin = longitudMin;
        this.longitudMax = longitudMax;
    }

    public void setLongitudMin(int longitudMin) {
        this.longitudMin = longitudMin;
    }

    public void setLongitudMax(int longitudMax) {
        this.longitudMax = longitudMax;
    }

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

        if (valor == null) {
            return true;
        }
        int largo = valor.length();

        return (largo >= longitudMin && largo <= longitudMax);
    }

    @Override
    public String getMensajeFormateado(String campo) {
        return this.mensaje = String.format(this.mensaje, campo, this.longitudMin, this.longitudMax);
    }
}
