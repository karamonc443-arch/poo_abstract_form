package org.karamon.poo.abstracta.form.formulario;


import org.karamon.poo.abstracta.form.elementos.ElementoForm;
import org.karamon.poo.abstracta.form.elementos.InputForm;
import org.karamon.poo.abstracta.form.elementos.TextareaForm;
import org.karamon.poo.abstracta.form.select.Opcion;
import org.karamon.poo.abstracta.form.select.SelectForm;
import org.karamon.poo.abstracta.form.validador.*;

import java.util.Arrays;
import java.util.List;

public class Formulario {
    public static void main(String[] args) {
        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("clave", "password");
        password.addValidador(new LargoValidador(6, 12));
        password.addValidador(new RequeridoValidador());
        InputForm email = new InputForm("email", "email");
        email.addValidador(new EmailValidador());
        email.addValidador(new RequeridoValidador());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());
        TextareaForm experiencia = new TextareaForm("exp", 5, 9);
        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());
        Opcion java = new Opcion("1", "Java");

        lenguaje.addOpcion(java)
                .addOpcion(new Opcion("2", "Python"))
                .addOpcion(new Opcion("3", "JavaScript"))
                .addOpcion(new Opcion("4", "TypeScript"))
                .addOpcion(new Opcion("5", "PHP").setSelected());

        ElementoForm claseAnonima = new ElementoForm("saludo") {
            @Override
            public String dibujarHtml() {
                return "<input disabled  name='" + this.nombre + "' value=\" " + this.valor + "\">";
            }
        };
        claseAnonima.setValor("Hola que tal este campo está deshabilitado!");

        username.setValor("John Doe");
        password.setValor("a1b2c");
        email.setValor("john.doe@correo.com");
        edad.setValor("28");
        experiencia.setValor("... más de 11 meses de experiencia alimentando y corrigiendo agentes de IA ...");

        List<ElementoForm> elementos = Arrays.asList(username, password, email, edad, experiencia, lenguaje, claseAnonima);

        for (ElementoForm elementoForm : elementos) {
            System.out.println(elementoForm.dibujarHtml());
            System.out.println("<br>");
        }
        elementos.forEach(elementoForm -> {
            if (!elementoForm.esValido()) {
                elementoForm.getErrores().forEach(System.out::println);
            }
        });
    }
}
