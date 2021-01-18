package controllers;

import domain.EntidadJuridica;
import repositories.FactoryRepositorio;
import repositories.Repositorio;
import usuario.Usuario;

public class EntidadJuridicaController {
    private Repositorio<EntidadJuridica> repoEntidadJuridica;
    public EntidadJuridicaController(){
        this.repoEntidadJuridica = FactoryRepositorio.get(EntidadJuridica.class);
    }
}
