import java.util.Scanner;
import static funciones.FuncionEnvioCorreos.*;
import static funciones.Funciones.*;
import static funciones.Utilidades.*;

public class penelope {
    /**
     * Esta función sirve para almacenar usuario, contraseñas y los correos de los usuarios que queremos registrar.
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] usuarioGestor = new String[3][5];
        String[][] usuarioInversor = new String[3][5];

        usuarioGestor[0][0] = null;
        usuarioGestor[0][1] = null;
        usuarioGestor[0][2] = null;
        usuarioGestor[0][3] = null;
        usuarioGestor[0][4] = null;
        usuarioGestor[1][0] = null;
        usuarioGestor[1][1] = null;
        usuarioGestor[1][2] = null;
        usuarioGestor[1][3] = null;
        usuarioGestor[1][4] = null;
        usuarioGestor[2][0] = null;
        usuarioGestor[2][1] = null;
        usuarioGestor[2][2] = null;
        usuarioGestor[2][3] = null;
        usuarioGestor[2][4] = null;

        usuarioInversor[0][0] = null;
        usuarioInversor[0][1] = null;
        usuarioInversor[0][2] = null;
        usuarioInversor[0][3] = null;
        usuarioInversor[0][4] = null;
        usuarioInversor[1][0] = null;
        usuarioInversor[1][1] = null;
        usuarioInversor[1][2] = null;
        usuarioInversor[1][3] = null;
        usuarioInversor[1][4] = null;
        usuarioInversor[2][0] = null;
        usuarioInversor[2][1] = null;
        usuarioInversor[2][2] = null;
        usuarioInversor[2][3] = null;
        usuarioInversor[2][4] = null;

        do {
            inicioSesion();
            opcion1 = si();
            switch (opcion1) {
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
                    if (usuario.equals(usuarios[1]) && contrasena.equals(contrasenas[1])) {
                        destinatarioGmail();
                        System.out.print("Introduce Verificación en 2 pasos: ");
                        int verificacion = si();
                        if (verificacion == numeroVerificacion) {

                            do {
                                menuGestor();
                                opcion1 = si();
                                mostrarMenuGestor();
                            } while (opcion1 != 4);
                        }
                        else System.out.println("Error.");
                        break;
                    } else if (usuario.equals(usuarios[2]) && contrasena.equals(contrasenas[2])) {
                        destinatarioGmail();
                        System.out.print("Introduce Verificación en 2 pasos: ");
                        int verificacion = si();
                        if (verificacion == numeroVerificacion) {
                            do {
                                menuInversor();
                                opcion1 = si();
                                mostrarMenuInversor1();
                            } while (opcion1 != 5);
                        }
                        else System.out.println("Error.");
                        break;
                    } else if (usuario.equals(usuarios[3]) && contrasena.equals(contrasenas[3])) {
                        destinatarioGmail();
                        System.out.print("Introduce Verificación en 2 pasos: ");
                        int verificacion = si();
                        if (verificacion == numeroVerificacion) {
                        do {
                            menuInversor();
                            opcion1 = si();
                            mostrarMenuInversor2();
                        } while (opcion1 != 5);
                    }
                    else System.out.println("Error.");
                    break;
                    } else if (usuario.equals(usuarios[0]) && contrasena.equals(contrasenas[0])) {
                        destinatarioGmail();
                        System.out.print("Introduce Verificación en 2 pasos: ");
                        int verificacion = si();
                        if (verificacion == numeroVerificacion) {
                        do {
                            menuAdmin();
                            opcion1 = si();
                            mostrarMenuAdmin();

                        }while(opcion1 != 5);
                        }
                        else System.out.println("Error.");
                        break;
                    }
                    break;
                }
                case 2: {
                    String tipoUsuario;
                    do {
                        System.out.print("Usuario (inversor) o (gestor): ");
                        tipoUsuario = ss();
                        if (!tipoUsuario.equalsIgnoreCase("inversor") && !tipoUsuario.equalsIgnoreCase("gestor")){
                            System.out.println("Escriba (inversor) o (gestor)");
                        }
                    } while (!tipoUsuario.equalsIgnoreCase("inversor") && !tipoUsuario.equalsIgnoreCase("gestor"));
                    int pos = 0;
                    boolean hayPlaza = false;
                    if (tipoUsuario.equalsIgnoreCase("gestor")){
                        while (pos < usuarioGestor[0].length && !hayPlaza) {
                            if (usuarioGestor[0][pos] == null) hayPlaza = true;
                            else pos++;
                        }
                    }
                    else {
                        while (pos < usuarioInversor[0].length && !hayPlaza) {
                            if (usuarioInversor[0][pos] == null) hayPlaza = true;
                            else pos++;
                        }
                    }
                    if (hayPlaza) {
                        System.out.print("Usuario: ");
                        usuario = ss();
                        do {
                            do {
                                System.out.print("Contraseña (mínimo 8 caracteres, con minúsculas, mayúsculas, \n" +
                                        "número y algún símbolo como -_.,*+@): ");
                                contrasena = ss();
                            } while (!validarContrasena(contrasena));
                            System.out.print("Repite la contraseña: ");
                            contrasena2 = ss();
                            if (!contrasenasIguales(contrasena, contrasena2))
                                System.out.println("Las contraseñas no son iguales.");
                        } while (!contrasenasIguales(contrasena, contrasena2));
                        System.out.print("Correo Electrónico: ");
                        String correoElectronico = ss();
                        destinatarioGmail2(correoElectronico);
                        System.out.println("Le hemos enviado un código de verificación.");
                        System.out.print("Introduce el código: ");
                        int codigoVerificacion = si();
                        if (codigoVerificacion == numeroVerificacion) {
                            System.out.println("Usuario registrado.");
                            if (tipoUsuario.equalsIgnoreCase("inversor")) {
                                usuarioInversor[0][pos] = usuario;
                                usuarioInversor[1][pos] = contrasena;
                                usuarioInversor[2][pos] = correoElectronico;
                            }
                            if (tipoUsuario.equalsIgnoreCase("gestor")) {
                                usuarioGestor[0][pos] = usuario;
                                usuarioGestor[1][pos] = contrasena;
                                usuarioGestor[2][pos] = correoElectronico;
                            }
                        }
                        break;
                    }else System.out.println("No hay lugar para más usuarios.");
                }
                case 3: {
                    System.out.println("Sesión cerrada. ¡Hasta luego!");
                    return;
                }
                default:
                    System.out.println("Por favor, ingrese los números 1-2-3.");
            }
        }while (opcion1 != 3);
    }
}