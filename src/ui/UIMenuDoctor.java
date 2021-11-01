package ui;

import modelo.Doctor;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class UIMenuDoctor {

    public static ArrayList<Doctor> citasDisponiblesDoctores = new ArrayList<>();


    public static void mostrarMenuDoctor(){
        int respuesta;
        do{
            System.out.println("\n\n");
            System.out.println("\t - Doctor -");
            System.out.println("Bienvenido  DR. " + UIMenu.doctorRegistrado.getNombre());
            System.out.println("1.- Agregar cita disponible");
            System.out.println("2.- Mi cita programada");
            System.out.println("0.- Cerrar sesión ");

            Scanner sc = new Scanner(System.in);
            respuesta = sc.nextInt();
            Date fechaActual = new Date();

            switch (respuesta){
                case 1:
                    respuesta = 0;
                    mostrarMenuAgregarCitasDisponibles(fechaActual);
                    break;
                case 2:
                    respuesta = 0;
                    mostrarListaCitasConfirmadas();

                    break;
                case 0:

                    UIMenu.mostrarMenu();
                    UIMenu.seccion = 1;
                    break;
            }
        }while (respuesta != 0);
    }

    private static void mostrarMenuAgregarCitasDisponibles(Date fechaActual){
        int respuesta=0;
        do {
            System.out.println();
            System.out.println("::Agregar citas disponibles ");
            System.out.println("::Selecciona un mes ");

            final int MES_ACTUAL = fechaActual.getMonth();
            final int YEAR_ACTUAL = fechaActual.getYear();
            final int DAY_ACTUAL  = fechaActual.getDay();

            int j = 1;
            for ( int meses = MES_ACTUAL ; meses < MES_ACTUAL+3; meses++){
                System.out.println(j++ + ". " + UIMenu.MESES[meses]);
            }
            System.out.println("0. Regresar.");

            Scanner sc = new Scanner(System.in);
            respuesta = Integer.valueOf(sc.nextLine());

            if( respuesta > 0 && respuesta < 4){
                //1,2,3
                int mesSeleccionado = MES_ACTUAL + respuesta;//aux
                System.out.println(respuesta + ". " + UIMenu.MESES[mesSeleccionado-1]);

                //modificar la fecha solo ingresar el dia
                System.out.println("Inserte la fecha disponible: [dd/mm/aaaa]");
                String fecha = sc.nextLine();

                System.out.println("Tu fecha es : " + fecha + "\n1. Correcto \n2. Cambiar fecha");

                int respuestaFecha = Integer.valueOf(sc.nextLine());

                if( respuestaFecha == 2) continue;

                int respuestaHora = 0;
                String hora ="";
                do {
                    System.out.println("Inserte la hora disponible para la fecha: " + fecha + " [HH:mm] ");
                    //validar la que exista la hora
                    hora = sc.nextLine();
                    System.out.println("Tu hora es: " + hora + "\n1. Correcto. \n2. Cambiar hora.");
                    respuestaHora = Integer.valueOf(sc.nextLine());
                }while ( respuestaHora == 2);
                //registro de fechas disponibles.
                UIMenu.doctorRegistrado.agregarCitasDisponibles(fecha,hora);
                checkCitaDisponibleDoctor(UIMenu.doctorRegistrado);

            }else if (respuesta == 0){
                mostrarMenuDoctor();
            }

        }while (respuesta != 0);
    }

    private  static void checkCitaDisponibleDoctor (Doctor doctor){
        if (doctor.getCitaDisponibles().size() > 0
                && !citasDisponiblesDoctores.contains(doctor)){
            citasDisponiblesDoctores.add(doctor);
        }
    }
    //los datos del paciente que eligio una cita con este doctor
    private static void mostrarListaCitasConfirmadas(){

    }
}

