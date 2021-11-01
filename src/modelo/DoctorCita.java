package modelo;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DoctorCita implements IProgramable{

    private static int id =0 ;
    private Paciente paciente;
    private Doctor doctor;
    private Date fecha;
    private String hora;

    SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");

    //costructor
    public DoctorCita(Paciente paciente, Doctor doctor,int id) {
        this.paciente = paciente;
        this.doctor = doctor;
        this.id = id++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getFecha(String DATE) {
        return fecha;
    }
    public String getfecha(){
        return format.format(fecha);
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public void programable(Date fecha, String hora) {
        this.fecha = fecha;
        this.hora = hora;
    }
}

