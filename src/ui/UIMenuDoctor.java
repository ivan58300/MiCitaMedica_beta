package ui;

import modelo.Doctor;
import java.util.ArrayList;
import java.util.Scanner;

public class UIMenuDoctor {

    public static ArrayList<Doctor> citasDisponiblesDoctores = new ArrayList<>();

    public static void mostrarMenuDoctor(){
        int respuesta = 0;
        do{
            System.out.println("\n\n");
            System.out.println("\t - Doctor -");
            System.out.println("Bienvenido  DR. " + UIMenu.doctorRegistrado.getNombre());
            System.out.println("1.- Agregar cita disponible");
            System.out.println("2.- Mi cita programada");
            System.out.println("0.- Regresar ");

            Scanner sc = new Scanner(System.in);
            respuesta = Integer.valueOf(sc.nextLine());

            switch (respuesta){
                case 1:
                    mostrarMenuAgregarCitasDisponibles();
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.mostrarMenu();
                    break;
            }
        }while (respuesta != 0);
    }

    private static void mostrarMenuAgregarCitasDisponibles(){
        int respuesta = 0;
        do {
            System.out.println();
            System.out.println("::Agregar citas disponibles ");
            System.out.println("::Selecciona un mes ");

            for (int i = 0; i < 3; i++){
                int j = i + 1;//variable aux
                System.out.println(j + ". " + UIMenu.MESES[i]);
            }
            System.out.println("\n0. Regresar.");

            Scanner sc = new Scanner(System.in);
            respuesta = Integer.valueOf(sc.nextLine());

            if( respuesta > 0 && respuesta < 4){
                //1,2,3
                int mesSeleccionado = respuesta;//aux
                System.out.println(mesSeleccionado + ". " + UIMenu.MESES[mesSeleccionado-1]);

                System.out.println("Inserte la fecha disponible: [dd/mm/aaaa]");
                String fecha = sc.nextLine();

                System.out.println("Tu fecha es : " + fecha + "\n1. Correcto \n2. Cambiar fecha");
                int respuestaFecha = Integer.valueOf(sc.nextLine());
                if( respuestaFecha == 2) continue;

                int respuestaHora = 0;
                String hora = "";
                do {
                    System.out.println("Inserte la hora disponible para la fecha: " + fecha + " [HH:mm] ");
                    hora = sc.nextLine();
                    System.out.println("Tu hora es: " + hora + "\n1. Correcto. \n2. Cambiar hora.");
                    respuestaHora = Integer.valueOf(sc.nextLine());
                }while ( respuestaHora == 2);

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
}

