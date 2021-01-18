package controllers;

import domain.EntidadBase;
import repositories.FactoryRepositorio;
import repositories.Repositorio;
import usuario.Usuario;

public class EntidadBaseController {
    private Repositorio<EntidadBase> repoEntidadBase;
    public EntidadBaseController(){
        this.repoEntidadBase = FactoryRepositorio.get(EntidadBase.class);
    }
}
