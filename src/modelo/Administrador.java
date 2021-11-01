package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Usuario{

    ArrayList<Doctor> doctores = new ArrayList<>();
    private Int Id;
    public Administrador(int id, String nombre, String email, String contrasena) {
        super(id, nombre, email, contrasena);
    }

    @Override
    public Int getId() {
        return Id;
    }

    public void setId(Int id) {
        Id = id;
    }

    private static void agragarDoctor(){
    System.out.println("Ingresar nombre del Doctor: ");
    Scanner sc = new Scanner(System.in);
    String nombre = sc.nextLine();
    System.out.println("Ingresar el correo del Doctor: ");
    String correo = sc.nextLine();
    System.out.println("Ingresar la direccion del Doctor: ");
    String direccion = sc.nextLine();
    System.out.println("Ingresar numero del Doctor: ");
    String numero = sc.nextLine();
    System.out.println("Ingresar contraseña del Doctor: ");
    String pass = sc.nextLine();
    boolean estatus = true;
    System.out.println("Ingresar especialidad del Doctor: ");
    String especialidad = sc.nextLine();

    //Int numero = Integer.valueOf(sc.nextLine());
    doctores.add(new Doctor( nombre, correo, direccion,
            numero,pass,true, ));
}
}
