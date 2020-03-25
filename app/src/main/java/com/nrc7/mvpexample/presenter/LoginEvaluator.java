package com.nrc7.mvpexample.presenter;

public class LoginEvaluator {

    // Interface == null, se cae
    IEvaluador evaluador;

    // Interface != null, se ejecuta
    public LoginEvaluator(IEvaluador evaluador) {
        this.evaluador = evaluador;
    }

    public void evaluarPassword(String password) {
        if (password.length() >= 6) {
            // Exito
            evaluador.logged();
        } else {
            // Fallo
            evaluador.notLogged();
        }
    }
}
