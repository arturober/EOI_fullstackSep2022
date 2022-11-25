public class Usuario extends Persona {
    private String correo;
    private String password;

    public Usuario(String nombre, int edad, String correo, String password) {
        super(nombre, edad);
        this.correo = correo;
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        // Acceder a propiedades privadas de Persona (getter y setter)
        return "Usuario [nombre=" + getNombre() + ", edad=" + getEdad() + 
        ", correo=" + correo + ", password=" + password + "]";
    }

    
}
