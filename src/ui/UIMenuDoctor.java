package ui;

import modelo.Doctor;
import modelo.DoctorCita;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class UIMenuDoctor {

    public static ArrayList<Doctor> citasDisponiblesDoctores = new ArrayList<>();


    public static void mostrarMenuDoctor() {
        int respuesta;
        do {
            System.out.println("\n\n");
            System.out.println("\t - Doctor -");
            System.out.println("Bienvenido  DR. " + UIMenu.doctorRegistrado.getNombre());
            System.out.println("1.- Agregar cita disponible");
            System.out.println("2.- Mi cita programada");
            System.out.println("0.- Cerrar sección ");

            Scanner sc = new Scanner(System.in);
            respuesta = sc.nextInt();
            Date fechaActual = new Date();

            switch (respuesta) {
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
        } while (respuesta != 0);
    }

    private static void mostrarMenuAgregarCitasDisponibles(Date fechaActual) {
        int respuesta = 0;
        do {
            System.out.println();
            System.out.println("::Agregar citas disponibles ");
            System.out.println("::Selecciona un mes ");

            final int MES_ACTUAL = fechaActual.getMonth();
            final int YEAR_ACTUAL = fechaActual.getYear() + 1900;
            final int DAY_ACTUAL = fechaActual.getDay();

            int j = 1;
            for (int meses = MES_ACTUAL; meses < MES_ACTUAL + 3; meses++) {

                if (meses > 11) {
                    System.out.println(j++ + ". " + UIMenu.MESES[meses - 12]);
                } else {
                    System.out.println(j++ + ". " + UIMenu.MESES[meses]);
                }

            }
            System.out.println("0. Regresar.");

            Scanner sc = new Scanner(System.in);
            respuesta = Integer.valueOf(sc.nextLine());

            if (respuesta > 0 && respuesta < 4) {
                //1,2,3
                int mesSeleccionado = MES_ACTUAL + respuesta;//aux
                System.out.println(respuesta + ". " + UIMenu.MESES[mesSeleccionado - 1]);

                int fechadia;
                do {
                    System.out.println("Inserte el dia disponible en el mes de " + UIMenu.MESES[mesSeleccionado - 1]);
                    fechadia = Integer.valueOf(sc.nextLine());
                    System.out.println(fechadia);
                } while (fechadia < DAY_ACTUAL || fechadia > 31);

                int fechaano;
                do {
                    System.out.println("Ahora inserte el Año de la cita: ");
                    fechaano = Integer.valueOf(sc.nextLine());
                } while (fechaano < YEAR_ACTUAL);

                String fecha = fechadia + "/" + mesSeleccionado + "/" + fechaano;

                System.out.println("Tu fecha es : " + fecha + "\n1. Correcto \n2. Cambiar fecha");

                int respuestaFecha = Integer.valueOf(sc.nextLine());

                if (respuestaFecha == 2) continue;

                int respuestaHora = 0;
                String hora = "";
                do {
                    System.out.println("A continuacion se le pedira la hora disponible para la fecha: " + fecha + " [HH:mm] ");
                    int horas;
                    do {
                        System.out.println("Escriba la hora: [HH]");
                        horas = Integer.valueOf(sc.nextLine());
                    } while (horas > 23);

                    int minutos;
                    do {
                        System.out.println("Escriba los minutos: [mm] ");
                        minutos = Integer.valueOf(sc.nextLine());
                    } while (minutos > 59);
                    hora = horas + ":" + minutos;
                    System.out.println("La Hora: " + hora + " es correcto  \n1.Correcto\n2. Cambiar hora");
                    respuestaHora = Integer.valueOf(sc.nextLine());
                } while (respuestaHora == 2);
                //registro de fechas disponibles.
                UIMenu.doctorRegistrado.agregarCitasDisponibles(fecha, hora);
                checkCitaDisponibleDoctor(UIMenu.doctorRegistrado);
                modelo.Archivos.archivoCitaDoctores(fecha,hora);
                 
                File archivo = new File("./CitasDoctores");
                if(!archivo.exists()) {
                	try {
                		archivo.createNewFile();
                	}catch (IOException e) {
                		e.printStackTrace();
                	}
                }
                
                try {
                	FileWriter fw = new FileWriter(archivo, true);
                	PrintWriter pw = new PrintWriter(fw);
                	
                	if(!pw.checkError()) {
                		pw.println("Doctor: "+UIMenu.doctorRegistrado.getNombre());
                		pw.println("Fecha: "+fecha);
                		pw.println("Hora: "+hora);
                	}
                	pw.close();
                }catch (IOException e) {
                	e.printStackTrace();
                }
            } else if (respuesta == 0) {
                mostrarMenuDoctor();
            }

        } while (respuesta != 0);
    }

    private static void checkCitaDisponibleDoctor(Doctor doctor) {
        if (doctor.getCitaDisponibles().size() > 0 && !citasDisponiblesDoctores.contains(doctor)) {
            citasDisponiblesDoctores.add(doctor);
        }
    }

    //los datos del paciente que eligio una cita con este doctor
    private static void mostrarListaCitasConfirmadas() {
        int response = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("::Mis citas");
            if (UIMenu.pacienteRegistrado.getDoctorCitas().size() == 0) {
                do {
                    System.out.println("\nNo tiene citas.");
                    System.out.println("\n0. Regresar");
                    response = Integer.valueOf(sc.nextLine());
                } while (response != 0);
                UIMenuPaciente.mostrarMenuPaciente();
                break;

            }

            for (int i = 0; i < UIMenu.pacienteRegistrado.getDoctorCitas().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". " +
                        "\nId : " + UIMenu.pacienteRegistrado.getDoctorCitas().get(i).getId() +
                        "\nFecha : " + UIMenu.pacienteRegistrado.getDoctorCitas().get(i).getfecha() +
                        "\nHora  : " + UIMenu.pacienteRegistrado.getDoctorCitas().get(i).getHora() +
                        "\nPaciente: " + UIMenu.pacienteRegistrado.getDoctorCitas().get(i).getPaciente().getNombre()+
                        "\n");
            }

            System.out.println("0. Regresar. ");
            response = Integer.valueOf(sc.nextLine());
            if (response == 0) {
                mostrarMenuDoctor();
            }

        } while (response != 0);
    }
}

