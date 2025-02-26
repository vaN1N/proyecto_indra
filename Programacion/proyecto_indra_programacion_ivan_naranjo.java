import java.util.Scanner;

public class GestionEventos {
    // Definimos el tamaño máximo de usuarios y eventos
    static final int max_usuarios = 100;
    static final int max_eventos = 100;
    
    // Arrays para almacenar información de los usuarios
    static String[] nombresUsuarios = new String[max_usuarios];
    static String[] users = new String[max_usuarios];
    static String[] passwords = new String[max_usuarios];
    static int totalUsuarios = 0;
    
    // Arrays para almacenar información de los eventos
    static String[] nombresEventos = new String[max_eventos];
    static String[] fechasEventos = new String[max_eventos];
    static String[] ubicacionesEventos = new String[max_eventos];
    static int totalEventos = 0;
    
    // Matriz para registrar las inscripciones de usuarios en eventos
    static int[][] inscripciones = new int[max_usuarios][max_eventos];
    
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("--- Menú de Gestión de Eventos ---");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Crear evento");
            System.out.println("3. Inscribirse en un evento");
            System.out.println("4. Mostrar eventos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    crearEvento();
                    break;
                case 3:
                    inscribirseEvento();
                    break;
                case 4:
                    mostrarEventos();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Esta opcion no es valida!");
            }
        } while (opcion != 5);
    }
    
    // Función para registrar un nuevo usuario
    private static void registrarUsuario() {

        if (totalUsuarios < max_usuarios) {

            System.out.print("Nombre: ");
            nombresUsuarios[totalUsuarios] = scanner.nextLine();

            System.out.print("Usuario: ");
            users[totalUsuarios] = scanner.nextLine();

            System.out.print("Contraseña: ");
            passwords[totalUsuarios] = scanner.nextLine();
            totalUsuarios++;

            System.out.println("Usuario registrado correctamente");
        } else {
            System.out.println("Límite de usuarios alcanzado");
        }
    }
    
    // Función para crear un nuevo evento
    private static void crearEvento() {
        if (totalEventos < max_eventos) {

            System.out.print("Nombre del evento: ");
            nombresEventos[totalEventos] = scanner.nextLine();

            System.out.print("Fecha: ");
            fechasEventos[totalEventos] = scanner.nextLine();

            System.out.print("Ubicación: ");
            ubicacionesEventos[totalEventos] = scanner.nextLine();
            totalEventos++;

            System.out.println("El evento ha sido creado exitosamente");
        } else {
            System.out.println("Límite de eventos alcanzado");
        }
    }
    
    // Función para inscribir un usuario en un evento
    private static void inscribirseEvento() {
        String usuario;
        System.out.print("Ingrese su usuario: ");
        usuario = scanner.nextLine();

        int usuarioIndex = -1;
        for (int i = 0; i < totalUsuarios; i++) {
            if (users[i].equals(usuario)) {
                usuarioIndex = i;
                break;
            }
        }
        if (usuarioIndex == -1) {
            System.out.println("Usuario no encontrado");
            return;
        }
        
        System.out.print("Ingrese el nombre del evento: ");
        String evento;
        evento = scanner.nextLine();

        int eventoIndex = -1;
        for (int i = 0; i < totalEventos; i++) {
            if (nombresEventos[i].equals(evento)) {
                eventoIndex = i;
                break;
            }
        }
        if (eventoIndex == -1) {
            System.out.println("Evento no encontrado");
            return;
        }
        
        inscripciones[usuarioIndex][eventoIndex] = 1;
        System.out.println("Inscripción realizada correctamente");
    }
    
    // Función para mostrar los eventos disponibles
    private static void mostrarEventos() {
        if (totalEventos == 0) {
            System.out.println("No hay eventos registrados");
            return;
        }
        for (int i = 0; i < totalEventos; i++) {
            System.out.println("Evento: " + nombresEventos[i] + " | Fecha: " + fechasEventos[i] + " | Ubicación: " + ubicacionesEventos[i]);
        }
    }
}