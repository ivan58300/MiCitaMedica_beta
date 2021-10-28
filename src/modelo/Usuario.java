package modelo;

public abstract class Usuario {

    private  int id;
    private String nombre;
    private String email;
    private String direccion;
    private String numeroTel;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    public Usuario(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String addres() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        if ( numeroTel.length() > 8 ){
            System.out.println("El número telefónico debe ser de 8 dígitos máximo. ");
        }else if(numeroTel.length() == 8){
            this.numeroTel = numeroTel;
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Email: "+email+
                "\nAddreess: "+ direccion +". Phone: "+ numeroTel;
    }
}
