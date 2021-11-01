package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Paciente extends Usuario{
    //atributos
    private String fechaNacimiento;
    private String sangre;
    private double peso;
    private double altura;

    private ArrayList<DoctorCita> doctorCitas = new ArrayList<>();

    public ArrayList<DoctorCita> getDoctorCitas() {
        return doctorCitas;
    }

    public void addDoctorCitas(Doctor doctor, Date fecha, String hora) {
        DoctorCita doctorCita = new DoctorCita(this,doctor);
        doctorCita.programable(fecha, hora);
        doctorCitas.add(doctorCita);
    }

    public Paciente(String nombre, String email) {
        super(nombre, email);
    }

    public Paciente(String nombre, String email, String direccion, String numeroTel, String contrasena, boolean estatus, String fechaNacimiento, String sangre, double peso, double altura) {
        super(nombre, email, direccion, numeroTel, contrasena, estatus);
        this.fechaNacimiento = fechaNacimiento;
        this.sangre = sangre;
        this.peso = peso;
        this.altura = altura;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSangre() {
        return sangre;
    }

    public void setSangre(String sangre) {
        this.sangre = sangre;
    }

    public String getPeso() {
        return this.peso + "Kg.";
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return this.altura + "Mts. ";
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return super.toString() + "\nFecha de nacimiento: " + fechaNacimiento + "\nPeso: " + getPeso()+ "\nAltura: "+ getAltura()+"\nSangre: "+ sangre;
    }
}
