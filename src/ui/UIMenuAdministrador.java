package ui;

import modelo.Doctor;
import modelo.Paciente;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenuAdministrador {

    public static void mostrarMenuAdministrador(){

        int respuesta = 0;
        do {

            System.out.println("\n\n");
            System.out.println("\t- Administrador -");
            System.out.println("1. Agregar doctor");
            System.out.println("2. Agregar paciente");
            System.out.println("0. Regresar ");

            Scanner sc = new Scanner(System.in);
            respuesta = sc.nextInt();

            switch (respuesta){
                case 1:
                    respuesta = 0;
                    agregarDoctor();
                    break;
                case 2:
                    respuesta = 0;
                    agregarPaciente();
                    break;
                case 0:
                    UIMenu.mostrarMenu();
                    UIMenu.seccion = 1;
                    break;

            }

        }while (respuesta != 0);
    }

    //Metodo
    private static String  agregarDoctor(){
        boolean ban = true;

        do {
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
            System.out.println("Ingresar especialidad del Doctor: ");
            String especialidad = sc.nextLine();
            System.out.println("Los datos ingresados son correctos");
            System.out.println("1. correcto");
            System.out.println("0. Volver a ingresar datos");
            int respuesta = Integer.valueOf(sc.nextLine());

            if(respuesta  == 1){
                UIMenu.doctores.add(new Doctor(nombre,correo,direccion,numero,pass,true,especialidad));
                ban = false;
                mostrarMenuAdministrador();

            }
        }while (ban);
        //Int numero = Integer.valueOf(sc.nextLine());
        return null;
    }

    private static String agregarPaciente(){
        boolean ban = true;
        do {
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
            peso = Float.valueOf(sc.nextLine());
            System.out.println("Ingresar altura del paciente:");
            altura = Float.valueOf(sc.nextLine());
            System.out.println("Los datos ingresados son correctos");
            System.out.println("1. correcto");
            System.out.println("0. Volver a ingresar datos");
            int respuesta = Integer.valueOf(sc.nextLine());

            if (respuesta == 1)
            {
                UIMenu.pacientes.add(new Paciente(nombrep, correop, direccionp, telefonop, passp, true, fecha, sangre, peso, altura));
                ban = false;
                mostrarMenuAdministrador();
            }

        }while (ban);
        return null;
    }
}
