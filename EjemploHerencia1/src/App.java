public class App {
    public static void main(String[] args) throws Exception {
        Usuario u = new Usuario("Pepito", 23, "1234", "pe@pito.com");
        System.out.println(u.getNombre());
        System.out.println(u.getEdad());
        System.out.println(u.getCorreo());
        System.out.println(u.getPassword());
        System.out.println(u.toString());
    }
}
