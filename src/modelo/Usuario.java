package modelo;

public abstract class Usuario {

    private  int id;
    private String nombre;
    private String email;
    private String direccion;
    private String numeroTel;
    private String contrasena;
    private boolean estatus;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    public Usuario(){
    }

    public Usuario(String nombre, String email, String direccion, String numeroTel, String contrasena, boolean estatus) {
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.numeroTel = numeroTel;
        this.contrasena = contrasena;
        this.estatus = estatus;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
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
                "\nDirección : "+ direccion +". Telefono: "+ numeroTel;
    }
}
