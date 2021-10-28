package ui;

import modelo.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIMenuPaciente {

    public static void mostrarMenuPaciente(){
        int respuesta = 0;
        do {

            System.out.println("\n\n");
            System.out.println("\t- Paciente -");
            System.out.println("Bienvenido(a): " + UIMenu.pacienteRegistrado.getNombre());
            System.out.println("1. Reservar una cita");
            System.out.println("2. Mis citas");
            System.out.println("0. Regresar ");

            Scanner sc = new Scanner(System.in);
            respuesta = Integer.valueOf(sc.nextLine());

            switch (respuesta){
                case 1:
                    mostrarMenuReservarCita();
                    break;
                case 2:
                    mostrarCitasPacientes();
                    break;
                case 0:
                    UIMenu.mostrarMenu();
                    break;

            }

        }while (respuesta != 0);
    }

    private static void mostrarMenuReservarCita(){
        int respuesta = 0;
        do {
            System.out.println("::Reservar una cita");
            System.out.println("::Seleccione fecha: ");
            //K = numeración de la lista de fechas
            //indice fecha seleccionada
            //[Doctors]
            /*
             * 1.- doctor1
             *           1.- fecha1
             *           2.- fecha2
             * 2.- doctor2
             * 3.- doctor3
             * */
            Map<Integer, Map<Integer, Doctor>> doctores = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIMenuDoctor.citasDisponiblesDoctores.size() ; i++) {
                ArrayList<Doctor.CitaDisponible> citaDisponibles = UIMenuDoctor.citasDisponiblesDoctores.get(i).getCitaDisponibles();

                Map<Integer, Doctor> citasDoctor = new TreeMap<>();
                for (int j = 0; j < citaDisponibles.size(); j++) {
                    k++;
                    System.out.println(k + ". " + citaDisponibles.get(j).getFecha());
                    citasDoctor.put(Integer.valueOf(j), UIMenuDoctor.citasDisponiblesDoctores.get(i));
                    doctores.put(Integer.valueOf(k), citasDoctor);

                }
            }
            Scanner sc = new Scanner(System.in);
            int respuestaFechaSeleccionada = Integer.valueOf(sc.nextLine());

            Map<Integer, Doctor> doctorDisponibleSeleccionado = doctores.get(respuestaFechaSeleccionada);
            Integer fechaIndice = 0;
            Doctor doctorSeleccionado = new Doctor();

            for (Map.Entry<Integer, Doctor> doc : doctorDisponibleSeleccionado.entrySet()) {
                fechaIndice = doc.getKey();
                doctorSeleccionado = doc.getValue();
            }

            System.out.println("Dr. " + doctorSeleccionado.getNombre() +
                    ". Date: " + doctorSeleccionado.getCitaDisponibles().get(fechaIndice).getFecha() +
                    ". Time: " + doctorSeleccionado.getCitaDisponibles().get(fechaIndice).getHora() +
                    "\n");

            System.out.println("Confirma tu cita: \n1. Confirmar.\n2. Cambiar Fecha.");
            respuesta = Integer.valueOf(sc.nextLine());

            if (respuesta == 1){
                UIMenu.pacienteRegistrado.addDoctorCitas(doctorSeleccionado,
                        doctorSeleccionado.getCitaDisponibles().get(fechaIndice).getDate(null),
                        doctorSeleccionado.getCitaDisponibles().get(fechaIndice).getHora());
                mostrarMenuPaciente();

            }
        }while(respuesta != 0);
    }

    private static void mostrarCitasPacientes(){
        int response = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("::Mis citas");
            if(UIMenu.pacienteRegistrado.getDoctorCitas().size() == 0){
                System.out.println("No tiene citas.");
                break;
            }

            for (int i = 0; i < UIMenu.pacienteRegistrado.getDoctorCitas().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". " +
                        "\nFecha : " + UIMenu.pacienteRegistrado.getDoctorCitas().get(i).getFecha() +
                        "\nHora  : " + UIMenu.pacienteRegistrado.getDoctorCitas().get(i).getHora() +
                        "\nDoctor: " + UIMenu.pacienteRegistrado.getDoctorCitas().get(i).getDoctor().getNombre() +
                        "\n");
            }

            System.out.println("0. Regresar. ");
            response = Integer.valueOf(sc.nextLine());
        }while(response != 0);
    }
}

