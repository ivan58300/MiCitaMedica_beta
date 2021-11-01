package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Usuario{
    //Atributos
    private int id;

    //Constructor
    public Administrador(int id, String nombre, String email, String contrasena) {
        super(id, nombre, email, contrasena);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

}
