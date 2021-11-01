package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Usuario{
    ArrayList<Doctor> doctores = new ArrayList<>();
    public Administrador(int id, String nombre, String email, String contrasena) {
        super(id, nombre, email, contrasena);
    }
private static void agragarDoctor(){
    System.out.println("Ingresar nombre del Doctor: ");
    Scanner sc = new Scanner(System.in);
    String nombre = sc.nextLine();
    //Int numero = Integer.valueOf(sc.nextLine());
    doctores.add(new Doctor( nombre, "ivan@email.com", "Santa Catarina, N.L.",
            "10935355","ivan123",true,"Cardiología" ));
}
}
