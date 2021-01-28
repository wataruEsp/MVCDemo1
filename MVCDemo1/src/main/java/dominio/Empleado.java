package dominio;

public class Empleado {


    private int idEmpleado;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private double salario;

    public Empleado() {
    }

    public Empleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(String nombre, String apellido, String email, String telefono, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.salario = salario;
    }

    public Empleado(int idEmpleado, String nombre, String apellido, String email, String telefono, double salario) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.salario = salario;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    
    
    
    
    
    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + ", salario=" + salario + '}';
    }




    
}
