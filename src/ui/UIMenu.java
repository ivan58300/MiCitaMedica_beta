package ui;

import modelo.Doctor;
import modelo.Paciente;


import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static final String[] MESES = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static Doctor doctorRegistrado;
    public static Paciente pacienteRegistrado;
    public  static int seccion = 0;

    public static void mostrarMenu() {
        System.out.println("\t - Bienvenido a Mi Cita Medica -");
        verificarUsuario();
        if(seccion == 0 ){
            System.out.println("Gracias por usar Mi Cita Medica.");
        }

    }

    private static void verificarUsuario( ) {


        ArrayList<Doctor> doctores = new ArrayList<>();
        doctores.add(new Doctor( "Ivanoe", "ivan@email.com", "Santa Catarina, N.L.",
                "10935355","ivan123",true,"Cardiología" ));
        doctores.add(new Doctor( "Samuel", "samuel@email.com", "Santa Catarina, N.L.",
                "10935356","samuel123",false,"Cirugía Pediátrica" ));
        doctores.add(new Doctor("a", "aa", " ", "12345678", "s", true, "q"));

        ArrayList <Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Paciente("Juan","juan@email.com", "Juarez, N.L.", "12345678","juan123", true ,"12/12/2000","B+" ,89.5, 1.80 ));
        pacientes.add(new Paciente("Taylor Perez","taylor@email.com"));
        pacientes.add(new Paciente("Tyrone  Perez","tyrone@email.com"));

        boolean usuarioCorrecto = false;
        boolean contrasenaCorrecta = false;
        String contrasena = null;
        do{
            System.out.println("Inserta tu correo electrónico.  : [user@email.com] (digite 0 para salir)");
            Scanner sc = new Scanner(System.in);
            String usuario = sc.nextLine();

            if( usuario.equals("0")){
                usuarioCorrecto = true;
            }else{
                System.out.println("Ingrese su contraseña: ");
                contrasena = sc.nextLine();
            }


            for(Doctor d : doctores) {
                if (d.getEmail().equals(usuario)) {
                    if (d.getContrasena().equals(contrasena)){
                        //obtener el registro del doctor
                        doctorRegistrado = d;
                        UIMenuDoctor.mostrarMenuDoctor();
                        usuarioCorrecto = true;
                        contrasenaCorrecta = true;

                    }

                }
            }
            for( Paciente p : pacientes) {
                if (p.getEmail().equals(usuario)) {
                    if(p.getContrasena().equals(contrasena)){
                        pacienteRegistrado = p;
                        UIMenuPaciente.mostrarMenuPaciente();
                        usuarioCorrecto = true;
                        contrasenaCorrecta = true;
                    }

                }
            }
            if(!contrasenaCorrecta && !(usuario.equals("0"))){
                System.out.println("Contraseña o Usuario invalida\nIntente de nuevo \n\n");
            }


        }while (!usuarioCorrecto);
    }



}

