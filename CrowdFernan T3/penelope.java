import java.util.Scanner;
import static funciones.funciones.*;

public class penelope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            inicioSesion();
            opcion = si();
            switch (opcion) {
                case 1: {
                    System.out.println("Bienvenido al sistema de proyectos. Por favor, inicia sesión.");
                    do{
                        System.out.print("Usuario: ");
                        usuario = scanner.nextLine();
                        System.out.print("Contraseña: ");
                        contrasena = scanner.nextLine();

                        if (validarCredenciales(usuario, contrasena)) {
                            System.out.println("Inicio de sesión exitoso.");
                            break;
                        } else {
                            System.out.println("Credenciales incorrectas. Intenta nuevamente.");
                        }
                    }while (true);
                    if (usuario.equals(GESTOR_USUARIO) && contrasena.equals(GESTOR_CONTRASENA)) {
                        destinatarioGmail();
                        System.out.print("Introduce Verificación en 2 pasos: ");
                        int verificacion = si();
                        if (verificacion == numeroVerificacion) {

                            do {
                                menuGestor();
                                opcion = si();
                                mostrarMenuGestor();
                            } while (opcion != 4);
                        }
                        else System.out.println("Error.");
                        break;
                    } else if (usuario.equals(INVERSOR1_USUARIO) && contrasena.equals(INVERSOR1_CONTRASENA)) {
                        destinatarioGmail();
                        System.out.print("Introduce Verificación en 2 pasos: ");
                        int verificacion = si();
                        if (verificacion == numeroVerificacion) {
                            do {
                                menuInversor();
                                opcion = si();
                                mostrarMenuInversor1();
                            } while (opcion != 5);
                        }
                        else System.out.println("Error.");
                        break;
                    } else if (usuario.equals(INVERSOR2_USUARIO) && contrasena.equals(INVERSOR2_CONTRASENA)) {
                        destinatarioGmail();
                        System.out.print("Introduce Verificación en 2 pasos: ");
                        int verificacion = si();
                        if (verificacion == numeroVerificacion) {
                        do {
                            menuInversor();
                            opcion = si();
                            mostrarMenuInversor2();
                        } while (opcion != 5);
                    }
                    else System.out.println("Error.");
                    break;
                    } else if (usuario.equals(ADMIN_USUARIO) && contrasena.equals(ADMIN_CONTRASENA)) {
                        destinatarioGmail();
                        System.out.print("Introduce Verificación en 2 pasos: ");
                        int verificacion = si();
                        if (verificacion == numeroVerificacion) {
                        do {
                            menuAdmin();
                            respuesta8 = si();
                            mostrarMenuAdmin();

                        }while(respuesta8 != 5);
                        }
                        else System.out.println("Error.");
                        break;
                    }
                    break;
                }
                case 2: {
                    System.out.println("Sesión cerrada. ¡Hasta luego!");
                    return;
                }
                default:
                    System.out.println("Por favor, ingrese los números 1-2.");
            }
        }while (opcion != 2);
    }
}