package org.karamon.poo.abstracta.form.elementos;

import org.karamon.poo.abstracta.form.validador.Validador;
import org.karamon.poo.abstracta.form.validador.mensaje.MensajeFormateable;

import java.util.ArrayList;
import java.util.List;

public abstract class ElementoForm {
    protected String valor;
    protected String nombre;
    private List<Validador> validaores;
    private List<String> errores;

    public ElementoForm() {
        this.validaores = new ArrayList<>();
        this.errores = new ArrayList<>();
    }

    public ElementoForm(String nombre) {
        this();
        this.nombre = nombre;
    }

    public List<String> getErrores() {
        return errores;
    }


    public void setValor(String valor) {
        this.valor = valor;
    }

    public ElementoForm addValidador(Validador validador) {
        this.validaores.add(validador);
        return this;
    }

    public boolean esValido() {
        for (Validador validador : this.validaores) {
            if (!validador.esValido(this.valor)) {
                if (validador instanceof MensajeFormateable) {
                    this.errores.add(((MensajeFormateable) validador).getMensajeFormateado(nombre));
                } else {
                    this.errores.add(String.format(validador.getMensaje(), nombre));

                }
            }
        }
        return this.errores.isEmpty();
    }

    abstract public String dibujarHtml();
}
