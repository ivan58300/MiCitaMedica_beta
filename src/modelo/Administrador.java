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

    //Metodo
    private static void agregarDoctor(){
        ArrayList<Doctor> doctores = new ArrayList<>();
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
                numero, pass,true, especialidad));
    }
    private static void agregarUsuario(){
        ArrayList <Paciente> pacientes = new ArrayList<>();
        float peso, altura;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar nombre del paciente:");
        String nombrep = sc.nextLine();
        System.out.println("Ingresar correo del paciente:");
        String correop = sc.nextLine();
        System.out.println("Ingresar direccion del paciente:");
        String direccionp = sc.nextLine();
        System.out.println("Ingresar telefono del paciente:");
        String telefonop = sc.nextLine();
        System.out.println("Ingresar contrasena del paciente:");
        String passp = sc.nextLine();
        System.out.println("Ingresar fecha de nacimiento del paciente:");
        String fecha = sc.nextLine();
        System.out.println("Ingresar tipo de sangre del paciente:");
        String sangre = sc.nextLine();
        System.out.println("Ingresar peso del paciente:");
        peso = sc.nextFloat();
        System.out.println("Ingresar altura del paciente:");
        altura = sc.nextFloat();
        pacientes.add(new Paciente(nombrep, correop, direccionp, telefonop, passp, true , fecha, sangre, peso, altura ));

    }
}
