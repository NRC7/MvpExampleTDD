package com.nrc7.mvpexample.presenter;

public interface IEvaluador {

    // La interface lleva dos metodos
    // Uno para exito y el otro para fallo
    // Se implementa en MainActivity

    // Exito
    void logged();

    // Fallo
    void notLogged();
}
