package modelo;

import ui.UIMenu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivos {

    public static void archicoCitaDoctores(String fecha, String hora){

        File archivo = new File("./CitasDoctores");

        if(!archivo.exists() ) {
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
                pw.println("Doctor: "+ UIMenu.doctorRegistrado.getNombre());
                pw.println("Fecha: "+fecha);
                pw.println("Hora: "+hora);
            }
            pw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void archivoDoctores(String nombre, String direccion, String correo,  String numero,  String pass, String especialidad){
        File archivo = new File("./Doctores");

        if(!archivo.exists() ) {
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
                pw.println("Nombre: "+nombre);
                pw.println("Direccion: "+direccion);
                pw.println("Correo: "+correo);
                pw.println("Numero: "+numero);
                pw.println("Contraseña: "+pass);
                pw.println("Estatus activo");
                pw.println("Especialidad: "+especialidad);
            }
            pw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void archivoPacientes(String nombrep, String correop, String direccionp, String telefonop, String passp, String fecha, String sangre, float peso, float altura){
        File archivo = new File("./Pacientes");

        if(!archivo.exists() ) {
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
                pw.println("Nombre: "+nombrep);
                pw.println("Direccion: "+direccionp);
                pw.println("Correo: "+correop);
                pw.println("Numero: "+telefonop);
                pw.println("Contraseña: "+passp);
                pw.println("Estatus activo");
                pw.println("Tipo de sangre: "+sangre);
                pw.println("Altura: "+altura);
                pw.println("Peso: "+peso);
            }
            pw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}




