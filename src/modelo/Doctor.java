package modelo;

import sun.management.counter.StringCounter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends Usuario {

    //Atributos
    private String especialidad;

    public Doctor(String nombre, String email, String direccion, String numeroTel, String contrasena, boolean estatus, String especialidad) {
        super(nombre, email, direccion, numeroTel, contrasena, estatus);
        this.especialidad = especialidad;
    }
    public Doctor(){
    }

    ArrayList<CitaDisponible> citaDisponibles = new ArrayList<>();
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void agregarCitasDisponibles(String fecha, String hora) {
        citaDisponibles.add(new CitaDisponible(fecha,hora));
    }
    public ArrayList<CitaDisponible> getCitaDisponibles(){
        return citaDisponibles;
    }

    public static class CitaDisponible {
        private int id;
        private Date fecha;
        private String hora;
        /*
         * vamos a usar esta clase para formatear fechas y poder trabajar con fechas
         * vamos a usar el método parse(String); que convierte el String en Date.
         * */
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");


        public CitaDisponible(String fecha, String hora) {
            try {
                this.fecha = format.parse(fecha);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.hora = hora;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate(){//el parametro es para saber que este metodo me va a devolver un Date
            return fecha;
        }
        public String getFecha() {
            return format.format(fecha);
        }
        public String getFecha(Date date){
            return format.format(date);
        }

        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }

        public String getHora() {
            return hora + " Hrs.";
        }

        public void setHora(String hora) {
            this.hora = hora;
        }

        @Override
        public String toString() {
            return "Citas disponibles" +
                    "\ndate: " + fecha +
                    "\ntime: " + hora;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSpeciality: " + especialidad +
                "\nAvailable: " + citaDisponibles.toString() ;
    }



}
